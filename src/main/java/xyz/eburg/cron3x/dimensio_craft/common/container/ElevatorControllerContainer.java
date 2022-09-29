package xyz.eburg.cron3x.dimensio_craft.common.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ElevatorControllerBlockEntity;
import xyz.eburg.cron3x.dimensio_craft.common.container.syncdata.ElevatorControllerContainerData;

public class ElevatorControllerContainer extends AbstractContainerMenu {

    private static final int dataAmount = 3; // increase if I need more data space

    private final ContainerLevelAccess containerAccess;
    public final ContainerData data;

    public ElevatorControllerContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, new ItemStackHandler(1), BlockPos.ZERO, new SimpleContainerData(dataAmount));

    }

    public ElevatorControllerContainer(int id, Inventory playerInv, ItemStackHandler slots, BlockPos pos, ContainerData data) {
        super(ModContainers.ELEVATOR_CONTROLLER.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
        this.data = data;
        final int slotSizePlus2 = 18, startX = 8, startY = 106, hotbarY = 164, inventoryY = 18;

        addSlot(new SlotItemHandler(slots, 0, 51,
                45));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 1) {
                if (!moveItemStackTo(item, 1, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, 1, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return retStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.containerAccess, player, ModBlocks.ELEVATOR_CONTROLLER.get());
    }

    public static MenuConstructor getServerContainer(ElevatorControllerBlockEntity blockEntity, BlockPos pos) {
        return (id, playerInv, player) -> new ElevatorControllerContainer(id, playerInv, blockEntity.inventory, pos, new ElevatorControllerContainerData(blockEntity, dataAmount));
    }
}

package xyz.eburg.cron3x.dimensio_craft.common.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ExampleChestBlockEntity;

public class ExampleChestContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;

    public ExampleChestContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, new ItemStackHandler(63), BlockPos.ZERO);

    }

    public ExampleChestContainer(int id, Inventory playerInv, ItemStackHandler slots, BlockPos pos) {
        super(ModContainers.EXAMPLE_CHEST.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);

        final int slotSizePlus2 = 18, startX = 8, startY = 158, hotbarY = 216, inventoryY = 18;

        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new SlotItemHandler(slots, row * 9 + column, startX + column * slotSizePlus2,
                        inventoryY + row * slotSizePlus2));
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 63) {
                if (!moveItemStackTo(item, 63, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, 63, false))
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
        return stillValid(this.containerAccess, player, ModBlocks.EXAMPLE_CHEST.get());
    }

    public static MenuConstructor getServerContainer(ExampleChestBlockEntity chest, BlockPos pos) {
        return (id, playerInv, player) -> new ExampleChestContainer(id, playerInv, chest.inventory, pos);
    }
}

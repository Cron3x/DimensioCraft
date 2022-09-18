package xyz.eburg.cron3x.dimensio_craft.common.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ExampleChestBlockEntity;

public class ExampleChestContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;

    //Client Constructor
    protected ExampleChestContainer(int id, Inventory pInventory) {
        this(id, pInventory, new ItemStackHandler(63), BlockPos.ZERO);
    }

    //Server Constructor
    public ExampleChestContainer(int id, Inventory pInventory, IItemHandler slot, BlockPos pos) {
        super(ModContainers.EXAMPLE_CHEST.get(), id);
        this.containerAccess = ContainerLevelAccess.create(pInventory.player.level, pos);

        final int slotSizePlus2 = 18, startX = 8, startY=160, hotbarY = 218, invY = 10; //slotSizePlus2 = 18, startX = 8, startY=84, hotbarY = 142, invY = 10
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 3; row++) {
                addSlot(new Slot(pInventory, 9+row*9+column, startX+column*slotSizePlus2, startY+row*slotSizePlus2));
            }
            addSlot(new Slot(pInventory, column, startX+column*slotSizePlus2,hotbarY));
        }

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 7; row++) {
                addSlot(new SlotItemHandler(slot, 9+row*column, startX+column*slotSizePlus2, invY+row*slotSizePlus2));
            }
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.containerAccess, player, ModBlocks.EXAMPLE_CHEST.get());
    }

    public static MenuConstructor getServerContainer(ExampleChestBlockEntity chest, BlockPos pos){
        return (id, playerInv, player) -> new ExampleChestContainer(id, playerInv, chest.inventory, pos);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            final ItemStack stack = slot.getItem();
            retStack = stack.copy();

            final int size = this.slots.size() - player.getInventory().getContainerSize();
            if (index < size) {
                if (!moveItemStackTo(stack, 0, this.slots.size(), false))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(stack, 0, size, false))
                return ItemStack.EMPTY;

            if (stack.isEmpty() || stack.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == retStack.getCount())
                return ItemStack.EMPTY;

            slot.onTake(player, stack);
        }

        return retStack;
    }
}

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
    public static final int INV_SIZE = 63;

    //Client Constructor
    protected ExampleChestContainer(int id, Inventory pInventory) {
        this(id, pInventory, new ItemStackHandler(INV_SIZE), BlockPos.ZERO);
    }

    //Server Constructor
    public ExampleChestContainer(int id, Inventory pInventory, IItemHandler slot, BlockPos pos) {
        super(ModContainers.EXAMPLE_CHEST.get(), id);
        this.containerAccess = ContainerLevelAccess.create(pInventory.player.level, pos);

        final int slotSizePlus2 = 18, startX = 8, startY=159, hotbarY = 217, invY = 18; //slotSizePlus2 = 18, startX = 7, startY=85, hotbarY = 143, invY = 10

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 7; column++) {
                addSlot(new SlotItemHandler(slot, row * 9 + column, startX+column*slotSizePlus2, invY+row*slotSizePlus2));
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(pInventory, 9+row*9+column, startX+column*slotSizePlus2, startY+row*slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(pInventory, column, startX + column * slotSizePlus2, hotbarY));
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
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < INV_SIZE) {
                if (!moveItemStackTo(item, INV_SIZE, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, INV_SIZE, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return retStack;
    }
}

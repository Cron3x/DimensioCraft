package xyz.eburg.cron3x.dimensio_craft.common.container;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;

public class ExampleChestContainer extends AbstractContainerMenu {
    protected ExampleChestContainer(int id, Inventory pInventory) {
        this(id, pInventory, new ItemStackHandler(63), BlockPos.ZERO, new SimpleContainerData(0));
    }
    public ExampleChestContainer(int id, Inventory pInventory, IItemHandler slot, BlockPos pos, ContainerData data) {
        super(ModContainers.EXAMPLE_CHEST.get(), id);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return false;
    }
}

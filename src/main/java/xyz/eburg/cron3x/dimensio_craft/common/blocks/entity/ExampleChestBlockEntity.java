package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.util.InventoryBlockEntity;

public class ExampleChestBlockEntity extends InventoryBlockEntity {

    public static final Component TITLE = new TranslatableComponent("container." + DimensioCraft.MOD_ID + ".example_chest");

    public ExampleChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXAMPLE_CHEST.get(), pos, state, 63);
    }
}

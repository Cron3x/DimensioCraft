package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.util.InventoryBlockEntity;

public class EnergyGenerator extends InventoryBlockEntity {
    public EnergyGenerator(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
        super(type, pos, state, 27);
    }
}
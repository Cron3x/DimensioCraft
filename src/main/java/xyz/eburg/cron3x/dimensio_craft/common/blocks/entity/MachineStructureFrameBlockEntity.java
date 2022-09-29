package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;

public class MachineStructureFrameBlockEntity extends BlockEntity {
    public static final Component TITLE = new TranslatableComponent(
            "container." + DimensioCraft.MOD_ID + ".iron_structure_frame");

    public MachineStructureFrameBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STRUCTURE_FRAME_IRON_BLOCK.get(), pos, state);
    }

}

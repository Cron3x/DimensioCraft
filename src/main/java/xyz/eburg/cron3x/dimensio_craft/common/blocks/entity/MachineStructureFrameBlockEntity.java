package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.util.InventoryBlockEntity;

public class MachineStructureFrameBlockEntity extends InventoryBlockEntity {
    public static final Component TITLE = new TranslatableComponent(
            "container." + DimensioCraft.MOD_ID + ".machine_structure_frame");

    public MachineStructureFrameBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STRUCTURE_FRAME_IRON_BLOCK.get(), pos, state, 0);
    }

}

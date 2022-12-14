package xyz.eburg.cron3x.dimensio_craft.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.blockstate.MachineStructureFrameStates;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.MachineStructureFrameBlockEntity;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;

public class MachineStructureFrameBlock extends Block implements EntityBlock {

    /*~TODO:
    *   ---<0>---
    *   Voxel shape depending on block state
    *   implement facing block state
    *   ---<0>---
    *   Implement slab, side-slab blockstate
    *   implement slave - master multiblock
    ~*/

    private static final Property<MachineStructureFrameStates> STATES = EnumProperty.create("machine_state", MachineStructureFrameStates.class);
    public MachineStructureFrameBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(STATES, MachineStructureFrameStates.DEFAULT));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MachineStructureFrameBlockEntity(pos,state);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STATES);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);

    }

}

package xyz.eburg.cron3x.dimensio_craft.common.multiblocks.space_elevator;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;

public class SpaceElevatorMultiblock {
    public SpaceElevatorMultiblock(BlockEntity masterBlockEntity, Level level) {
        this.masterBlockEntity = masterBlockEntity;
        this.level = level;
    }

    private final BlockEntity masterBlockEntity;
    private final Level level;

    public void get(){

        DimensioCraft.LOGGER.debug("SPM::get()");

        Direction face = this.masterBlockEntity.getBlockState().getValue(HorizontalDirectionalBlock.FACING);
        Boolean got = switch (face){
            case NORTH -> detectNorth();
            case EAST  -> detectEast();
            case SOUTH -> detectSouth();
            case WEST  -> detectWest();
            default -> false;
        };
    }
    private boolean detectNorth(){
        if (level.getBlockState(masterBlockEntity.getBlockPos().above()).hasBlockEntity()
                && level.getBlockEntity(masterBlockEntity.getBlockPos().above()).getType().equals(ModBlockEntities.STRUCTURE_FRAME_IRON_BLOCK.get())) {
            DimensioCraft.LOGGER.debug("Frame at: " + masterBlockEntity.getBlockPos().above());
        } else {
            DimensioCraft.LOGGER.debug("Frame at: " + masterBlockEntity.getBlockPos().above());
        }
        return true;
    }
    private boolean detectEast(){
        return false;
    }
    private boolean detectSouth(){
        return false;
    }
    private boolean detectWest(){
        return false;
    }
    private boolean isFrame(BlockPos pos){
        if (!level.getBlockState(pos).hasBlockEntity()) return false;
        if (!level.getBlockEntity(pos).getType().equals(ModBlockEntities.STRUCTURE_FRAME_IRON_BLOCK.get())) return false;
        return true;
    }
}

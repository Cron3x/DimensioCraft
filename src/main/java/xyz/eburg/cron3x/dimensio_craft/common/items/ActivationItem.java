package xyz.eburg.cron3x.dimensio_craft.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;

public class ActivationItem extends Item {

    private Level level;
    private BlockEntity masterBlockEntity;

    public ActivationItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        if (!ctx.isSecondaryUseActive()) return InteractionResult.SUCCESS;
        if (!level.getBlockState(ctx.getClickedPos()).hasBlockEntity()) return InteractionResult.SUCCESS;

        this.level = ctx.getLevel();
        this.masterBlockEntity = level.getBlockEntity(ctx.getClickedPos());

        return super.useOn(ctx);
    }

    public void getMultiblock(){
        DimensioCraft.LOGGER.debug(masterBlockEntity.getBlockPos() + ": " + masterBlockEntity.getBlockPos().asLong());

        BlockEntityType<?> bet = level.getBlockEntity(masterBlockEntity.getBlockPos()).getType();

        if (bet.equals( ModBlockEntities.ELEVATOR_CONTROLLER.get())) getSpaceElevatorMB();
    }

    public void getSpaceElevatorMB(){
        if (level.getBlockState(masterBlockEntity.getBlockPos().above()).hasBlockEntity()
                && level.getBlockEntity(masterBlockEntity.getBlockPos().above()).getType().equals(ModBlockEntities.STRUCTURE_FRAME_IRON_BLOCK.get()) {
            DimensioCraft.LOGGER.debug("Frame at: " + masterBlockEntity.getBlockPos().above());
        } else {
            DimensioCraft.LOGGER.debug("Frame at: " + masterBlockEntity.getBlockPos().above());
        }
    }
}

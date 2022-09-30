package xyz.eburg.cron3x.dimensio_craft.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ElevatorControllerBlockEntity;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;
import xyz.eburg.cron3x.dimensio_craft.common.container.ElevatorControllerContainer;
import xyz.eburg.cron3x.dimensio_craft.common.container.syncdata.custom_storage.FrameStorage;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class ElevatorControllerBlock extends HorizontalDirectionalBlock implements EntityBlock {

    private static final Property<Boolean> MULTIBLOCK = BooleanProperty.create("multiblock");

    public ElevatorControllerBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(MULTIBLOCK, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        this.getMultiBlock(ctx);
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite()).setValue(MULTIBLOCK, false);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null
                : (level0, pos, state0, blockEntity) -> ((ElevatorControllerBlockEntity) blockEntity).tick();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElevatorControllerBlockEntity(pos, state);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof final ElevatorControllerBlockEntity blockEntity) {

            /*BlockState newState = state.setValue(multiblock, true);
            level.setBlockAndUpdate(pos, newState);*/

            final MenuProvider container = new SimpleMenuProvider(ElevatorControllerContainer.getServerContainer(blockEntity, pos), ElevatorControllerBlockEntity.TITLE);
            NetworkHooks.openGui((ServerPlayer) player, container, pos);

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(MULTIBLOCK);
        builder.add(FACING);
    }

    private void getMultiBlock(BlockPlaceContext ctx) { //>  Rename: getStructureFrames;
        DimensioCraft.LOGGER.debug("getMutliBlock");
    }
}

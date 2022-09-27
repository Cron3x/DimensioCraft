package xyz.eburg.cron3x.dimensio_craft.common.blocks;

import net.minecraft.client.ParticleStatus;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ElevatorControllerBlockEntity;
import xyz.eburg.cron3x.dimensio_craft.common.container.ElevatorControllerContainer;

public class ElevatorControllerBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public ElevatorControllerBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
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
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof final ElevatorControllerBlockEntity chest) {
            BlockPos block_top_ns_l0 = pos.offset(0,1,0);
            BlockPos block_top_ns_cn_l0 = pos.offset(-1,1,0);
            BlockPos block_top_ns_cp_l0 = pos.offset(1,1,0);
            BlockPos block_base_ns_cn_l0 = pos.offset(-1,0,0);
            BlockPos block_base_ns_cp_l0 = pos.offset(1,0,0);
            BlockPos block_low_ns_l0 = pos.offset(0,-1,0);
            BlockPos block_low_ns_cn_l0 = pos.offset(-1,-1,0);
            BlockPos block_low_ns_cp_l0 = pos.offset(1,1,0);

            BlockPos block_top_ew_l0 = pos.offset(0,1,0);
            BlockPos block_top_ew_cn_l0 = pos.offset(-1,1,0);
            BlockPos block_top_ew_cp_l0 = pos.offset(1,1,0);
            BlockPos block_base_ew_cn_l0 = pos.offset(-1,0,0);
            BlockPos block_base_ew_cp_l0 = pos.offset(1,0,0);
            BlockPos block_low_ew_l0 = pos.offset(0,-1,0);
            BlockPos block_low_ew_cn_l0 = pos.offset(-1,-1,0);
            BlockPos block_low_ew_cp_l0 = pos.offset(1,1,0);


            BlockPos block_top_ns_l1 = pos.offset(0,1,0);
            BlockPos block_top_ns_cn_l1 = pos.offset(-1,1,0);
            BlockPos block_top_ns_cp_l1 = pos.offset(1,1,0);
            BlockPos block_base_ns_cn_l1 = pos.offset(-1,0,0);
            BlockPos block_base_ns_cp_l1 = pos.offset(1,0,0);
            BlockPos block_low_ns_l1 = pos.offset(0,-1,0);
            BlockPos block_low_ns_cn_l1 = pos.offset(-1,-1,0);
            BlockPos block_low_ns_cp_l1 = pos.offset(1,1,0);

            BlockPos block_top_ew_l1 = pos.offset(0,1,0);
            BlockPos block_top_ew_cn_l1 = pos.offset(-1,1,0);
            BlockPos block_top_ew_cp_l1 = pos.offset(1,1,0);
            BlockPos block_base_ew_cn_l1 = pos.offset(-1,0,0);
            BlockPos block_base_ew_cp_l1 = pos.offset(1,0,0);
            BlockPos block_low_ew_l1 = pos.offset(0,-1,0);
            BlockPos block_low_ew_cn_l1 = pos.offset(-1,-1,0);
            BlockPos block_low_ew_cp_l1 = pos.offset(1,1,0);


            BlockPos block_top_ns_l2 = pos.offset(0,1,0);
            BlockPos block_top_ns_cn_l2 = pos.offset(-1,1,0);
            BlockPos block_top_ns_cp_l2 = pos.offset(1,1,0);
            BlockPos block_base_ns_cn_l2 = pos.offset(-1,0,0);
            BlockPos block_base_ns_cp_l2 = pos.offset(1,0,0);
            BlockPos block_low_ns_l2 = pos.offset(0,-1,0);
            BlockPos block_low_ns_cn_l2 = pos.offset(-1,-1,0);
            BlockPos block_low_ns_cp_l2 = pos.offset(1,1,0);

            BlockPos block_top_ew_l2 = pos.offset(0,1,0);
            BlockPos block_top_ew_cn_l2 = pos.offset(-1,1,0);
            BlockPos block_top_ew_cp_l2 = pos.offset(1,1,0);
            BlockPos block_base_ew_cn_l2 = pos.offset(-1,0,0);
            BlockPos block_base_ew_cp_l2 = pos.offset(1,0,0);
            BlockPos block_low_ew_l2 = pos.offset(0,-1,0);
            BlockPos block_low_ew_cn_l2 = pos.offset(-1,-1,0);
            BlockPos block_low_ew_cp_l2 = pos.offset(1,1,0);
            //player.sendMessage(new TextComponent(":> (" + block_n10n1.getX()+" "+block_n10n1.getY()+" "+block_n10n1.getZ() + "): " + level.getBlockState(block_n10n1)), player.getUUID()); ;

            if (       level.getBlockState(block_low_ew_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                    && level.getBlockState(block_top_ns_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
            ){
                player.sendMessage(new TextComponent("block_low_ew + block_top_ns"), player.getUUID());
                if(      // Layer 1
                    (       level.getBlockState(block_top_ns_cn_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_top_ns_cp_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_base_ns_cp_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_base_ns_cn_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_low_ns_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_low_ns_cn_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_low_ns_cp_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                    ) || (
                            level.getBlockState(block_top_ew_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_base_ew_cn_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_base_ew_cp_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                         && level.getBlockState(block_top_ew_cn_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_top_ew_cp_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_low_ew_cn_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                         && level.getBlockState(block_low_ew_cp_l0).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                    )
                ) {
                    player.sendMessage(new TextComponent("layer0"), player.getUUID());
                    if(          // Layer 2 //TODO: Add middle block Variable and correct valid blocks
                            (       level.getBlockState(block_top_ns_cn_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_top_ns_cp_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_base_ns_cp_l1).getBlock().equals()
                                 && level.getBlockState(block_base_ns_cn_l1).getBlock().equals()
                                 && level.getBlockState(block_low_ns_l1).getBlock().equals()
                                 && level.getBlockState(block_low_ns_cn_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_low_ns_cp_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                            ) || (
                                    level.getBlockState(block_top_ew_l0).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_base_ew_cn_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_base_ew_cp_l1).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                 && level.getBlockState(block_top_ew_cn_l1).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                 && level.getBlockState(block_top_ew_cp_l1).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                 && level.getBlockState(block_low_ew_cn_l1).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                 && level.getBlockState(block_low_ew_cp_l1).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                            )
                    ) {
                        player.sendMessage(new TextComponent("layer1"), player.getUUID());
                        if(          // Layer 3
                                (       level.getBlockState(block_top_ns_cn_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_top_ns_cp_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_base_ns_cp_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_base_ns_cn_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_low_ns_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_low_ns_cn_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_low_ns_cp_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                ) || (
                                        level.getBlockState(block_top_ew_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_base_ew_cn_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_base_ew_cp_l2).getBlock().equals(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get())
                                     && level.getBlockState(block_top_ew_cn_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_top_ew_cp_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_low_ew_cn_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                     && level.getBlockState(block_low_ew_cp_l2).getBlock().equals(Blocks.LIGHT_GRAY_CONCRETE)
                                )
                        ) {
                            player.sendMessage(new TextComponent("layer2"), player.getUUID());
                        }
                    }
                }
            }

            final MenuProvider container = new SimpleMenuProvider(ElevatorControllerContainer.getServerContainer(chest, pos), ElevatorControllerBlockEntity.TITLE);
            NetworkHooks.openGui((ServerPlayer) player, container, pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}

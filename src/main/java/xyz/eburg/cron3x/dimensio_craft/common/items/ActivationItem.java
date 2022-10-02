package xyz.eburg.cron3x.dimensio_craft.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.Property;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;
import xyz.eburg.cron3x.dimensio_craft.common.multiblocks.space_elevator.SpaceElevatorMultiblock;

public class ActivationItem extends Item {

    private Level level;
    private BlockEntity masterBlockEntity;
    public ActivationItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        DimensioCraft.LOGGER.debug("useOn");
        if (level == null) return super.useOn(ctx);
        DimensioCraft.LOGGER.debug("useOn> level != null");
        //if (ctx.isSecondaryUseActive()) return super.useOn(ctx);
        if (!(level.getBlockState(ctx.getClickedPos()).hasBlockEntity())) return super.useOn(ctx);

        this.level = ctx.getLevel();
        this.masterBlockEntity = level.getBlockEntity(ctx.getClickedPos());

        DimensioCraft.LOGGER.debug("useOn2");
        ctx.getPlayer().sendMessage(new TextComponent("LOL"), ctx.getPlayer().getUUID());

        getMultiblock();

        return super.useOn(ctx);
    }

    public void getMultiblock(){
        DimensioCraft.LOGGER.debug(masterBlockEntity.getBlockPos() + ": " + masterBlockEntity.getBlockPos().asLong());

        BlockEntityType<?> bet = level.getBlockEntity(masterBlockEntity.getBlockPos()).getType();

        DimensioCraft.LOGGER.debug("AI::getMultiblock");

        if (bet.equals( ModBlockEntities.ELEVATOR_CONTROLLER.get())) new SpaceElevatorMultiblock(masterBlockEntity, level).get();
    }
}

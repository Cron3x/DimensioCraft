package xyz.eburg.cron3x.dimensio_craft.core.events;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ElevatorControllerBlockEntity;

@Mod.EventBusSubscriber(modid = DimensioCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerModEvents {
    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {
        //TODO: Add Hammer to activate machine

        BlockPos pos = event.getPos();
        BlockEntity be = event.getWorld().getBlockEntity(pos);
        if (!(be instanceof ElevatorControllerBlockEntity)) return;

        event.getPlayer().displayClientMessage(new TextComponent("Is a THE block entity"), true);
    }
}

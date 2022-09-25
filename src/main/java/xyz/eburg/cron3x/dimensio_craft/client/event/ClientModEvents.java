package xyz.eburg.cron3x.dimensio_craft.client.event;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.client.screen.ElevatorControllerScreen;
import xyz.eburg.cron3x.dimensio_craft.client.screen.ExampleChestScreen;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.container.ModContainers;

@Mod.EventBusSubscriber(modid = DimensioCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get(), RenderType.cutout());
        MenuScreens.register(ModContainers.EXAMPLE_CHEST.get(), ExampleChestScreen::new);
        MenuScreens.register(ModContainers.ELEVATOR_CONTROLLER.get(), ElevatorControllerScreen::new);
    }
}

package xyz.eburg.cron3x.dimensio_craft;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.DrawSelectionEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xyz.eburg.cron3x.dimensio_craft.client.event.ClientModEvents;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ModBlockEntities;
import xyz.eburg.cron3x.dimensio_craft.common.container.ModContainers;
import xyz.eburg.cron3x.dimensio_craft.common.items.ModItems;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DimensioCraft.MOD_ID)
public class DimensioCraft {

    public static final String MOD_ID = "dimensio_craft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public void log_info(String msg){
        LOGGER.info(msg);
    }

    public DimensioCraft() {

        //eventBus.addListener(ClientModEvents::clientSetup);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModContainers.register(eventBus);
    }
}

package xyz.eburg.cron3x.dimensio_craft.common.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DimensioCraft.MOD_ID);

    public static RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIMENSIO_CRAFT_TAB)));
    public static RegistryObject<Item> ELEVATOR_DESTINATION_CHIP = ITEMS.register("elevator_destination_chip",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIMENSIO_CRAFT_TAB)));
    public static RegistryObject<Item> ELEVATOR_UPGRADE_CHIP = ITEMS.register("elevator_upgrade_chip",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIMENSIO_CRAFT_TAB)));
    public static RegistryObject<Item> ACTIVATION_TOOL = ITEMS.register("activation_tool",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIMENSIO_CRAFT_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

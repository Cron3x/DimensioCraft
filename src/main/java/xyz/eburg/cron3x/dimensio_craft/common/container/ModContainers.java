package xyz.eburg.cron3x.dimensio_craft.common.container;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;

import java.awt.*;

public class ModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, DimensioCraft.MOD_ID);

    public static final RegistryObject<MenuType<ExampleChestContainer>> EXAMPLE_CHEST =
            CONTAINERS.register("example_chest", () -> new MenuType<>(ExampleChestContainer::new));

    public static final RegistryObject<MenuType<ElevatorControllerContainer>> ELEVATOR_CONTROLLER =
            CONTAINERS.register("elevator_controller", () -> new MenuType<>(ElevatorControllerContainer::new));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}

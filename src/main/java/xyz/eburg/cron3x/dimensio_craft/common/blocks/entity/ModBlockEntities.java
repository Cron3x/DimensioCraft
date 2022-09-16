package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.custom.;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DimensioCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<ElevatorControllerBlockEntity>> ELEVATOR_CONTROLLER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("elevator_controller_block_entity", () -> BlockEntityType.Builder.of(ElevatorControllerBlockEntity::new,
                    ModBlocks.ELEVATOR_CONTROLLER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

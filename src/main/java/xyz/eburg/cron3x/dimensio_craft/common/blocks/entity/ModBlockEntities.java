package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DimensioCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<ExampleChestBlockEntity>> EXAMPLE_CHEST = BLOCK_ENTITIES
            .register("example_chest", () -> BlockEntityType.Builder
                    .of(ExampleChestBlockEntity::new, ModBlocks.EXAMPLE_CHEST.get()).build(null));

    public static final RegistryObject<BlockEntityType<ElevatorControllerBlockEntity>> ELEVATOR_CONTROLLER = BLOCK_ENTITIES
            .register("elevator_controller", () -> BlockEntityType.Builder
                    .of(ElevatorControllerBlockEntity::new, ModBlocks.ELEVATOR_CONTROLLER.get()).build(null));

    public static final RegistryObject<BlockEntityType<EnergyGeneratorBlockEntity>> ENERGY_GENERATOR = BLOCK_ENTITIES
            .register("energy_generator", () -> BlockEntityType.Builder
                    .of(EnergyGeneratorBlockEntity::new, ModBlocks.ENERGY_GENERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<MachineStructureFrameBlockEntity>> STRUCTURE_FRAME_IRON_BLOCK = BLOCK_ENTITIES
            .register("iron_structure_frame", () -> BlockEntityType.Builder
                    .of(MachineStructureFrameBlockEntity::new, ModBlocks.STRUCTURE_FRAME_IRON_BLOCK.get()).build(null));




    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

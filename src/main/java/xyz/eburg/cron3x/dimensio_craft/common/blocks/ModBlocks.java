package xyz.eburg.cron3x.dimensio_craft.common.blocks;

import ca.weblite.objc.Proxy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.items.ModCreativeModeTab;
import xyz.eburg.cron3x.dimensio_craft.common.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DimensioCraft.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.DIMENSIO_CRAFT_TAB);

    public static final RegistryObject<Block> STRUCTURE_FRAME_IRON_BLOCK = registerBlock("iron_structure_frame",
            () -> new SlimeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion()
                    .strength(9f)
                    .dynamicShape()
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.DIMENSIO_CRAFT_TAB);

    public static final RegistryObject<Block> ELEVATOR_CONTROLLER = registerBlock("elevator_controller",
            () -> new ElevatorControllerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModCreativeModeTab.DIMENSIO_CRAFT_TAB);

    public static final RegistryObject<Block> COMPUTER_BLOCK = registerBlock("computer",
            () -> new ElevatorControllerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModCreativeModeTab.DIMENSIO_CRAFT_TAB);

    public static final RegistryObject<ExampleChestBlock> EXAMPLE_CHEST = registerBlock("example_chest",
            () -> new ExampleChestBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)), ModCreativeModeTab.DIMENSIO_CRAFT_TAB);;


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package xyz.eburg.cron3x.dimensio_craft.common.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DIMENSIO_CRAFT_TAB = new CreativeModeTab("dimensiotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CITRINE.get());
        }
    };
}

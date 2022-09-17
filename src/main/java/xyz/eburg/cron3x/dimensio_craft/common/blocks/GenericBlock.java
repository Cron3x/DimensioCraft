package xyz.eburg.cron3x.dimensio_craft.common.blocks;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class GenericBlock extends Block {
    public GenericBlock(Properties properties) {
        super(properties);
    }

    private static final Pattern COMPILE = Pattern.compile("@", Pattern.LITERAL);

    protected void addInformationLocalized(List<String> tooltip, String key, Object... parameters) {
        String translated = I18n.get(key, parameters);
        translated = COMPILE.matcher(translated).replaceAll("\u00a7");
        Collections.addAll(tooltip, StringUtils.split(translated, "\n"));
    }

    @Override
    public void getDrops(NonNullList<ItemStack> reslut, IBlockAccess world, BlockPos pos, BlockState state) {

    }
}

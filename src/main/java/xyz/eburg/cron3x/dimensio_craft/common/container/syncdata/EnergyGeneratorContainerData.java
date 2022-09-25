package xyz.eburg.cron3x.dimensio_craft.common.container.syncdata;

import net.minecraft.world.inventory.SimpleContainerData;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.EnergyGeneratorBlockEntity;

public class EnergyGeneratorContainerData extends SimpleContainerData {
    private final EnergyGeneratorBlockEntity blockEntity;

    public EnergyGeneratorContainerData(EnergyGeneratorBlockEntity be, int amount) {
        super(amount);
        this.blockEntity = be;
    }

    @Override
    public int get(int key) {
        return switch (key) {
            case 0 -> this.blockEntity.getProgress();
            case 1 -> this.blockEntity.getMaxProgress();
            case 2 -> this.blockEntity.getEnergy();
            case 3 -> this.blockEntity.energyStorage.getMaxEnergyStored();
            default -> throw new UnsupportedOperationException("Unable to get key: '" + key + "' for block entity: '"
                    + this.blockEntity + "' at pos: '" + this.blockEntity.getBlockPos() + "'");
        };
    }
}
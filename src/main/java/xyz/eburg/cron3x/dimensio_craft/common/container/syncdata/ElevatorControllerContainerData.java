package xyz.eburg.cron3x.dimensio_craft.common.container.syncdata;

import net.minecraft.world.inventory.SimpleContainerData;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ElevatorControllerBlockEntity;

public class ElevatorControllerContainerData extends SimpleContainerData {

    private final ElevatorControllerBlockEntity blockEntity;
    public ElevatorControllerContainerData(ElevatorControllerBlockEntity blockEntity, int amount) {
        super(amount);
        this.blockEntity = blockEntity;
    }

    @Override
    public int get(int key) {
        return switch (key) {
            case 0 ->this.blockEntity.energyStorage.getEnergyStored();
            case 1 -> this.blockEntity.energyStorage.getMaxEnergyStored();
            default -> throw new UnsupportedOperationException("No key: `" + key + "` in: `" + blockEntity +"`");
        };
    }

    @Override
    public void set(int key, int value) {
        switch (key) {
            case 0 :
                this.blockEntity.energyStorage.setEnergy(value);
                break;
            default : throw new UnsupportedOperationException("No key: `" + key + "` in: `" + blockEntity +"`");
        };
    }
}

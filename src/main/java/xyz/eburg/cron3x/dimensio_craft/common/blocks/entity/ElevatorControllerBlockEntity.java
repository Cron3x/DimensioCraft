package xyz.eburg.cron3x.dimensio_craft.common.blocks.entity;

import cpw.mods.util.Lazy;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import org.jetbrains.annotations.NotNull;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.util.CustomEnergyStorage;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.util.InventoryBlockEntity;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ElevatorControllerBlockEntity extends InventoryBlockEntity {
    public static final Component TITLE = new TranslatableComponent(
            "container." + DimensioCraft.MOD_ID + ".elevator_controller");

    private int progress, maxProgress = 0;

    public final CustomEnergyStorage energyStorage;

    private LazyOptional<CustomEnergyStorage> energy;
    private int capacity = 30000, maxReceive = 1000;


    public final List<BlockEntity> connectedFramesStorage;
    private LazyOptional<List<BlockEntity>> connectedFrames;

    public ElevatorControllerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELEVATOR_CONTROLLER.get(), pos, state, 1);
        this.energyStorage = createEnergyStorage();
        this.energy = LazyOptional.of(() -> this.energyStorage);
        this.connectedFramesStorage = createConnectedFrames();
        this.connectedFrames = LazyOptional.of(() -> this.connectedFramesStorage);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CapabilityEnergy.ENERGY ? this.energy.cast() : super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.energy.invalidate();
        this.connectedFrames.invalidate();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.energyStorage.setEnergy(tag.getInt("Energy"));

        byte[] bytes = tag.getByteArray("ConnectedFrames");
        try {
            this.connectedFramesStorage.addAll(convBytes2List(bytes));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Energy", this.energyStorage.getEnergyStored());
        tag.putByteArray("ConnectedFrames", convList2Bytes(this.connectedFramesStorage));
    }

    private CustomEnergyStorage createEnergyStorage() {
        return new CustomEnergyStorage(this.capacity, this.maxReceive, 0, 0,this);
    }
    private List<BlockEntity> createConnectedFrames() {
        List<BlockEntity> list = List.of(this);
        return list;
    }

    private List<BlockEntity> convBytes2List(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        List<BlockEntity> list = null;
        try {
             list = (List<BlockEntity>) ois.readObject();
        } finally {
            ois.close();
        }
        return list;
    }
    private byte[] convList2Bytes(List<BlockEntity> list) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(list);
        } catch (IOException e) {

            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return baos.toByteArray();
    }
}

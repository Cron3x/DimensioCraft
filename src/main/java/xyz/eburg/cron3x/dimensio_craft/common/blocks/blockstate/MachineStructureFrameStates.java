package xyz.eburg.cron3x.dimensio_craft.common.blocks.blockstate;

import net.minecraft.util.StringRepresentable;

public enum MachineStructureFrameStates implements StringRepresentable {
    DEFAULT ("default"),
    SPACE_ELEVATOR ("space_elevator"),
    EMPTY_SLAB("empty_slab"),
    EMPTY("empty"),
    ;

    private final String name;

    private MachineStructureFrameStates(String name) {
        this.name = name;
    }


    @Override
    public String getSerializedName() {
        return this.name;
    }
}

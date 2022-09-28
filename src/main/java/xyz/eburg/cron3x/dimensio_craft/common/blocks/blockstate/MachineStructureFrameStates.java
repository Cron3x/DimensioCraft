package xyz.eburg.cron3x.dimensio_craft.common.blocks.blockstate;

import net.minecraft.util.StringRepresentable;

public enum MachineStructureFrameStates implements StringRepresentable {
    DEFAULT ("default"),
    ELEVATOR_PANEL_N ("elevator_panel_n"),
    ELEVATOR_PANEL_S ("elevator_panel_s"),
    ELEVATOR_PANEL_E ("elevator_panel_e"),
    ELEVATOR_PANEL_W ("elevator_panel_n")
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

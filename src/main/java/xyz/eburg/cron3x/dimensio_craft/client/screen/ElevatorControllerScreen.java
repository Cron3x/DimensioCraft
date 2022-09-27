package xyz.eburg.cron3x.dimensio_craft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.BedBlock;
import net.minecraftforge.client.gui.widget.ExtendedButton;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.container.ElevatorControllerContainer;
import xyz.eburg.cron3x.dimensio_craft.common.container.ExampleChestContainer;

public class ElevatorControllerScreen extends AbstractContainerScreen<ElevatorControllerContainer> { //extends
    private static final ResourceLocation TEXTURE = new ResourceLocation(DimensioCraft.MOD_ID,
            "textures/gui/container/elevator_controller.png");

    private ExtendedButton chipBtn;
    private ExtendedButton scanBtn;

    public ElevatorControllerScreen(ElevatorControllerContainer container, Inventory playerInv, Component title) {
        super(container, playerInv, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 188;
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);

        final int energyStored = this.menu.data.get(0);
        final int maxEnergy = this.menu.data.get(1);
        final int scaledHeight = (int) mapNumber(energyStored, 0, maxEnergy, 0, 62);

        bindTexture();
        blit(stack, this.leftPos + 8, this.topPos + 85 - scaledHeight, 176, 62 - scaledHeight, 30, scaledHeight);

        this.font.draw(stack, this.title, this.leftPos + 8, this.topPos + 5, 0x404040);
        this.font.draw(stack, this.playerInventoryTitle, this.leftPos + 8, this.topPos + 95, 0x404040);

        final TranslatableComponent dimText = new TranslatableComponent("text."+ DimensioCraft.MOD_ID + ".elevator_controller.dimension", getDimension());
        final TranslatableComponent outputPosText = new TranslatableComponent("text."+ DimensioCraft.MOD_ID + ".elevator_controller.output_pos", getOutputPos());

        this.font.draw(stack, dimText, this.leftPos + 78, topPos + 28, 0x404040);
        this.font.draw(stack, outputPosText, this.leftPos + 78, topPos + 40, 0x404040);

        drawCenteredString(stack, this.font, energyStored + "", this.leftPos + 133, this.topPos + 4, 0xFFFFFF);
    }

    @Override
    protected void init() {
        super.init();

        this.chipBtn = addRenderableWidget(
                new ExtendedButton(this.leftPos+79, this.topPos + 55, 90, 15, new TranslatableComponent("buttons." + DimensioCraft.MOD_ID + ".elevator_controller" + ".write_chip"),
                        btn -> write_chip()));

        this.scanBtn = addRenderableWidget(
                new ExtendedButton(this.leftPos+79, this.topPos + 72, 90, 15, new TranslatableComponent("buttons." + DimensioCraft.MOD_ID + ".elevator_controller" + ".scan"),
                        btn -> scan()));
    }

    @Override
    protected void renderBg(PoseStack stack, float mouseX, int mouseY, int partialTicks) {
        renderBackground(stack);
        bindTexture();
        blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
    }

    private String getDimension(){
        return "None";
    }
    private String getOutputPos(){
        return "None";
    }

    private void write_chip(){
        Minecraft.getInstance().player.displayClientMessage(new TextComponent("chip has been written"), false);
    }
    private void scan(){
        Minecraft.getInstance().player.displayClientMessage(new TextComponent("scanned multiblock"), false);
    }

    public static double mapNumber(double value, double rangeMin, double rangeMax, double resultMin, double resultMax) {
        return (value - rangeMin) / (rangeMax - rangeMin) * (resultMax - resultMin) + resultMin;
    }
    public static void bindTexture() {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
    }
}
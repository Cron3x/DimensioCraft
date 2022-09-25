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
import net.minecraftforge.client.gui.widget.ExtendedButton;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.container.ExampleChestContainer;

public class ExampleChestScreen extends AbstractContainerScreen<ExampleChestContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DimensioCraft.MOD_ID,
            "textures/gui/container/example_chest.png");

    private ExtendedButton beanButton;

    public ExampleChestScreen(ExampleChestContainer container, Inventory playerInv, Component title) {
        super(container, playerInv, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 240;
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);
        this.font.draw(stack, this.title, this.leftPos + 20, this.topPos + 5, 0x404040);
        this.font.draw(stack, this.playerInventoryTitle, this.leftPos + 8, this.topPos + 144, 0x404040);
    }

    @Override
    protected void init() {
        super.init();
        this.beanButton = addRenderableWidget(
                new ExtendedButton(this.leftPos, this.topPos, 16, 16, new TextComponent("beans"),
                        btn -> Minecraft.getInstance().player.displayClientMessage(new TextComponent("beans"), false)));
    }

    @Override
    protected void renderBg(PoseStack stack, float mouseX, int mouseY, int partialTicks) {
        renderBackground(stack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
    }


    private void scan() {
        Minecraft.getInstance().player.displayClientMessage(new TextComponent("beans"), false);
    }
    private void write_chip() {
        Minecraft.getInstance().player.displayClientMessage(new TextComponent("beans"), false);
    }
}
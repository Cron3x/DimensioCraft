package xyz.eburg.cron3x.dimensio_craft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;
import xyz.eburg.cron3x.dimensio_craft.common.blocks.entity.ExampleChestBlockEntity;
import xyz.eburg.cron3x.dimensio_craft.common.container.ExampleChestContainer;


public class ExampleChestScreen extends AbstractContainerScreen<ExampleChestContainer> {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(DimensioCraft.MOD_ID, "textures/gui/container/example_chest.png");

    private ExtendedButton beanButton;

    public ExampleChestScreen(ExampleChestContainer container, Inventory pInventory) {
        super(container, pInventory, ExampleChestBlockEntity.TITLE);

        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth  = 240;
        this.imageHeight = 176;
    }

    //TODO: Tutorial Vid: https://www.youtube.com/watch?v=T8B-t30zmJw&list=PLaevjqy3XufahUjMFr9H-FDjgZ0uejPen&index=20

    @Override
    protected void renderBg(PoseStack stack, float mouseX, int mouseY, int partialTicks) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
        blit(stack, this.leftPos, this.topPos, 0,0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
        drawString(stack, font, title, this.leftPos + 8, this.topPos+3, 0x404040);
        drawString(stack, font, playerInventoryTitle, this.leftPos + 8, this.topPos + 120, 0x404040);
    }

    @Override
    protected void init() {
        super.init();
        this.beanButton = addRenderableWidget(new ExtendedButton(this.imageWidth - 30 + 10, this.topPos+3, 30,50, new TextComponent("beans"), (btn) -> {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.displayClientMessage(new TextComponent("JEY"), false);
        }));
    }
}

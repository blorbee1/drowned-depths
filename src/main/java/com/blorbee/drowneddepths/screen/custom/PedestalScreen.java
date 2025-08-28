package com.blorbee.drowneddepths.screen.custom;

import com.blorbee.drowneddepths.DrownedDepths;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PedestalScreen extends HandledScreen<PedestalScreenHandler> {
    public static final Identifier TEXTURE =
            Identifier.of(DrownedDepths.MOD_ID, "textures/gui/pedestal/pedestal_gui.png");

    public PedestalScreen(PedestalScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y,
                0, 0,
                backgroundWidth, backgroundHeight,
                256, 256);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}

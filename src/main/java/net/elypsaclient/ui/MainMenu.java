package net.elypsaclient.ui;

import net.ferderplays.elypsa.refers.ClientRefers;
import net.elypsaclient.manager.ColorManager;
import net.elypsaclient.manager.CoordsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class MainMenu extends GuiScreen {
    @Override
    public void initGui() {
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.renderEngine.bindTexture(new ResourceLocation("elypsaclient/rsz_background.JPG"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width, height);
        ScaledResolution scaledres = new ScaledResolution(mc);

        drawRect(width / 2 - fontRenderer.getStringWidth("Singleplayer") / 2 - 8, height / 2 - fontRenderer.FONT_HEIGHT - 4, width / 2 + fontRenderer.getStringWidth("Singleplayer") / 2 + 8, (height / 2 + fontRenderer.FONT_HEIGHT + 8) + 3 * (fontRenderer.FONT_HEIGHT + 8), ColorManager.getColor(0, 0, 0, 155));

        String[] buttons = new String[] { "Singleplayer", "Multiplayer", "Options", "Quit"};

        int count = 0;
        for (String button : buttons) {
            drawCenteredString(fontRenderer, button, width / 2, height / 2 + (count * (fontRenderer.FONT_HEIGHT+ 8)) , ColorManager.getColor(255, 255, 255, 255));
            count++;
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(CoordsManager.centerStringX(ClientRefers.NAME, this.width), 50, 1);
        GlStateManager.scale(2, 2, 1);
        GlStateManager.translate(-(CoordsManager.centerStringX(ClientRefers.NAME, this.width)), -50, 1);
        fontRenderer.drawString(ClientRefers.NAME, CoordsManager.centerStringX(ClientRefers.NAME, this.width), 50, ColorManager.getColor(255, 255, 255, 255));
        GlStateManager.popMatrix();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        String[] buttons = new String[] { "Singleplayer", "Multiplayer", "Options", "Quit"};

        int count = 0;
        for (String name : buttons) {
            float x = width / 2 - fontRenderer.getStringWidth(name) / 2;
            float y = height / 2 + (count * (fontRenderer.FONT_HEIGHT + 8)) ;
            if (mouseX >= x && mouseY >= y && mouseX < x + fontRenderer.getStringWidth(name) && mouseY < y + mc.fontRenderer.FONT_HEIGHT) {
                switch (name) {
                    case "Singleplayer":
                        mc.displayGuiScreen(new GuiWorldSelection(this));
                        break;

                    case "Multiplayer":
                        mc.displayGuiScreen(new GuiMultiplayer(this));
                        break;

                    case "Options":
                        mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
                        break;

                    case "Quit":
                        mc.shutdown();
                        break;
                }
            }
            count++;
        }
    }
}

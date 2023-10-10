package net.elypsaclient.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class TabGUI extends Gui {
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            ScaledResolution scaledres = new ScaledResolution(Minecraft.getMinecraft());
            FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
            int y = 0;
            drawRect(50, ((scaledres.getScaledHeight() / 2) - fr.FONT_HEIGHT + 20), fr.getStringWidth("Test") + 40, ((scaledres.getScaledHeight() / 2) + fr.FONT_HEIGHT + 20), new Color(0, 0, 0, 150).getRGB());
        }
    }
}

package net.elypsaclient.manager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class CoordsManager {
    public static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
    public static ScaledResolution scaledres = new ScaledResolution(Minecraft.getMinecraft());
    public static int centerStringX(String s, int original_width) {
        return (original_width / 2) - (fontRenderer.getStringWidth(s) / 2);
    }
}

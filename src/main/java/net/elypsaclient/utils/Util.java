package net.elypsaclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class Util {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static ScaledResolution scaledres = new ScaledResolution(mc);
    public static FontRenderer fontRenderer = mc.fontRenderer;

    public static void print(Object x) {
        System.out.println(x);
    }
}

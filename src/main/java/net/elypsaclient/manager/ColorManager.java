package net.elypsaclient.manager;

import java.awt.*;

public class ColorManager {
    public static int getPrefferedColor() {
        return new Color(0, 168, 243).getRGB();
    }

    public static int getColor(String name) {
        return Color.getColor(name).getRGB();
    }
    public static int getColor(int r, int g, int b, int a) {
        return new Color(r, g, b, a).getRGB();
    }

    public static int getBgColor() {
        return new Color(0, 0, 0, 150).getRGB();
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}

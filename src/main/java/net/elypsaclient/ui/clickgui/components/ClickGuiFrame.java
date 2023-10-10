package net.elypsaclient.ui.clickgui.components;

import net.elypsaclient.manager.ColorManager;
import net.elypsaclient.modules.ModuleCateg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ClickGuiFrame {
    public String title;
    public ClickGuiFrame(ModuleCateg category) {
        this.title = category.name;
    }

    public void renderFrame(int x, int y, int width, int height) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.fontRenderer.drawString(this.title, x + 4, y + 4, ColorManager.getColor(255, 255, 255, 255));
        Gui.drawRect(x, y, width, height, ColorManager.getPrefferedColor());
    }
}

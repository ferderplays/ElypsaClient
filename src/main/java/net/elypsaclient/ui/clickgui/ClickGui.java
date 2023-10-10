package net.elypsaclient.ui.clickgui;

import net.elypsaclient.manager.ColorManager;
import net.elypsaclient.modules.ModuleCateg;
import net.elypsaclient.ui.clickgui.components.ClickGuiFrame;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;

public class ClickGui extends GuiScreen {

    public static ArrayList<ClickGuiFrame> frames;
    public static int color = ColorManager.getPrefferedColor();

    public ClickGui() {
        frames = new ArrayList<>();
        for (ModuleCateg category : ModuleCateg.values()) {
            frames.add(new ClickGuiFrame(category));
        }
    }

    @Override
    public void initGui() {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int count = 0;
        for (ClickGuiFrame frame : frames) {
            frame.renderFrame(60 * count + 60, 30, 50, 40);
            count++;
        }
    }
}

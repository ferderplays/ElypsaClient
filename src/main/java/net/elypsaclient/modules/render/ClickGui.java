package net.elypsaclient.modules.render;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Module {
    public ClickGui() {
        super("ClickGui", "renders ClickGui", ModuleCateg.RENDER);
        setKeyChar(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void modAction() {
        mc.displayGuiScreen(new net.elypsaclient.ui.clickgui.ClickGui());
    }
}

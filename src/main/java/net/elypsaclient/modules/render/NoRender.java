package net.elypsaclient.modules.render;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import org.lwjgl.input.Keyboard;

public class NoRender extends Module {
    public NoRender() {
        super("No Render", "removes render of some stuff", ModuleCateg.RENDER);
        setKeyChar(Keyboard.KEY_P);
    }
}

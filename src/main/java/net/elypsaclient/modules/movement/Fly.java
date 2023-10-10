package net.elypsaclient.modules.movement;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {
    public Fly() {
        super("Fly", "makes u go BRRRR", ModuleCateg.MOVEMENT);
        setKeyChar(Keyboard.KEY_K);
    }

    @Override
    public void modAction() {
        mc.player.capabilities.isFlying = true;
    }

    @Override
    public void modActionEnd() {
        mc.player.capabilities.isFlying = false;
    }
}

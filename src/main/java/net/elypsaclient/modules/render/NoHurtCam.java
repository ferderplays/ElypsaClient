package net.elypsaclient.modules.render;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class NoHurtCam extends Module {

    public NoHurtCam() {
        super("No Hurt Cam", "removes the hurt animation", ModuleCateg.RENDER);
        this.setKeyChar(Keyboard.KEY_J);
    }

    @SubscribeEvent
    public void onPlayerDamage(LivingDamageEvent event) {
        mc.player.hurtTime = 0;
    }
}

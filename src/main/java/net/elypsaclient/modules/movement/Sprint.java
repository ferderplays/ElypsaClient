package net.elypsaclient.modules.movement;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", "A module that makes u always sprint", ModuleCateg.MOVEMENT);
        this.setKeyChar(Keyboard.KEY_M);
    }

    @SubscribeEvent
    public void onWalkEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            if (mc.player.moveForward > 0 && !mc.player.isHandActive() && !mc.player.isSneaking() && !mc.player.collidedHorizontally) {
                mc.player.setSprinting(true);
            }
        }
    }

    public void modActionEnd() {

        mc.player.setSprinting(mc.gameSettings.keyBindSprint.isPressed());
    }
}

package net.elypsaclient.modules.combat;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.elypsaclient.utils.TimerUtil;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class CrystalAura extends Module {
    public TimerUtil timer = new TimerUtil();
    public CrystalAura() {
        super("Crystal Aura", "attacks end crystals", ModuleCateg.COMBAT);
        setKeyChar(Keyboard.KEY_G);
    }

    @SubscribeEvent
    public void onEntityMotion(LivingEvent.LivingUpdateEvent event) {

    }
}

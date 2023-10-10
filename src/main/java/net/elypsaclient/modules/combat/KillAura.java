package net.elypsaclient.modules.combat;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.elypsaclient.utils.TimerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura extends Module {

    public TimerUtil timer = new TimerUtil();
    public KillAura() {
        super("KillAura", "attacks entities in a certain range", ModuleCateg.COMBAT);
        setKeyChar(Keyboard.KEY_H);
    }

    @SubscribeEvent
    public void onEntityMotion(LivingEvent.LivingUpdateEvent event) {
        List<Entity> enemies = mc.world.getLoadedEntityList().stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
        enemies = enemies.stream().filter(e -> e.getDistance(mc.player) < 10 && e != mc.player).collect(Collectors.toList());
        enemies.sort(Comparator.comparingDouble(entity -> ((Entity)entity).getDistance(mc.player)));

        if (!enemies.isEmpty()) {
            Entity target = enemies.get(0);
            if (timer.hasTimePassed(1000 / 5, true)) {
                mc.playerController.attackEntity(mc.player, target);
                mc.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }
}

package net.elypsaclient.modules.combat;

import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.ferderplays.elypsa.utils.ItemUtil;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class AutoTotem extends Module {

    public AutoTotem() {
        super("Auto Totem", "on low health does equip totems", ModuleCateg.COMBAT);
        setKeyChar(Keyboard.KEY_N);
    }
    @SubscribeEvent
    public void onTick(TickEvent event) {
        if (!(mc.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING)){
            mc.player.setHeldItem(EnumHand.OFF_HAND, ItemUtil.getItemsFromInventory(mc.player, Items.TOTEM_OF_UNDYING, 1));
        }
    }
}

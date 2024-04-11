package net.elypsaclient.client;

import net.ferderplays.elypsa.refers.ClientRefers;
import net.elypsaclient.modules.Module;
import net.elypsaclient.manager.ModuleManager;
import net.elypsaclient.ui.HUD;
import net.elypsaclient.ui.MainMenu;
import net.ferderplays.elypsa.utils.ClientDirectoryUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = ClientRefers.MODID, name = ClientRefers.NAME, version = ClientRefers.VERSION)
public class Main
{
    @Mod.Instance
    public Main instance;

    public static ModuleManager moduleManager = new ModuleManager();
    public Minecraft mc = Minecraft.getMinecraft();
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new HUD());
        mc.gameSettings.gammaSetting = 10000;
    }

    @EventHandler
    public void postInit(FMLPreInitializationEvent event) {
        ClientDirectoryUtil.init();
    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent event) {
        if (mc.world == null || mc.player == null) return;
        try {
            if (Keyboard.isCreated()) {
                if (Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if (keyCode <= 0)
                        return;
                    for (Module module : moduleManager.modules) {
                        if (module.getKeyChar() == keyCode && keyCode > 0) {
                            module.enable();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onScreenEvent(GuiScreenEvent event) {
        if (event.getGui().getClass() == GuiMainMenu.class) {
            mc.displayGuiScreen(new MainMenu());
        }
    }
}

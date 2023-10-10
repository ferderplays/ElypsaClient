package net.elypsaclient.ui;

import net.ferderplays.elypsa.refers.ClientRefers;
import net.elypsaclient.client.Main;
import net.elypsaclient.manager.ColorManager;
import net.elypsaclient.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Collections;
import java.util.Comparator;

public class HUD extends Gui {

    public Minecraft mc = Minecraft.getMinecraft();

    public static class ModuleComperator implements Comparator<Module> {

        @Override
        public int compare(Module m1, Module m2) {
            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(m1.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(m2.getName())) {
                return -1;
            }
            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(m1.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(m2.getName())) {
                return 1;
            }
            return 0;
        }
    }

    //private final ResourceLocation watermark = new ResourceLocation(ClientRefers.MODID,"textures/watermark.png");
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Collections.sort(Main.moduleManager.modules, new ModuleComperator());
        ScaledResolution scaledres = new ScaledResolution(mc);
        FontRenderer fontRenderer = mc.fontRenderer;

        /* client logo
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            mc.renderEngine.bindTexture(watermark);
            drawScaledCustomSizeModalRect(0, 0, 0, 50, 50, 50, 50, 50, 50, 50);
        } */

        // client info
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(4, 4, 1);
            GlStateManager.scale(2, 2, 1);
            GlStateManager.translate(-4, -4, 1);
            fontRenderer.drawStringWithShadow(ClientRefers.NAME, 4, 4, ColorManager.getPrefferedColor());
            GlStateManager.popMatrix();
        }

        // module list
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 2;
            final int[] counter = {1};
            for (Module module : Main.moduleManager.modules) {
                if (!module.getName().equalsIgnoreCase("") && module.isToggled()) {
                    drawRect(scaledres.getScaledWidth() - fontRenderer.getStringWidth(module.getName()) - 4, 4 + y, scaledres.getScaledWidth() - fontRenderer.getStringWidth(module.getName()) - 8, 8 + y + fontRenderer.FONT_HEIGHT, ColorManager.rainbow(counter[0] * 300));
                    drawRect(scaledres.getScaledWidth() - fontRenderer.getStringWidth(module.getName()) - 4, 4 + y, scaledres.getScaledWidth(), 8 + y + fontRenderer.FONT_HEIGHT, ColorManager.getBgColor());
                    fontRenderer.drawStringWithShadow(module.getName(), scaledres.getScaledWidth() - fontRenderer.getStringWidth(module.getName()) - 2, y + 6, ColorManager.rainbow(counter[0] * 300));

                    y += fontRenderer.FONT_HEIGHT + 4;
                    counter[0]++;
                }
            }
        }
    }
}

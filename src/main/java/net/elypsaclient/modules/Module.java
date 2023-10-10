package net.elypsaclient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public String name, description;
    public int keyChar;
    public ModuleCateg category;
    public boolean toggled;

    protected Minecraft mc = Minecraft.getMinecraft();
    public Module(String name, String description, ModuleCateg category) {
        super();
        this.name = name;
        this.description = description;
        this.category = category;
        this.toggled = false;
    }

    public String getName() {
        return name;
    }

    public ModuleCateg getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKeyChar() {
        return keyChar;
    }

    public void setKeyChar(int keyChar) {
        this.keyChar = keyChar;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void enable() {
        this.toggled = !this.toggled;
        if (this.toggled) onEnable();
        else onDisable();
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
        modAction();
    }

    public void modAction() {
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        modActionEnd();
    }

    public void modActionEnd() {

    }
}

package net.elypsaclient.manager;

import net.elypsaclient.client.Main;
import net.elypsaclient.modules.Module;
import net.elypsaclient.modules.ModuleCateg;
import net.elypsaclient.modules.combat.AutoTotem;
import net.elypsaclient.modules.combat.CrystalAura;
import net.elypsaclient.modules.combat.KillAura;
import net.elypsaclient.modules.movement.Fly;
import net.elypsaclient.modules.movement.Sprint;
import net.elypsaclient.modules.render.ClickGui;
import net.elypsaclient.modules.render.FullBright;
import net.elypsaclient.modules.render.NoHurtCam;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();
        // combat
        this.modules.add(new KillAura());
        this.modules.add(new CrystalAura());
        this.modules.add(new AutoTotem());
        // movement
        this.modules.add(new Sprint());
        this.modules.add(new Fly());
        // player

        // render
        this.modules.add(new NoHurtCam());
        this.modules.add(new ClickGui());
        this.modules.add(new FullBright());
        // client
    }

    public Module getModule(String name) {
        for (Module module : modules) {
            if (module.getName().equals(name)) return module;
        }
        return null;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public static List<Module> getModulesByCateg(ModuleCateg category) {
        List<Module> modulesByCateg = new ArrayList<Module>();
        for (Module module : Main.moduleManager.modules) {
            if (module.getCategory().equals(category))
                modulesByCateg.add(module);
        }
        return modulesByCateg;
    }
}

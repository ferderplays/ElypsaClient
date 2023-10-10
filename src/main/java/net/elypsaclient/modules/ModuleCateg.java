package net.elypsaclient.modules;

public enum ModuleCateg {
    MOVEMENT("Movement"), PLAYER("Player"), RENDER("Render"), CLIENT("Client"), COMBAT("Combat");

    public String name;
    public int moduleIndex;
    ModuleCateg(String name) {
        this.name = name;
    }
}

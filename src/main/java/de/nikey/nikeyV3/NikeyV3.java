package de.nikey.nikeyV3;

import de.nikey.nikeyV3.ElementArmor.ElementArmorEvents;
import de.nikey.nikeyV3.General.GiveCMD;
import de.nikey.nikeyV3.Upgrading.UpgradeTerminalEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NikeyV3 extends JavaPlugin {

    private static NikeyV3 plugin;

    public void onEnable() {

        NikeyV3.plugin = this;
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new UpgradeTerminalEvents(),this);
        manager.registerEvents(new ElementArmorEvents(), this);


        this.getCommand("giveitem").setExecutor(new GiveCMD());
        this.getCommand("giveitem").setTabCompleter(new GiveCMD());
    }

    public void onDisable() {
    }

    public static NikeyV3 getPlugin() {
        return NikeyV3.plugin;
    }
}

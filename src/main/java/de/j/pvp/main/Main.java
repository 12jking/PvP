package de.j.pvp.main;

import de.j.pvp.commands.BuildCmd;
import de.j.pvp.commands.SuicideCommand;
import de.j.pvp.kits.KitHandler;
import de.j.pvp.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        getCommand("build").setExecutor(new BuildCmd());
        getCommand("suicide").setExecutor(new SuicideCommand());
        plugin = this;
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new PlayerJoinListener(), this);
        manager.registerEvents(new PlayerLeaveListener(), this);
        manager.registerEvents(new SoupListener(), this);
        manager.registerEvents(new PlayerInteractListener(), this);
        manager.registerEvents(new KitHandler(this), this);
        manager.registerEvents(new PlayerDeathListener(), this);
        manager.registerEvents(new PhantomListener(), this);
        manager.registerEvents(new BlockListener(), this);
        manager.registerEvents(new ServerPing(), this);
        manager.registerEvents(new GliderEvent(), this);
        manager.registerEvents(new DropItemListener(), this);
        manager.registerEvents(new PlayerRespawnListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin(){
        return plugin;
    }
}

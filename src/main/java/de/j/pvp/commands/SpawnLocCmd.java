package de.j.pvp.commands;

import de.j.pvp.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SpawnLocCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("pvp.spawn")){
                try {
                    FileConfiguration configuration = Main.getPlugin().getConfig();
                    configuration.set("loc.join.world", player.getWorld().getName());
                    configuration.set("loc.join.x", player.getLocation().getX());
                    configuration.set("loc.join.y", player.getLocation().getY());
                    configuration.set("loc.join.z", player.getLocation().getZ());
                    configuration.save("config.yml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}

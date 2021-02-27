package de.j.pvp.commands;

import de.j.pvp.listener.BlockListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            if (!BlockListener.allowed.contains(sender)){
                BlockListener.allowed.add((Player) sender);
                sender.sendMessage(ChatColor.GREEN + "Building enabled");
            }else {
                BlockListener.allowed.remove((Player) sender);
                sender.sendMessage(ChatColor.RED + "Building disabled");
            }

        }
        return false;
    }
}

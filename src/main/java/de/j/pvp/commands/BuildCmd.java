package de.j.pvp.commands;

import de.j.pvp.listener.BlockListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            BlockListener.allowed.add((Player) sender);
        }
        return false;
    }
}

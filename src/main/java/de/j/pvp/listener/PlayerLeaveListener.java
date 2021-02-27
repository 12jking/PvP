package de.j.pvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        event.setQuitMessage("§7[§c-§7] " + event.getPlayer().getName());
        if (BlockListener.allowed.contains(event.getPlayer())){
            BlockListener.allowed.remove(event.getPlayer());
        }
    }
}

package de.j.pvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
}

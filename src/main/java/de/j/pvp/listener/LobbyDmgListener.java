package de.j.pvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LobbyDmgListener implements Listener {

    @EventHandler
    public void onDmg(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (PlayerJoinListener.inLobby.contains(player)) {
                event.setCancelled(true);
            }
        }
    }
}

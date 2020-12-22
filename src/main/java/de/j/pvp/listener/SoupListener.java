package de.j.pvp.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupListener implements Listener {

    @EventHandler
    public void handleSoup(PlayerInteractEvent event){
        if (event.getPlayer().getItemInHand().getType() == Material.MUSHROOM_SOUP){
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (event.getPlayer().getHealth() < 20){
                    if (event.getPlayer().getHealth() + 2 <= 20){
                        event.getPlayer().setHealth(event.getPlayer().getHealth() + 2);
                    }else {
                        event.getPlayer().setHealth(20);
                    }
                    event.getPlayer().getItemInHand().setType(Material.BOWL);
                }


            }
        }
    }
}

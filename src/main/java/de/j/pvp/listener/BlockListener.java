package de.j.pvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class BlockListener implements Listener {

    public static ArrayList<Player> allowed = new ArrayList<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (!allowed.contains(event.getPlayer())){
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (!allowed.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }
}

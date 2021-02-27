package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (PlayerJoinListener.inLobby.contains(event.getPlayer())){
            if (event.getPlayer().getItemInHand().getType() == Material.CHEST){
                event.setCancelled(true);
                Inventory inventory = Bukkit.createInventory(null, 9*1, "§6§oKits");
                for (int i = KitHandler.kits.size() - 1; i != -1; i --){
                    inventory.addItem(new ItemBuilder().setMaterial(KitHandler.kits.get(i).getMaterial()).setName(KitHandler.kits.get(i).getName()).build());
                }
                event.getPlayer().openInventory(inventory);
            }

        }

    }
}

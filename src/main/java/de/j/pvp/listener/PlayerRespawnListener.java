package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        player.getInventory().addItem(new ItemStack(Material.CHEST));
        player.setHealth(20);

        new BukkitRunnable() {
            @Override
            public void run() {
                Location location = player.getLocation();
                if (location.getX() > 847 || location.getX() < 838 || location.getZ() < -598 || location.getZ() > -589){
                    if (KitHandler.playerKit.get(player) == null){
                        PlayerJoinListener.inLobby.remove(player);
                        if (!BlockListener.allowed.contains(player)){
                            KitHandler.playerKit.put(player, KitHandler.checkKit(Material.STONE));
                            player.getInventory().setContents(KitHandler.checkKit(Material.STONE).getItems());
                            player.closeInventory();
                            player.getInventory().setHelmet(KitHandler.checkKit(Material.STONE).getHelmet());
                            player.getInventory().setChestplate(KitHandler.checkKit(Material.STONE).getChest());
                            player.getInventory().setLeggings(KitHandler.checkKit(Material.STONE).getLeg());
                            player.getInventory().setBoots(KitHandler.checkKit(Material.STONE).getBoots());
                            player.sendMessage("§cDu hast jetzt das " + KitHandler.checkKit(Material.STONE).getName() + " Kit!");
                            cancel();
                        }
                    }
                }
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(), 5, 1);
    }
}

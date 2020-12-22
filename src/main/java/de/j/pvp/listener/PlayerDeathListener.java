package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(new File("config.yml"));
        Player player = event.getEntity();
        PlayerJoinListener.inLobby.add(player);
        event.setDroppedExp(0);
        event.setKeepInventory(true);
        Location location = new Location(player.getWorld(),843, 7, -593);
        player.teleport(location);
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.CHEST));

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (player.getLocation().getY() == 4){
                    if (KitHandler.playerKit.get(player) == null){
                        PlayerJoinListener.inLobby.remove(player);
                        KitHandler.playerKit.put(player, KitHandler.checkKit(Material.STONE));
                        player.getInventory().setContents(KitHandler.checkKit(Material.STONE).getItems());
                        player.closeInventory();
                        player.getInventory().setHelmet(KitHandler.checkKit(Material.STONE).getHelmet());
                        player.getInventory().setChestplate(KitHandler.checkKit(Material.STONE).getChest());
                        player.getInventory().setLeggings(KitHandler.checkKit(Material.STONE).getLeg());
                        player.getInventory().setBoots(KitHandler.checkKit(Material.STONE).getBoots());
                        player.sendMessage("§cDu hast jetzt das " + KitHandler.checkKit(Material.STONE).getName() + " Kit!");
                    }
                    return;
                }
            }
        }, 0, 5);
    }
}

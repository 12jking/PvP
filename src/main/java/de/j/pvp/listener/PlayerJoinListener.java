package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;

public class PlayerJoinListener implements Listener {

    public static ArrayList<Player> inLobby = new ArrayList<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("§7[§a+§7]" + event.getPlayer().getName());
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(new File("config.yml"));
        Player player = event.getPlayer();
        inLobby.add(player);
        Location location = new Location(Bukkit.getWorld(configuration.getString("loc.join.world")), configuration.getDouble("loc.join.x"), configuration.getDouble("loc.join.y"), configuration.getDouble("loc.join.z"));
        player.teleport(location);
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.CHEST));
        player.getWorld().setSpawnLocation(842, 7, -593);
        player.setHealth(20);
        player.setSaturation(20);
        player.getInventory().setChestplate(null);
        player.getInventory().setBoots(null);
        player.getInventory().setHelmet(null);
        player.getInventory().setLeggings(null);
        player.setGameMode(GameMode.SURVIVAL);


        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (player.getLocation().getY() == 4){
                    if (KitHandler.playerKit.get(player) == null){
                        inLobby.remove(player);
                        if (!BlockListener.allowed.contains(player)){
                            KitHandler.playerKit.put(player, KitHandler.checkKit(Material.STONE));
                            player.getInventory().setContents(KitHandler.checkKit(Material.STONE).getItems());
                            player.closeInventory();
                            player.getInventory().setHelmet(KitHandler.checkKit(Material.STONE).getHelmet());
                            player.getInventory().setChestplate(KitHandler.checkKit(Material.STONE).getChest());
                            player.getInventory().setLeggings(KitHandler.checkKit(Material.STONE).getLeg());
                            player.getInventory().setBoots(KitHandler.checkKit(Material.STONE).getBoots());
                            player.sendMessage("§cDu hast jetzt das " + KitHandler.checkKit(Material.STONE).getName() + " Kit!");
                        }

                    }
                    return;
                }
            }
        }, 0, 5);

    }
}

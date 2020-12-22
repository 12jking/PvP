package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.main.Main;
import de.j.pvp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GliderListener implements Listener {

    ArrayList<Player> cooldown = new ArrayList<>();

    @EventHandler
    public void onGlide(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (KitHandler.playerKit.get(event.getPlayer()) == null) return;
            if (event.getPlayer().getItemInHand().getType() == Material.FIREWORK){
                Player player = event.getPlayer();
                if (!cooldown.contains(player)){
                    cooldown.add(player);
                    player.teleport(player.getLocation().add(0,80,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 100, true,false));
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 500, 100));
                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            if (player.getLocation().getY() > 7){
                                player.teleport(player.getLocation().add(0, -0.1, 0));
                            }else
                                cooldown.remove(player);
                            if (player.getLocation().getY() == 4){
                                player.removePotionEffect(PotionEffectType.SPEED);
                                cooldown.remove(player);
                                player.getInventory().setItem(1, new ItemBuilder().setMaterial(Material.FIREWORK).setAmount(1).build());
                                cancel();
                            }
                        }
                    }.runTaskTimer(Main.getPlugin(), 0, 6);

                }

            }

        }
    }
}

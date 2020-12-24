package de.j.pvp.listener;

import de.j.pvp.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class GliderEvent implements Listener {

    ArrayList<Player> gliding = new ArrayList<>();

    @EventHandler
    public void onGlide(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (player.getInventory().getItemInHand().getType() == Material.FIREWORK){
            event.setCancelled(true);
            if (!gliding.contains(player)){
                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), 30, player.getLocation().getZ()));
                player.getLocation().add(new Vector(player.getLocation().getDirection().getBlockX(), -0.1, player.getLocation().getDirection().getBlockZ()));
                gliding.add(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 500, 100));
                new BukkitRunnable(){

                    @Override
                    public void run() {
                        Vector v = player.getLocation().getDirection();
                        v.setY(-0.1);
                        player.setVelocity(v);
                        if (player.getLocation().getY() <= 4){
                            player.removePotionEffect(PotionEffectType.ABSORPTION);
                            cancel();
                        }

                    }
                }.runTaskTimer(Main.getPlugin(), 1, 1);
                new BukkitRunnable(){

                    @Override
                    public void run() {
                        gliding.remove(player);
                    }
                }.runTaskLaterAsynchronously(Main.getPlugin(), 180);
            }else
                player.sendMessage("§cOn cooldown!");

        }
    }

    @EventHandler
    public void fallDmg(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity()).getPlayer();
            if (gliding.contains(player)){
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
                    event.setCancelled(true);
                }
            }
        }

    }

}

package de.j.pvp.listener;

import de.j.pvp.kits.KitHandler;
import de.j.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PhantomListener implements Listener {

    ArrayList<Player> onCooldown = new ArrayList<>();

    @EventHandler
    public void onPhantom(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (KitHandler.playerKit.get(event.getPlayer()) == null) return;
                if (event.getPlayer().getItemInHand().getType() == Material.FEATHER){
                    if (!onCooldown.contains(event.getPlayer())){
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY() + 100, event.getPlayer().getLocation().getZ()));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 100));
                        onCooldown.add(event.getPlayer());
                        event.getPlayer().getInventory().getItemInHand().setType(Material.BARRIER);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                onCooldown.remove(event.getPlayer());
                            }
                        }, 80);
                        event.getPlayer().getInventory().getItem(1).setType(Material.FEATHER);
                    }else {
                        event.getPlayer().sendMessage("§cOn Cooldown!");
                        return;
                    }

                }

        }
    }
}

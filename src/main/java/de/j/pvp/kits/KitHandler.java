package de.j.pvp.kits;

import de.j.pvp.main.Main;
import de.j.pvp.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class KitHandler implements Listener {

    public static ArrayList<Kit> kits;
    public static HashMap<Player, Kit> playerKit;

    public KitHandler(Main plugin){
        kits = new ArrayList<>();
        playerKit = new HashMap<>();
        kits.add(new SoupKit(plugin, Material.MUSHROOM_SOUP, "§aSoup", new ItemStack[]{
                new ItemStack(Material.IRON_SWORD), new ItemStack(Material.MUSHROOM_SOUP), new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemStack(Material.MUSHROOM_SOUP),new ItemBuilder().setMaterial(Material.RED_MUSHROOM).setAmount(32).build(),new ItemBuilder().setMaterial(Material.BROWN_MUSHROOM).setAmount(32).build(),new ItemBuilder().setMaterial(Material.BOWL).setAmount(30).build()
        }, new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_BOOTS)));
        kits.add(new PhantonKit(plugin, Material.FEATHER, "§fPhantom", new ItemStack[]{
                new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.FEATHER), new ItemStack(Material.GOLDEN_APPLE)
        }, new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.GOLD_CHESTPLATE), new ItemStack(Material.GOLD_LEGGINGS), new ItemStack(Material.GOLD_BOOTS)));
        kits.add(new TankKit(plugin, Material.DIAMOND_CHESTPLATE, "§bTank", new ItemStack[]{
                new ItemStack(Material.WOOD_SWORD), new ItemStack(Material.BOW), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemBuilder().setMaterial(Material.ARROW).setAmount(64).build()
        }, new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS)));
        kits.add(new BowKit(plugin, Material.BOW, "§4Bow", new ItemStack[]{
                new ItemStack(Material.WOOD_SWORD), new ItemBuilder().setMaterial(Material.BOW).addEnchantment(Enchantment.ARROW_INFINITE, 1, false).addEnchantment(Enchantment.ARROW_FIRE, 1, false).addEnchantment(Enchantment.ARROW_KNOCKBACK, 5, true).addEnchantment(Enchantment.ARROW_DAMAGE, 5, true).build(), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.ARROW)
        }, new ItemStack(Material.IRON_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_BOOTS)));
        kits.add(new NoneKit(plugin, Material.STONE, "§7None", new ItemStack[]{
                new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.MUSHROOM_SOUP), new ItemStack(Material.MUSHROOM_SOUP), new ItemStack(Material.GOLDEN_APPLE), new ItemBuilder().setMaterial(Material.BROWN_MUSHROOM).setAmount(32).build(), new ItemBuilder().setMaterial(Material.RED_MUSHROOM).setAmount(32).build(), new ItemBuilder().setMaterial(Material.BOWL).setAmount(32).build()
        }, new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_BOOTS)));
        kits.add(new PvPerKit(plugin, Material.DIAMOND_SWORD, "§3PvPer", new ItemStack[]{
                new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.WATER_BUCKET)
        }, null, null, null, null));
        kits.add(new GliderKit(plugin, Material.LEATHER_CHESTPLATE, "§1Glider", new ItemStack[]{
                new ItemStack(Material.IRON_SWORD),new ItemStack(Material.FIREWORK), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.WATER_BUCKET)
        }, new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_BOOTS)));

    }

    @EventHandler
    public void onKitChoose(InventoryClickEvent event){
        if (event.getWhoClicked() instanceof Player){
            if (event.getInventory().getName().equals("§6§oKits")){
                event.setCancelled(true);
                if (checkKit(event.getCurrentItem().getType()) != null){
                    Player player = (Player) ((Player) event.getWhoClicked()).getPlayer();
                    playerKit.put(player, checkKit(event.getCurrentItem().getType()));
                    player.getInventory().setContents(checkKit(event.getCurrentItem().getType()).getItems());
                    player.closeInventory();
                    player.getInventory().setHelmet(checkKit(event.getCurrentItem().getType()).getHelmet());
                    player.getInventory().setChestplate(checkKit(event.getCurrentItem().getType()).getChest());
                    player.getInventory().setLeggings(checkKit(event.getCurrentItem().getType()).getLeg());
                    player.getInventory().setBoots(checkKit(event.getCurrentItem().getType()).getBoots());
                    player.sendMessage("§cDu hast jetzt das " + checkKit(event.getCurrentItem().getType()).getName() + " Kit!");

                }
            }

        }
    }

    public static Kit checkKit(Material material){
        for (Kit current : kits){
            if (current.getMaterial() == material){
                return current;
            }
        }
        return null;
    }

}

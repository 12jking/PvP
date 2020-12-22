package de.j.pvp.kits;

import de.j.pvp.main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Kit {

    private Main plugin;
    private Material material;
    private String name;
    private ItemStack[] items;
    private ItemStack hat;
    private ItemStack chest;
    private ItemStack leg;
    private ItemStack boots;

    public Kit(Main plugin, Material material, String name, ItemStack[] items, ItemStack hat, ItemStack chest, ItemStack leg, ItemStack boots){
        this.plugin = plugin;
        this.material = material;
        this.name = name;
        this.items = items;
        this.hat = hat;
        this.chest = chest;
        this.leg = leg;
        this.boots = boots;
    }

    public void player(Player player){

    }

    public ItemStack[] getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemStack getHelmet(){
        return hat;
    }
    public ItemStack getChest(){
        return chest;
    }
    public ItemStack getLeg(){
        return leg;
    }
    public ItemStack getBoots(){
        return boots;
    }
}

package de.j.pvp.kits;

import de.j.pvp.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BowKit extends Kit{
    public BowKit(Main plugin, Material material, String name, ItemStack[] items, ItemStack hat, ItemStack chest, ItemStack leg, ItemStack boots) {
        super(plugin, material, name, items, hat, chest, leg, boots);
    }
}

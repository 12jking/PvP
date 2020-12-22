package de.j.pvp.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    private ItemStack stack;
    private ItemMeta meta;

    public ItemBuilder setMaterial(Material material){
        this.stack = new ItemStack(material);
        this.meta = stack.getItemMeta();
        return this;
    }

    public ItemBuilder setName(String name){
        meta.setDisplayName(name);
        return this;
    }

    public ItemStack build(){
        stack.setItemMeta(meta);
        return stack;
    }

    public ItemBuilder setAmount(int amount){
        stack.setAmount(amount);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level, boolean b){
        meta.addEnchant(enchantment, level, b);
        return this;
    }


}

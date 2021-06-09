package com.citrizz.myplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack smacker;

    public static void init() {
        createSmacker();
    }

    private static void createSmacker() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Super Smacker");
        List<String> lore = new ArrayList<>();
        lore.add("§7A stick of great zoom zooming power");
        lore.add("§7Don't question it, just smack");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 10000, true);
        item.setItemMeta(meta);
        smacker = item;
    }
}

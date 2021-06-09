package com.citrizz.customitemsmcplugintutorial.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is a relic of");
        lore.add("§7Minecraft's ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;

        // custom recipes:
        // shaped recipe - set shape in crafting table to follow
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        // rows of crafting table
        // top, middle, bottom
        sr.shape("B  ", " S ", "  S");
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        // shapeless recipe
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("wand_shapeless"), item);
        slr.addIngredient(2, Material.BLAZE_POWDER);
        slr.addIngredient(1, Material.DIAMOND);
        Bukkit.getServer().addRecipe(slr);

        // furnace recipe
        // (unique id, result, input to furnace, xp gained, time to complete recipe in ticks [1 second = 20 ticks])
        FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("wand_smelt"), item, Material.EMERALD, 1.0f, 10 * 20);
        Bukkit.getServer().addRecipe(smelt);
    }

}

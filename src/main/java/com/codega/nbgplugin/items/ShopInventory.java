package com.codega.nbgplugin.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.codega.nbgplugin.NBG_Plugin;

import net.md_5.bungee.api.ChatColor;

public class ShopInventory implements InventoryHolder {

    public final Inventory inventory;

    public ShopInventory(NBG_Plugin plugin) {
        // Create an Inventory with 9 slots, `this` here is our InventoryHolder.
        this.inventory = plugin.getServer().createInventory(this, 9 * 3);
    }

    @Override
    public Inventory getInventory() {
        this.inventory.setItem(11, getItem(new ItemStack(Material.OAK_PLANKS), "Tree Sapling", "tree shop"));
        this.inventory.setItem(12, getItem(new ItemStack(Material.OAK_SAPLING), "Tree Sapling", "tree shop"));
        return this.inventory;
    }

    @SuppressWarnings("deprecation")
    private ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> lores = new ArrayList<>();
        for (String line : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
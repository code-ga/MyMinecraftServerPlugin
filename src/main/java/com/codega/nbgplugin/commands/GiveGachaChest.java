package com.codega.nbgplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import com.codega.nbgplugin.database.Database;

public class GiveGachaChest implements CommandExecutor {
    Database database;
    public GiveGachaChest(Database pluginDatabase) {
        database = pluginDatabase;
    }
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        // TODO Auto-generated method stub
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command");            
            return true;
        }
        ;
        String displayName = args[0];
        if (displayName == null) {
            player.sendMessage("Please specify a display name");
            return true;
        }
        String keyName = args[1];
        if (keyName == null) {
            player.sendMessage("Please specify a key name");
            return true;
        }
        ItemStack item = new ItemStack(Material.CHEST);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
        player.sendMessage("Gave you a gacha chest");
        return true;
    }
}

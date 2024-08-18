package com.codega.nbgplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.codega.nbgplugin.NBG_Plugin;
import com.codega.nbgplugin.database.Database;
import com.codega.nbgplugin.items.ShopInventory;

public class Shop implements CommandExecutor {
    public Database database;

    public Shop(Database pluginDatabase) {
        database = pluginDatabase;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        // TODO Auto-generated method stub
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }
        ShopInventory shopInventory = new ShopInventory(database.getPlugin());
        player.openInventory(shopInventory.getInventory());
        return true;
    }

    
}

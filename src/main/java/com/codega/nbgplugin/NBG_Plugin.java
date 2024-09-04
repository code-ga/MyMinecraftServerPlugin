package com.codega.nbgplugin;

import io.papermc.lib.PaperLib;
import org.bukkit.plugin.java.JavaPlugin;

import com.codega.nbgplugin.commands.GiveGachaChest;
import com.codega.nbgplugin.commands.Shop;
import com.codega.nbgplugin.database.Database;

import org.bukkit.plugin.PluginManager;

/**
 * Created by Levi Muniz on 7/29/20.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class NBG_Plugin extends JavaPlugin {

  public Database database;

  @Override
  public void onEnable() {
    PaperLib.suggestPaper(this);
    // get config directory of plugin
    String configDir = getDataFolder().getAbsolutePath();
    Database database = new Database(configDir,this);
    database.load();

    PluginManager pm = getServer().getPluginManager();
    getCommand("spawn").setExecutor(new Spawn());
    getCommand("giveGachaChest").setExecutor(new GiveGachaChest(database));
    getCommand("shop").setExecutor(new Shop(database));
    getCommand("htp").setExecutor(new HOME_TP());
    saveDefaultConfig();
  }

  @Override
  public void onDisable() {
    database.save();
  }
}

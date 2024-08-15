package com.codega.nbgplugin;

import io.papermc.lib.PaperLib;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.ServerTickManager;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Levi Muniz on 7/29/20.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class NBG_Plugin extends JavaPlugin {

  @Override
  public void onEnable() {
    PaperLib.suggestPaper(this);

    PluginManager pm = getServer().getPluginManager();
    getCommand("spawn").setExecutor(new Spawn());

    saveDefaultConfig();
  }
}

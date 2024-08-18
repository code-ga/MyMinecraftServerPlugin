package com.codega.nbgplugin.database;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.JsonObject;
import com.codega.nbgplugin.NBG_Plugin;
import com.google.gson.Gson;

public class Database {

    public Path directory;
    public JsonObject data;
    public NBG_Plugin plugin;

    public Database(String dir, NBG_Plugin mainPlugin) {
        this.plugin = mainPlugin;
        this.directory = Paths.get(dir, "database.json");
        File file = new File(this.directory.toString());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        // save data

        try {
            FileWriter writer = new FileWriter(this.directory.toString());
            writer.write(new Gson().toJson(this.data));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        // load data

        try {
            File file = new File(this.directory.toString());
            String fileContent = file.exists() ? new String(file.toString()) : "{}";
            JsonObject jsonElement = new Gson().fromJson(fileContent, JsonObject.class);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                this.data = jsonElement.getAsJsonObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NBG_Plugin getPlugin() {
        return plugin;
    }
}

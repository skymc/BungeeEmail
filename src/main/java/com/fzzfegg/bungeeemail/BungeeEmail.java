package com.fzzfegg.bungeeemail;

import com.fzzfegg.bungeeemail.stored.Stored;
import com.fzzfegg.bungeeemail.utils.Reload;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class BungeeEmail extends JavaPlugin {

    public static BungeeEmail instance;

    public String PREFIX;

    public Stored stored;

    public File storedFile;
    public FileConfiguration storedCon;
    public File msgFile;
    public FileConfiguration msgCon;

    @Override
    public void onEnable() {
        instance = this;
        Reload.start();
        Reload.reload(Bukkit.getConsoleSender());


    }

    @Override
    public void onDisable() {

    }
}

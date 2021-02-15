package com.fzzfegg.bungeeemail.utils;

import com.fzzfegg.bungeeemail.BungeeEmail;
import com.fzzfegg.bungeeemail.command.PlayerCommand;
import com.fzzfegg.bungeeemail.stored.Stored;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Reload {

    static BungeeEmail plugin = BungeeEmail.instance;

    public static void reload(CommandSender sender){
        plugin.reloadConfig();
        plugin.storedFile = new File(plugin.getDataFolder(), "stored.yml");
        plugin.storedCon = YamlConfiguration.loadConfiguration(plugin.storedFile);
        plugin.msgFile = new File(plugin.getDataFolder(),"msg.yml");
        plugin.msgCon = YamlConfiguration.loadConfiguration(plugin.msgFile);

        plugin.PREFIX = plugin.getConfig().getString("prefix").replace("&","§");

        SendMsg.sendMsg(sender,"插件重载成功");
    }

    public static void start(){
        plugin.saveDefaultConfig();
        plugin.saveResource("stored.yml",false);
        plugin.saveResource("msg.yml",false);
        //注册附魔
        Enchantment.register();

        Bukkit.getPluginCommand("bemail").setExecutor(new PlayerCommand());

        plugin.stored = plugin.stored.valueOf(plugin.storedCon.getString("data.stored").toLowerCase());

    }


}

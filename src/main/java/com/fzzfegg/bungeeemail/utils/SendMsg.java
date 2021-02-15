package com.fzzfegg.bungeeemail.utils;

import com.fzzfegg.bungeeemail.BungeeEmail;
import org.bukkit.command.CommandSender;

public class SendMsg {

    static BungeeEmail plugin = BungeeEmail.instance;


    public static void sendMsg(CommandSender sender,String msg){
        msg = plugin.PREFIX + msg;
        msg = msg.replace("&","§");
        sender.sendMessage(msg);
    }

}

package com.fzzfegg.bungeeemail.command;

import com.fzzfegg.bungeeemail.BungeeEmail;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerCommand implements TabExecutor {


    BungeeEmail plugin = BungeeEmail.instance;

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args[0].equalsIgnoreCase("open")) {
                //new Gui((Player) sender);
            }
        }


        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }

}

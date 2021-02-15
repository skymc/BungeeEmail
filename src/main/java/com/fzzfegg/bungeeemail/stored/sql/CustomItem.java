package com.fzzfegg.bungeeemail.stored.sql;

import com.fzzfegg.bungeeemail.BungeeEmail;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomItem {

    //TODO

    static BungeeEmail plugin = BungeeEmail.instance;
    static MySQLManager mySQLManager = BungeeEmail.mySQLManager;

    public static void saveItem(CommandSender sender, String[] args){
        Player player = ((Player) sender).getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if(mySQLManager.findItemStack(args[2],player) == null){
            if(mySQLManager.insertItemstack(args[2],itemStack,player)) {
                player.sendMessage(PREFIX + args[2] + " 保存成功");
            }else{
                player.sendMessage(PREFIX + args[2] + " 保存失败，请联系管理员");
            }
        }else{
            mySQLManager.update_itemstack(args[2],itemStack,sender);
            player.sendMessage(PREFIX + args[2] + " 更新成功");
        }

    }

    public static void getItem(CommandSender sender,String[] args){
        Player player = Bukkit.getPlayer(args[2]);
        String itemName = args[3];
        int count;
        if(args.length<5){
            count = 1;
        }else{
            count = Integer.parseInt(args[4]);
        }
        ItemStack itemStack = mySQLManager.findItemStack(itemName,player);
        itemStack.setAmount(count);
        player.getInventory().addItem(itemStack);
        player.sendMessage(PREFIX+"成功把 "+itemName+" 发送至玩家背包");
    }

    public static void delItem(CommandSender sender,String[] args){
        mySQLManager.deleteItemstack(args[2],sender);
        sender.sendMessage(PREFIX+args[2]+" 删除成功");
    }

}

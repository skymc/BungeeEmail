package com.fzzfegg.bungeeemail.stored.sql;

import com.fzzfegg.bungeeemail.BungeeEmail;
import com.fzzfegg.bungeeemail.stored.sql.sqlcommand.CreateSQL;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLManager {

    private BungeeEmail plugin;
    private String ip;
    private String databaseName;
    private String userName;
    private String userPassword;
    private Connection connection;
    private int port;
    private ConfigurationSection databaseCon;
    public static MySQLManager instance = null;

    public static MySQLManager get() {
        return instance == null ? instance = new MySQLManager(BungeeEmail.instance) : instance;
    }

    public MySQLManager(BungeeEmail plugin){
        this.plugin = plugin;
        this.databaseCon = plugin.storedCon.getConfigurationSection("data.mysql");
        databaseName = databaseCon.getString("database");
        ip = databaseCon.getString("ip");
        userName = databaseCon.getString("username");
        userPassword = databaseCon.getString("password");
        port = databaseCon.getInt("port");
    }

    public void enableMySQL() {
        connectMySQL();
        //建表
        for(CreateSQL cmd : CreateSQL.values()) {
            try {
                PreparedStatement ps = connection.prepareStatement(cmd.commandToString());
                ps.executeUpdate();
            } catch (SQLException e) { e.printStackTrace();System.out.println("执行:  "+cmd.commandToString()+" 出现错误");}
        }
    }

    private void connectMySQL() {
        try { connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + databaseName + "?autoReconnect=true&useSSL=false", userName, userPassword);
        } catch (SQLException e) {e.printStackTrace();System.out.println("链接数据库失败");}
    }

    public void doCommand(PreparedStatement ps, CommandSender sender) {
        try { ps.executeUpdate();
        } catch (SQLException e) {sender.sendMessage("执行指令失败，以下为错误提示");e.printStackTrace(); }
    }

    public void shutdown() {
        try { connection.close();} catch (SQLException e) {e.printStackTrace();}
    }

}

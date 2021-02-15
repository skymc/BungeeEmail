package com.fzzfegg.bungeeemail.stored.sql.sqlcommand;

public enum ItemsSQL {

    //添加物品到库
    ADD_ITEMSTACK(
            "INSERT INTO `itemstacks` " +
                    "(`item_name`,`itemstack`)" +
                    "VALUES (?,?)"
    ),
    //获取物品
    FIND_ITEMSTACK(
            "SELECT * FROM `itemstacks` WHERE `item_name` = ?"
    ),
    //如果存在 就更新
    UPDATE_ITEMSTACK(
            "UPDATE itemstacks SET itemstack = ? WHERE `item_name` = ?"
    ),
    //删除
    DELETE_ITEMSTACK(
            "DELETE FROM `itemstacks` WHERE `item_name` = ?"
    );

    private String command;
    ItemsSQL(String command) { this.command = command; }
    public String commandToString() { return command; }

}

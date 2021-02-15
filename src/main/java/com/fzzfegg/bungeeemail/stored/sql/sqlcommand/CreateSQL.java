package com.fzzfegg.bungeeemail.stored.sql.sqlcommand;

public enum CreateSQL {

    CREATE_TABLE_ITEMSTACKS(
            "CREATE TABLE IF NOT EXISTS `itemstacks` (" +
                    "`item_name` VARCHAR(30) NOT NULL PRIMARY KEY," +
                    "`itemstack` text) CHARSET=utf8"
    );



    private String command;

    CreateSQL(String command)
    {
        this.command = command;
    }
    public String commandToString()
    {
        return command;
    }
}

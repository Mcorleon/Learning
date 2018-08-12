package com.tqh.command;

/**
 * @Author: Mcorleon
 * @Date: 18-8-9 16:29
 */
public class InsertData implements Order {
    private Database database;
    public InsertData(Database database){
        this.database=database;
    }
    @Override
    public void execute() {
        database.insert();

    }
}

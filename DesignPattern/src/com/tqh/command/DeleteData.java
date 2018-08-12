package com.tqh.command;

/**
 * @Author: Mcorleon
 * @Date: 18-8-9 16:27
 */
public class DeleteData implements Order {
    private Database database;
    public DeleteData(Database database){
        this.database=database;
    }
    @Override
    public void execute() {
        database.delete();
    }
}

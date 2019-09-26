package com.example.exemplolista.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_item")
public class ListItem {

    @PrimaryKey(autoGenerate = true)
    public int uid;


    @ColumnInfo (name = "head")
    public String head;
    @ColumnInfo (name = "desc")
    public String desc;

}
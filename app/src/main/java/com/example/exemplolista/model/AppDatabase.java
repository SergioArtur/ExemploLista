package com.example.exemplolista.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListItem.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}
package com.example.bikeshopapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bikeshopapp.DAO.PartDAO;
import com.example.bikeshopapp.DAO.ProductDAO;
import com.example.bikeshopapp.Entity.Part;
import com.example.bikeshopapp.Entity.Product;

@Database(entities = {Product.class, Part.class}, version = 2, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();

    public abstract PartDAO partDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "myDataBase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

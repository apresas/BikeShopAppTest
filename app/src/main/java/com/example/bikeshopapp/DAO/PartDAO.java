package com.example.bikeshopapp.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bikeshopapp.Entity.Part;
import com.example.bikeshopapp.Entity.Product;

import java.util.List;

@Dao
public interface PartDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Part part);

    @Update
    void update (Part part);

    @Delete
    void delete (Part part);

    @Query("SELECT * FROM parts ORDER BY partID ASC")
    LiveData<List<Part>> getAllParts();
}

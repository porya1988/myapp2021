package com.example.myapp2021.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.myapp2021.model.MFoods;

import retrofit2.http.DELETE;

@Dao
public interface IDao {

    @Insert
    long insert(MFoods foods);

    @Delete
    void delete(MFoods foods);

    @Update
    void update(MFoods foods);

}

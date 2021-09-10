package com.example.myapp2021.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.myapp2021.model.Note;

import java.util.List;

@Dao
public interface NDao {

    @Insert
    long insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);

    @Query("select * from tbl_note")
    List<Note> getNoteList();

}

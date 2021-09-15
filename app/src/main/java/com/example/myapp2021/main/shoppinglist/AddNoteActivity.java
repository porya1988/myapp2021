package com.example.myapp2021.main.shoppinglist;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.ActivityAddNoteBinding;
import com.example.myapp2021.model.Note;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding binding;
    NAppDatabase appDatabase;
    Notelistadapter notelistadapter;
    List<Note> noteList;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        appDatabase = NAppDatabase.getInstance(AppConfiguration.getContext());

        setContentView(binding.getRoot());

        String amount=String.valueOf(binding.txtAmount.getText());
        note.setBuy(amount);
        //note.setAmount(amount);
        Long noteId=appDatabase.iDao().insert(note);
        Log.e("","");




    }
}
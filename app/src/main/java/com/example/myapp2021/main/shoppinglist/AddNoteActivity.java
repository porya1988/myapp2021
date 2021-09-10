package com.example.myapp2021.main.shoppinglist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.AppDatabase;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.ActivityAddNoteBinding;
import com.example.myapp2021.model.Note;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding binding;
   // NAppDatabase appDatabase;

    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        //appDatabase=NAppDatabase.getInstance(AppConfiguration.getContext());
        setContentView(binding.getRoot());


        Log.e("","");

        binding.txtBuy.setText(note.getBuy());
        binding.txtAmount.setText(note.getAmount());


        Log.e("","");

    }
}
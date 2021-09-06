package com.example.myapp2021.main.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp2021.R;
import com.example.myapp2021.databinding.ActivityAddNoteBinding;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNoteBinding.inflate(getLayoutInflater());
        binding.getRoot();

    }
}
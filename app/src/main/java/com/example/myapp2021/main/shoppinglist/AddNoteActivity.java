package com.example.myapp2021.main.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityAddNoteBinding;
import com.example.myapp2021.databinding.ShoppingRowBinding;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding binding;

    //Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNoteBinding.inflate(getLayoutInflater());

        //bundle=getIntent().getExtras();
       setContentView(binding.getRoot());

    }
}
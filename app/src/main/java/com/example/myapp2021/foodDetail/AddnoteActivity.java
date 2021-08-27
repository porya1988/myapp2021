package com.example.myapp2021.foodDetail;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2021.databinding.ActivityAddnote2Binding;

public class AddnoteActivity extends AppCompatActivity {

   ActivityAddnote2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityAddnote2Binding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnFinalsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
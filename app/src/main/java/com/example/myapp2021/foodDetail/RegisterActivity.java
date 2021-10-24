package com.example.myapp2021.foodDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp2021.R;
import com.example.myapp2021.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
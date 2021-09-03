package com.example.myapp2021.main.shoppinglist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp2021.R;
import com.example.myapp2021.databinding.FragmentShoppingBinding;

import org.jetbrains.annotations.NotNull;


public class ShoppingFragment extends Fragment {


    FragmentShoppingBinding binding;



    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentShoppingBinding.inflate(getLayoutInflater());

       return binding.getRoot();
    }
}
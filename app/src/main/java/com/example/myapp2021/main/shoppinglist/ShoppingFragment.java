package com.example.myapp2021.main.shoppinglist;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.FragmentShoppingBinding;
import com.example.myapp2021.model.Note;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ShoppingFragment extends Fragment {


    FragmentShoppingBinding binding;
    AlarmDialog alarmDialog;
    List<Note> note;
    Intent intent;
    Notelistadapter adapter;

    ShoppingViewModel viewModel;
    // ItemTouchHelper itemTouchHelper;


    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShoppingBinding.inflate(getLayoutInflater());
        alarmDialog = new AlarmDialog(getActivity());
        binding.btnAddnote.setOnClickListener(v -> alarmDialog.showAddAlarm());
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel = new ViewModelProvider(this).get(ShoppingViewModel.class);
        viewModel.getShoppingList().observe(getActivity(), noteList -> {
            adapter = new Notelistadapter(noteList);
            assert binding.recyclerShoppinglist != null;
            binding.recyclerShoppinglist.setAdapter(adapter);
            binding.recyclerShoppinglist.setLayoutManager(new LinearLayoutManager(AppConfiguration.getContext(), RecyclerView.VERTICAL, false));

        });
    }
}
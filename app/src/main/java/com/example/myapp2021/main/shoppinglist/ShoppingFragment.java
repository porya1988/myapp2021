package com.example.myapp2021.main.shoppinglist;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.FragmentShoppingBinding;
import com.example.myapp2021.model.Note;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ShoppingFragment extends Fragment {


    FragmentShoppingBinding binding;
    List<Note> note;
    Intent intent;
    Notelistadapter adapter;
    NAppDatabase appDatabase;
   // ItemTouchHelper itemTouchHelper;


    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShoppingBinding.inflate(getLayoutInflater());
        appDatabase = NAppDatabase.getInstance(AppConfiguration.getContext());
        note=appDatabase.iDao().getNoteList();
        adapter=new Notelistadapter(note);
        assert binding.recyclerShoppinglist != null;
        binding.recyclerShoppinglist.setAdapter(adapter);
        binding.recyclerShoppinglist.setLayoutManager(new LinearLayoutManager(AppConfiguration.getContext(),RecyclerView.VERTICAL,false));

        //itemTouchHelper=new ItemTouchHelper(new SwipeToDeleteCallback(adapter));
        //itemTouchHelper.attachToRecyclerView(binding.recyclerShoppinglist);


        Log.e("","");



        binding.btnAddnote.setOnClickListener(v -> {
            intent = new Intent(AppConfiguration.getContext(), AddNoteActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            AppConfiguration.getContext().startActivity(intent);

        });

        return binding.getRoot();
    }

}
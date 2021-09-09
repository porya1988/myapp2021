package com.example.myapp2021.main.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ShoppingRowBinding;
import com.example.myapp2021.model.Note;

import java.util.List;

public class ShoppinglistAdapter extends RecyclerView.Adapter<ShoppinglistAdapter.ShoppingVH> {


    List<Note> notelist;
    LayoutInflater inflater;
    Note note;
    ShoppingRowBinding binding;

    public ShoppinglistAdapter(List<Note> notelist){
        inflater=LayoutInflater.from(AppConfiguration.getContext());
        this.notelist=notelist;
    }

    @NonNull
    @Override
    public ShoppingVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //binding=DataBindingUtil.inflate(inflater,R.layout.note_row,parent,false);
        return new ShoppingVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingVH holder, int position) {
      // Note note=shoppinglist.get(position);
     //  return ;

    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    public class ShoppingVH extends RecyclerView.ViewHolder{

        ShoppingRowBinding binding;
        public ShoppingVH(ShoppingRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}

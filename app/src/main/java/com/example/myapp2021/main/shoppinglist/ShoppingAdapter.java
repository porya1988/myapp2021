package com.example.myapp2021.main.shoppinglist;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingVH> {


    public ShoppingAdapter(){

    }

    @NonNull
    @Override
    public ShoppingVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingVH holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ShoppingVH extends RecyclerView.ViewHolder{
        public ShoppingVH(@NonNull View itemView) {
            super(itemView);
        }
    }

}

package com.example.myapp2021.main.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.NoteRowBinding;
import com.example.myapp2021.model.Note;

import java.util.List;

public class Notelistadapter extends RecyclerView.Adapter<Notelistadapter.NoteVH> {

    List<Note> noteList;
    LayoutInflater inflater;
    NoteRowBinding binding;
    Note note;
    NAppDatabase appDatabase;

    public Notelistadapter(List<Note> noteList){
        inflater=LayoutInflater.from(AppConfiguration.getContext());
        this.noteList=noteList;
    }


    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(inflater, R.layout.note_row,parent,false);
        return new NoteVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {

        Note note=noteList.get(position);
        binding.setNote(note);






    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NoteVH extends RecyclerView.ViewHolder{

        NoteRowBinding binding;
        public NoteVH(NoteRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

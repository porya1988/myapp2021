package com.example.myapp2021.main.shoppinglist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.FragmentShoppingBinding;
import com.example.myapp2021.model.Note;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.google.android.material.snackbar.Snackbar.*;

public class AlarmDialog {

    Activity activity;
    NAppDatabase appDatabase;
    Note note;


    public AlarmDialog(Activity activity) {
        this.activity = activity;
        appDatabase = NAppDatabase.getInstance(AppConfiguration.getContext());
        //LayoutInflater inflater=LayoutInflater.from(activity);
        //View view=inflater.inflate(R.layout.alert_dialog,null);

    }

    public void showAddAlarm() {

        AlertDialog alertBuilder = new AlertDialog.Builder(activity).create();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.alert_dialog, null);
        alertBuilder.setView(view);
        alertBuilder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertBuilder.show();



        AppCompatEditText txt_buy = view.findViewById(R.id.txt_buy);
        AppCompatEditText txt_amount = view.findViewById(R.id.txt_amount);
        AppCompatButton btn_save = view.findViewById(R.id.btn_save_shopping);
        AppCompatButton btn_cancel=view.findViewById(R.id.btn_cancel);
        btn_save.setOnClickListener(v -> {

            Note note = new Note();
            note.setBuy(String.valueOf(txt_buy.getText()));
            note.setAmount(String.valueOf(txt_amount.getText()));
            long noteId=appDatabase.iDao().insert(note);
            if(noteId>0){
                make(v, R.string.note_added, LENGTH_SHORT).show();
            }
            Log.e("", "");
        });

        btn_cancel.setOnClickListener(v -> alertBuilder.cancel());


    }



}

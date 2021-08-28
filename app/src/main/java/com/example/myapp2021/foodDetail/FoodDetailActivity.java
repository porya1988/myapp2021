package com.example.myapp2021.foodDetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.AppDatabase;
import com.example.myapp2021.databinding.ActivityFooddetailBinding;
import com.example.myapp2021.model.MFoods;
import com.google.android.material.snackbar.Snackbar;

public class FoodDetailActivity extends AppCompatActivity {

    ActivityFooddetailBinding binding;
    Bundle bundle;
    MFoods foods;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFooddetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = AppDatabase.getInstance(AppConfiguration.getContext());

        bundle = getIntent().getExtras();
        foods = bundle.getParcelable("food");

        binding.txtFoodname.setText(foods.getName());
        binding.txtIngredients.setText(foods.getIngredients());
        binding.txtPrepare.setText(foods.getPrepare());

        Glide.with(binding.imgMainfood.getContext())
                .load(foods.getImageAddress())
                .apply(new RequestOptions())
                .into(binding.imgMainfood);

        binding.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(Intent.ACTION_SEND);
                String content=foods.getPrepare();
                intent.putExtra(Intent.EXTRA_SUBJECT,content);
                startActivity(intent);
                */

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = foods.getPrepare();
                String sub = foods.getName();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });

        binding.btnKharid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppConfiguration.getContext(), AddnoteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                AppConfiguration.getContext().startActivity(intent);
            }
        });

        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long result = appDatabase.iDao().insert(foods);

                if (result >0) {


                    Snackbar.make(v, R.string.add_successfully,Snackbar.LENGTH_LONG).show();

                } else {
                    Snackbar.make(v, R.string.didnot_add ,Snackbar.LENGTH_INDEFINITE).show();
                }


            }
        });


    }
}
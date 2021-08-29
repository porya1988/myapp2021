package com.example.myapp2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import com.example.myapp2021.Utils.Utils;
import com.example.myapp2021.databinding.ActivityMainBinding;
import com.example.myapp2021.main.TabsAdapter;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      binding.pager.setAdapter(new TabsAdapter(getSupportFragmentManager(), Utils.fragmentList()));


        binding.BottomNavigation.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i){
                    case 0:
                        binding.pager.setCurrentItem(0);
                        Log.e("","");
                        break;
                    case 1:
                        binding.pager.setCurrentItem(1);
                        Log.e("","");
                        break;
                    case 2:
                        binding.pager.setCurrentItem(2);
                        break;
                }
                return false;

            }
        });




       binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

               switch (position){
                   case 0:
                       binding.BottomNavigation.setItemActiveIndex(0);
                       break;
                   case 1:
                       binding.BottomNavigation.setItemActiveIndex(1);
                       break;
                   case 2:
                       binding.BottomNavigation.setItemActiveIndex(2);
                       break;
               }
           }

           @Override
           public void onPageSelected(int position) {

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
}
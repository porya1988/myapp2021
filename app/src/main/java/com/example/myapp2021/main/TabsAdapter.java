package com.example.myapp2021.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class TabsAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;
    public TabsAdapter(FragmentManager fm,List<Fragment> fragmentList){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentList=fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

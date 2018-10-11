package com.viet.rooparam.viet2.Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //Declaring variables used in this class
    List<Fragment> mfragmentlist = new ArrayList<>();
    List<String> mfragmentTitlelist = new ArrayList<>();

    //Constructor Created
    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    //getting fragment position
    @Override
    public Fragment getItem(int position) {
        return mfragmentlist.get(position);
    }

    //getting fragment size
    @Override
    public int getCount() {
        return mfragmentlist.size();
    }

    //adding fragment to the viewpager
    public void addFragment(Fragment fragment, String title, Bundle bundle) {
        mfragmentlist.add(fragment);
        mfragmentTitlelist.add(title);
        fragment.setArguments(bundle);
    }

    //returning fragment title
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mfragmentTitlelist.get(position);
    }

}

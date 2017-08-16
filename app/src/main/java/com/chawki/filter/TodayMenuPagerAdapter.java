package com.chawki.filter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by one on 31/3/16.
 */
public class TodayMenuPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    int flagy;

    public TodayMenuPagerAdapter(FragmentManager fm, int mNumOfTabs, int flag) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
        this.flagy = flag;

    }

    @Override
    public Fragment getItem(int position) {
        if (flagy == 0) {


            EventsFragment mainDishesFragment = new EventsFragment( );
            return mainDishesFragment;


        } else {
            ClubFragment mainDishesFragment5 = new ClubFragment();

            return mainDishesFragment5;
        }


    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

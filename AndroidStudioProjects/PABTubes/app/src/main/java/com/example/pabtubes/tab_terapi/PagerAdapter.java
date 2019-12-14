package com.example.pabtubes.tab_terapi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumberOfTabs;

    public PagerAdapter(FragmentManager fm, int NumbOFTabs) {
        super(fm);
        this.mNumberOfTabs = NumbOFTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :return new tab_psikofarmaka();
            case 1 :return new tab_psikoterapi();
            case 2 :return new tab_psikososial();
            case 3 :return new tab_psikoreligius();
            default:return null;
            }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}

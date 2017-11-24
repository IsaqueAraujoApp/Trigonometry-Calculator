package com.example.isaquearaujo.trigonometrycalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigatePrincipal extends FragmentPagerAdapter {


    public NavigatePrincipal(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int pos) {
        switch(pos) {
            case 0: return new TrianguloRetangulo();
            case 1: return new LeiSenos();

        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }

}

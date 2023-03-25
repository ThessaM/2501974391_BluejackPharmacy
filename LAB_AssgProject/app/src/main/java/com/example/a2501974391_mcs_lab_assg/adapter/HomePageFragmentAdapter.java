package com.example.a2501974391_mcs_lab_assg.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a2501974391_mcs_lab_assg.home_home;
import com.example.a2501974391_mcs_lab_assg.home_transaction;

public class HomePageFragmentAdapter extends FragmentStateAdapter {

    Integer curUserId;

    public HomePageFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int curUserId) {
        super(fragmentManager, lifecycle);
        this.curUserId = curUserId;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("curUserId", curUserId);

        Fragment toHome = new home_home();
        toHome.setArguments(bundle);

        switch (position){
            case 0:
                return toHome;
            case 1:
                Fragment toTransaction = new home_transaction();
                toTransaction.setArguments(bundle);
                return toTransaction;
        }
        return toHome;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

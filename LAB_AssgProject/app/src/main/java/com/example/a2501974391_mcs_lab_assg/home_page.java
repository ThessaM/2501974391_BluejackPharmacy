package com.example.a2501974391_mcs_lab_assg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.a2501974391_mcs_lab_assg.adapter.HomePageFragmentAdapter;
import com.example.a2501974391_mcs_lab_assg.adapter.MedTransactionAdapter;
import com.google.android.material.tabs.TabLayout;



//interface ToRefreshHomePage{
//    void refreshHome();
//}

public class home_page extends AppCompatActivity {

    //tab navigation
    TabLayout tabNavigation;
    ViewPager2 viewPage;
    HomePageFragmentAdapter pageAdapter;

    Integer curUserId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //get userId
        curUserId = getIntent().getIntExtra("curUserId", 0);


        //action bar
//        ActionBar custActionBar = getActionBar();
        getSupportActionBar().setTitle(" Home");
        getSupportActionBar().setIcon(R.drawable.baseline_home_24);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //tab navigation
        tabNavigation = findViewById(R.id.homePage_tabLayout);
        viewPage = findViewById(R.id.homePage_viewPager);
        pageAdapter = new HomePageFragmentAdapter(getSupportFragmentManager(), getLifecycle(), curUserId);

        tabNavigation.addTab(tabNavigation.newTab().setText("Home"));
        tabNavigation.addTab(tabNavigation.newTab().setText("Transaction"));
//        tabNavigation.addTab(tabNavigation.newTab().setText("About Us"));
        viewPage.setAdapter(pageAdapter);

        tabNavigation.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabNavigation.selectTab(tabNavigation.getTabAt(position));
            }
        });

    }


    //item menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //item menu
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem menu_logout = findViewById(R.id.menu_logout);
        MenuItem menu_about = findViewById(R.id.menu_about);

        return super.onCreateOptionsMenu(menu);
    }


    //item menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_logout:
//                Intent toLoginPg = new Intent(this, MainActivity.class);
//                startActivity(toLoginPg);
//                this.finish();
                finish();
                return true;
            case R.id.menu_about:
                //go to about page
                Intent toAboutPg = new Intent(this, aboutus_page.class);
                startActivity(toAboutPg);
//                this.finish();
                return true;
//                Intent toTrialPg = new Intent(this, google_map_trial.class);
//                startActivity(toTrialPg);
        }

        return super.onOptionsItemSelected(item);
    }

//    public  void refreshHomeActivity(){
//        recreate();
//    }


//    @Override
//    public void refreshHome() {
//        recreate();
//    }
}
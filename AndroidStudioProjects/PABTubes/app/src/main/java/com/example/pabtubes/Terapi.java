package com.example.pabtubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toolbar;

import com.example.pabtubes.reminder.AlarmReminder;
import com.example.pabtubes.tab_terapi.PagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Terapi extends AppCompatActivity {

    ScrollView scParent, scChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terapi);

        TabLayout tabLayout =findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Psikofarmaka"));
        tabLayout.addTab(tabLayout.newTab().setText("Psikoterapi"));
        tabLayout.addTab(tabLayout.newTab().setText("Terapi Psikososial"));
        tabLayout.addTab(tabLayout.newTab().setText("Terapi Psikoreligius"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager =findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//        final PagerAdapter adapter = new com.example.pabtubes.tab_terapi.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //code untuk Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about:startActivity(new Intent(getApplicationContext(),SkizoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reminder:
                        startActivity(new Intent(getApplicationContext(), AlarmReminder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
                        startActivity(new Intent(getApplicationContext(),profil.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        scParent=(ScrollView)findViewById(R.id.sParent);
        scChild=(ScrollView)findViewById(R.id.sChild);

        scParent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                findViewById(R.id.sChild).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scChild.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }
}

package com.example.pabtubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pabtubes.reminder.AlarmReminder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//cek
public class home extends AppCompatActivity implements View.OnClickListener {
    private CardView tesCard, infoCard, skizoCard, penangananCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tesCard = (CardView) findViewById(R.id.tes_card);
//        infoCard = (CardView) findViewById(R.id.info_card);
        skizoCard = (CardView) findViewById(R.id.skizo_card);
        penangananCard = (CardView) findViewById(R.id.penanganan_card);

        tesCard.setOnClickListener(this);
//        infoCard.setOnClickListener(this);
        skizoCard.setOnClickListener(this);
        penangananCard.setOnClickListener(this);

        //code untuk Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),SkizoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
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

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.tes_card : i =new Intent(this, TesActivity.class);startActivity(i);break;
//            case R.id.info_card : i = new Intent(this,InfoActivity.class);startActivity(i);break;
            case R.id.skizo_card : i = new Intent(this, SkizoActivity.class);startActivity(i);break;
            case R.id.penanganan_card : i = new Intent(this, PenangananActivity.class);startActivity(i);break;
            default:break;
        }
    }
}

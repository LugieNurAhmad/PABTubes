package com.example.pabtubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.pabtubes.reminder.AlarmReminder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PenangananActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView alarmReminder, terapiCard;
    private Button Lreminder, Lterapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penanganan);

        alarmReminder = (CardView) findViewById(R.id.alarmReminderCard);
        alarmReminder.setOnClickListener(this);

        Lreminder = (Button) findViewById(R.id.btn_Lreminder);
        Lreminder.setOnClickListener(this);

        terapiCard = (CardView) findViewById(R.id.terapiCardv);
        terapiCard.setOnClickListener(this);

        Lterapi = (Button) findViewById(R.id.btn_Lterapi);
        Lterapi.setOnClickListener(this);

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
    }

    @Override
    public void onClick(View view) {
        Intent pindah;
        switch (view.getId()){
            case R.id.alarmReminderCard : pindah =new Intent(this, AlarmReminder.class);startActivity(pindah);break;
            case R.id.terapiCardv: pindah = new Intent(this, Terapi.class);startActivity(pindah);break;
            case R.id.btn_Lreminder : pindah =new Intent(this, AlarmReminder.class);startActivity(pindah);break;
            case R.id.btn_Lterapi: pindah = new Intent(this, Terapi.class);startActivity(pindah);break;
            default:break;
//        Intent alarmReminderIntent = new Intent(this, AlarmReminder.class);
//        startActivity(alarmReminderIntent);
        }
    }
}

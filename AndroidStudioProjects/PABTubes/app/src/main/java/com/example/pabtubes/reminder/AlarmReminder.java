package com.example.pabtubes.reminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.pabtubes.R;
import com.example.pabtubes.SkizoActivity;
import com.example.pabtubes.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class AlarmReminder extends AppCompatActivity implements View.OnClickListener {

    private int notificationId =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_reminder);

        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);

        //code untuk Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.reminder);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), SkizoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reminder:
                        return true;
                    case R.id.profil:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.reminderText);
        TimePicker timePicker = findViewById(R.id.timePick);

        Intent intent = new Intent(AlarmReminder.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo",editText.getText().toString());

        //Get Broadcast
        PendingIntent alarmIntent = PendingIntent.getBroadcast(AlarmReminder.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);

        switch (view.getId()){
            case R.id.setBtn:
                int hour =timePicker.getHour();
                int minute = timePicker.getMinute();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"Tersimpan", Toast.LENGTH_SHORT).show();break;

            case R.id.cancelBtn:
                alarm.cancel(alarmIntent);
                Toast.makeText(this,"Batalkan", Toast.LENGTH_SHORT).show();break;
        }
    }
}

package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pabtubes.reminder.AlarmReminder;

public class PenangananActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView alarmReminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penanganan);

        alarmReminder = (CardView) findViewById(R.id.alarmReminderCard);
        alarmReminder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent alarmReminderIntent = new Intent(this, AlarmReminder.class);
        startActivity(alarmReminderIntent);
    }
}

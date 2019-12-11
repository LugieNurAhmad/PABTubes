package com.example.pabtubes.reminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.pabtubes.R;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId = intent.getIntExtra("notificationId",0);
        String message = intent.getStringExtra("todo");
        int importance =NotificationManager.IMPORTANCE_HIGH;

        Intent mainIntent = new Intent(context, AlarmReminder.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,mainIntent,0);

        NotificationManager myNotificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_event_note)
                .setContentTitle("Waktu Medis!")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = "Reminder_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Reminder",
                    importance);
            myNotificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);        }

        myNotificationManager.notify(notificationId, builder.build());
    }
}

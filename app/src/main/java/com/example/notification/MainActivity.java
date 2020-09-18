package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification noti = new Notification.Builder(MainActivity.this)
                        .setTicker("Notification Here")
                        .setContentTitle("Notification")
                        .setContentText("This is Notification...")
                        .setSmallIcon(R.drawable.ic_launcher_background)
//                        .addAction(R.drawable.ic_launcher_foreground,"Action 1",pIntent)
//                        .addAction(R.drawable.ic_launcher_foreground,"Action 2",pIntent)
                        .setContentIntent(pIntent).getNotification();

                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);
            }
        });
    }
}
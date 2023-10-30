package com.example.notificationslistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTest;
    private YourActivity yourActivity = new YourActivity();
    private MyNotificationListenerService myNotificationListenerService = new MyNotificationListenerService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.redalarmdeaf", "com.example.redalarmdeaf.MainActivity"));
        startActivity(intent);

    }

    public class YourActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("C:\\Users\\shira\\AndroidStudioProjects\\RedAlarmDeaf\\app", "com.example.app.MainActivity"));
            startActivity(intent);
        }
    }

    public class MyNotificationListenerService extends NotificationListenerService {

        @Override
        public void onNotificationPosted(StatusBarNotification sbn) {

            // Handle the notification when it is posted by another app

            // You can access information about the notification, including its title and content.

            String notificationTitle = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TITLE, "").toString();

            // Update the title in your app based on the received notification

            updateTitle(notificationTitle);

        }

        private void updateTitle(String notificationTitle) {
            textViewTest.setText("ggggg");
        }


        // Implement other necessary methods, such as onNotificationRemoved, if needed

    }

}
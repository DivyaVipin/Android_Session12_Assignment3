package assignment.android.acadgild.inboxstylenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Button btnInbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInbox=(Button)findViewById(R.id.big_txt_notification);
        btnInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher);


                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this).setAutoCancel(true)
                        .setContentTitle("Big Text Style")
                        .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon1)
                        .setContentText("Hello World!");

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText("Helloo..!\nHow are you?\nHiii!!!\nI am fine.......\nwhat about you?all is well?\nYes everything is all right....");
                bigText.setBigContentTitle("EventDetails");
                bigText.setSummaryText("By: Divya");
                mBuilder.setStyle(bigText);

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(MainActivity.this, SecondActivity.class);

                // The stack builder object will contain an artificial back stack for
                // the
                // started Activity.
                // This ensures that navigating backward from the Activity leads out of
                // your application to the Home screen.
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);

                // Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder.addParentStack(MainActivity.class);

                // Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // mId allows you to update the notification later on.
                mNotificationManager1.notify(100, mBuilder.build());



            }
        });
    }
}

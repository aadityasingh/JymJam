package alan.jymjam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BuddyConnect extends AppCompatActivity {
    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_connect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Fill out relevant subfields
                data = new String[7];
                data[0] = getName();
                data[1] = getPhone();
                data[2] = getDate();
                data[3] = getTime();
                data[4] = getGym();
                data[5] = getLevel();
                data[6] = getWorkout();


                int duration = Toast.LENGTH_LONG;
                String text = "Application succesfully sent...";
                Toast to = Toast.makeText(getApplicationContext(), text, duration);
                to.show();
                String text1 = "You will recieve a notification when a match is made!";
                Toast t1 = Toast.makeText(getApplicationContext(), text1, duration);
                t1.show();
                startActivity(new Intent(BuddyConnect.this, Response.class));
            }
        });

        Button can = (Button) findViewById(R.id.cancel);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuddyConnect.this, UserInterface.class));
            }
        });
    }

    private String getWorkout()
    {
        Spinner workSpinner = (Spinner) findViewById(R.id.workoutspin);
        return workSpinner.getSelectedItem().toString();

    }
    private Boolean getResponse()
    {
        return Boolean.TRUE;
    }
    private String getGym()
    {
        Spinner gymSpinner = (Spinner) findViewById(R.id.gymspin);
        return gymSpinner.getSelectedItem().toString();

    }

    private String getLevel()
    {
        Spinner levelSpinner = (Spinner) findViewById(R.id.levelspin);
        return levelSpinner.getSelectedItem().toString();

    }

    private String getName()
    {
        EditText nameOfuser = (EditText)findViewById(R.id.name);
        return nameOfuser.getText().toString();

    }

    private String getPhone()
    {
        EditText phoneNum = (EditText)findViewById(R.id.phone);
        return phoneNum.getText().toString();
    }

    private String getDate()
    {
        EditText dateOf = (EditText)findViewById(R.id.date);
        return dateOf.getText().toString();
    }

    private String getTime()
    {
        EditText timeOf = (EditText)findViewById(R.id.time);
        return timeOf.getText().toString();
    }

    private void sendNotification(View view) {

//Get an instance of NotificationManager//

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.com_facebook_favicon_blue).setContentTitle("Match made!").setContentText("Buddy up now: Accept or Decline");
        mBuilder.setAutoCancel(true);
        Intent notificationIntent = new Intent(this, Response.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, mBuilder.build());
    }


}

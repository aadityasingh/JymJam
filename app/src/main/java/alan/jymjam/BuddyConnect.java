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
import android.os.Bundle;

import java.net.Socket;


//import io.socket.client.Socket;
//import io.socket.client.IO;
//import io.socket.emitter.Emitter;

public class BuddyConnect extends AppCompatActivity {
    String[] data;
    String name;
    String surname;
    String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_connect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle inBundle = getIntent().getExtras();
        name = inBundle.get("name").toString();
        surname = inBundle.get("surname").toString();
        imageUrl = inBundle.get("imageUrl").toString();
        final Client socket = new Client("10.182.6.84", 8081);
        socket.setClientCallback(new Client.ClientCallback () {
            @Override
            public void onMessage(String message) {
                // Message received back should be of the form: "First_Name Last_Name$Phone_Number"
                Intent next = new Intent(BuddyConnect.this, Decision.class);
                String[] info = new String[2];
                info = message.split("$");
                next.putExtra("name", info[0]);
                next.putExtra("phone", info[1]);
                startActivity(next);
            }

            @Override
            public void onConnect(Socket socket) {
//                socket.send("Hello World!\n");
//                socket.disconnect()
            }

            @Override
            public void onDisconnect(Socket socket, String message) {
            }

            @Override
            public void onConnectError(java.net.Socket socket, String message) {
            }
        });

        socket.connect();

        Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Fill out relevant sub-fields
                data = new String[7];
                data[0] = getName();
                data[1] = getPhone();
                data[4] = getGym();
                data[5] = getLevel();
                data[6] = getWorkout();
                String tot = "";
                for(int m = 0; m < data.length; m++)
                {
                    tot += data[m] + "$";
                }

                int duration = Toast.LENGTH_LONG;
                try {
                    socket.send(tot);
                    String text = "Application successfully sent...";
                    Toast to = Toast.makeText(getApplicationContext(), text, duration);
                    to.show();
                    String text1 = "You will receive a notification when a match is made!";
                    Toast t1 = Toast.makeText(getApplicationContext(), text1, duration);
                    t1.show();
                    startActivity(new Intent(BuddyConnect.this, Response.class));
                }
                catch (Exception e) {
                    String text = "Oops! Something went wrong...";
                    Toast to = Toast.makeText(getApplicationContext(), text, duration);
                    to.show();
                }

            }
        });

        Button can = (Button) findViewById(R.id.cancel);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(BuddyConnect.this, UserInterface.class);
                next.putExtra("name", name);
                next.putExtra("surname", surname);
                next.putExtra("imageUrl", imageUrl);
                startActivity(next);
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
//        EditText nameOfuser = (EditText)findViewById(R.id.name);
//        return nameOfuser.getText().toString();
        return "" + name + " " + surname;
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

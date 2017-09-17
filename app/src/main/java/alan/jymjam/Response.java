package alan.jymjam;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;

public class Response extends AppCompatActivity {
private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
        if(getMatch())
        {
            sendNotification();
            spinner.setVisibility(View.INVISIBLE);
            startActivity(new Intent(Response.this, Decision.class));
        }

    }

    private void sendNotification() {

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

    private Boolean getMatch()
    {
        return true;
    }


}

package alan.jymjam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

import java.io.InputStream;

public class UserInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (isLoggedIn() == false) {
//            startActivity(new Intent(UserInterface.this, Login.class));
//        }
        setContentView(R.layout.activity_user_interface);

        Bundle inBundle = getIntent().getExtras();
        final String name = inBundle.get("name").toString();
        final String surname = inBundle.get("surname").toString();
        final String imageUrl = inBundle.get("imageUrl").toString();

        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
        nameView.setText("" + name + " " + surname);
        new DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageUrl);
        FacebookSdk.sdkInitialize(getApplicationContext());
        Button logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                Intent login = new Intent(UserInterface.this, Login.class);
                startActivity(login);
                finish();
            }
        });

        Button bud = (Button) findViewById(R.id.buddy);
       // Button pt = (Button)findViewById(R.id.pt);
        bud.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(UserInterface.this, BuddyConnect.class);
                next.putExtra("name", name);
                next.putExtra("surname", surname);
                next.putExtra("imageUrl", imageUrl);
                startActivity(next);
            }
        });
/*
        pt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        */
    }
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}

class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImage(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}

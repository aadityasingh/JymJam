package alan.jymjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        Button bud = (Button) findViewById(R.id.buddy);
       // Button pt = (Button)findViewById(R.id.pt);
        bud.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(UserInterface.this, BuddyConnect.class));
            }
        });
/*
        pt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        */
    }
}

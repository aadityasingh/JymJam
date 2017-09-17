package alan.jymjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
                data = new String[5];
                //{getName();, getPhone();, getDate();, getTime();, getGym();, getLevel();, getWorkout();};
                int duration = Toast.LENGTH_LONG;
                String text = "Finding other users...";
                Toast to = Toast.makeText(getApplicationContext(), text, duration);
                to.show();
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


}

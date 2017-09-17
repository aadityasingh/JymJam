package alan.jymjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Decision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        Bundle inBundle = getIntent().getExtras();
        final String name = inBundle.get("name").toString();
        final String phone = inBundle.get("phone").toString();
        TextView nameView = (TextView)findViewById(R.id.name);
        nameView.setText("" + name + " ");
        TextView phoneView = (TextView)findViewById(R.id.phone);
        phoneView.setText("" + phone + " ");
    }
}

package appewtc.masterung.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private ListView listView;
    private String[] loginStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initialView();

        //Get Value From Intent
        getValueFromIntent();

    }   // Main Method

    private void getValueFromIntent() {
        loginStrings = getIntent().getStringArrayExtra("Login");
        textView.setText(loginStrings[1]);
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtName);
        imageView = (ImageView) findViewById(R.id.imvQR);
        listView = (ListView) findViewById(R.id.livProduct);
    }

}   // Main Class

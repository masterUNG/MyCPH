package appewtc.masterung.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private ListView listView;
    private String[] loginStrings, nameStrings, dateStrings, detailStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initialView();

        //Get Value From Intent
        getValueFromIntent();

        createListView();

    }   // Main Method

    private void createListView() {
        String tag = "27AprilV2";
        String urlPHP = "http://swiftcodingthai.com/cph/getProduct.php";

        try {

            GetData getData = new GetData(ServiceActivity.this);
            getData.execute(urlPHP);
            String strJSON = getData.get();
            Log.d(tag, "JSON ==> " + strJSON);


        } catch (Exception e) {
            Log.d(tag, "e createListView ==> " + e.toString());
        }

    }

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

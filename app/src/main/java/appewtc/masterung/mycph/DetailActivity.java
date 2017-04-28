package appewtc.masterung.mycph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView nameTextView, dateTextView,
            detailTextView, receiveNameTextView;
    private String qrCodeString;
    private String tag = "28AprilV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialView();

        controller();

        //Get Value From Intent
        getValueFromIntent();


    }   // Main Method

    private void getValueFromIntent() {
        qrCodeString = getIntent().getStringExtra("QRcode");
        Log.d(tag, "QRcode ==> " + qrCodeString);
    }

    private void controller() {
        imageView.setOnClickListener(DetailActivity.this);
    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.imvBack);
        nameTextView = (TextView) findViewById(R.id.txtName);
        dateTextView = (TextView) findViewById(R.id.txtDate);
        detailTextView = (TextView) findViewById(R.id.txtDetail);
        receiveNameTextView = (TextView) findViewById(R.id.txtReceiveName);

    }

    @Override
    public void onClick(View view) {

        if (view == imageView) {
            finish();
        }

    }
}   // Main Class

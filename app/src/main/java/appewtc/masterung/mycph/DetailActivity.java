package appewtc.masterung.mycph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

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

        //Show View
        showView();


    }   // Main Method

    private void showView() {

        MyConstant myConstant = new MyConstant();
        String[] columnProduct = myConstant.getColumnProduct();
        String urlPHP = myConstant.getUrlGetProductWhereQR();

        try {

            GetProductWhereQR getProductWhereQR = new GetProductWhereQR(DetailActivity.this);
            getProductWhereQR.execute(columnProduct[2], qrCodeString, urlPHP);

            String strJSON = getProductWhereQR.get();
            Log.d(tag, "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            String[] resultStrings = new String[columnProduct.length];
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            for (int i=0;i<resultStrings.length;i++) {
                resultStrings[i] = jsonObject.getString(columnProduct[i]);
                Log.d(tag, "result(" + i + ") ==> " + resultStrings[i]);
            }

            nameTextView.setText(resultStrings[1]);
            dateTextView.setText(resultStrings[5]);
            detailTextView.setText(resultStrings[4]);
            receiveNameTextView.setText(findNameReceive(resultStrings[3]));


        } catch (Exception e) {
            Log.d(tag, "e showView ==> " + e.toString());
        }
    }

    private String findNameReceive(String idReceive) {

        String tag2 = "28AprilV2";

        try {

            GetProductWhereQR getProductWhereQR = new GetProductWhereQR(DetailActivity.this);
            getProductWhereQR.execute();

        } catch (Exception e) {
            Log.d(tag2, "e findName ==> " + e.toString());
        }
        return null;
    }

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

package appewtc.masterung.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialView();

        controller();

    }   // Main Method

    private void controller() {
        button.setOnClickListener(SignUpActivity.this);
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtName);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnRegis);
    }

    @Override
    public void onClick(View view) {

        if (view == button) {

            //Get Value From Edit Text
            nameString = nameEditText.getText().toString().trim();
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                // Have Space
                MyAlert myAlert = new MyAlert(SignUpActivity.this);
                myAlert.myDialog("มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");

            } else {
                // No Space
                try {

                    PostData postData = new PostData(SignUpActivity.this);
                    postData.execute(userString, nameString, passwordString);

                    String result = postData.get();
                    Log.d("26AprilV1", "result ==> " + result);


                } catch (Exception e) {
                    Log.d("26AprilV1", "e SignUp ==>" + e.toString());
                }

            }

        }

    }
}   // Main Class

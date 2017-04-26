package appewtc.masterung.mycph;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 4/26/2017 AD.
 */

public class PostData extends AsyncTask<String, Void, String>{

    private Context context;
    private static final String urlPHP = "http://swiftcodingthai.com/cph/addUserMaster.php";

    public PostData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("User", strings[0])
                    .add("Name", strings[1])
                    .add("Password", strings[2])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("26AprilV1", "e doin ==> " + e.toString());
            return null;
        }


    }
}   // Main Class

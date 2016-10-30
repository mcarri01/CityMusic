/*
 * Returns JSON w/ city name and playlist for the city when provided a name
 * Sends Volley request to server route to receive JSON.
 */

package com.example.mcarr.practiceapp;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) throws Exception {
        final ProgressDialog progress;
        progress = ProgressDialog.show(this, "One moment", "Sending request", true);
        EditText city = (EditText) findViewById(R.id.input);
        final String cityName = city.getText().toString();
        Log.d("Cityname:", cityName);
        final TextView status = (TextView) findViewById(R.id.status);
        String requestUrl = "https://flask-mustrip.herokuapp.com/playlistbycity";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST,
                requestUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        status.setText(response);
                        progress.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("city", cityName);
                return params;
            }
        };
        queue.add(sr);
    }
}





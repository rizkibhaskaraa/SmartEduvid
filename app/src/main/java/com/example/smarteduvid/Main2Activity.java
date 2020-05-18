package com.example.smarteduvid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    TextView mTitleTv;
    ImageView mImageIv;
    private TextView tvTotalConfirmed, tvTotalDeaths, tvTotalRecovered,tvTotalPerawatan;

    public static final String key = "rb";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();



        mTitleTv = findViewById(R.id.title);
        mImageIv = findViewById(R.id.imageView);

        //now get our data from intent in which we put our data

        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");

        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        //now decode image because from previous activity we get our image in bytes

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        actionBar.setTitle(mTitle); //which title we get from previous activity that we set in our action bar

        // now set our data in our view , which we get in our previous activity
        mTitleTv.setText(mTitle);

        mImageIv.setImageBitmap(bitmap);


        tvTotalConfirmed = findViewById(R.id.totalConfirmed);
        tvTotalDeaths = findViewById(R.id.totalDeaths);
        tvTotalRecovered = findViewById(R.id.totalRecovered);
        tvTotalPerawatan = findViewById(R.id.totalPerawatan);

        getData();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(Main2Activity.this);

        String url = "https://indonesia-covid-19.mathdro.id/api/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject mjsonArray = new JSONObject(response);

                    tvTotalPerawatan.setText(mjsonArray.getString("perawatan"));
                    tvTotalConfirmed.setText(mjsonArray.getString("jumlahKasus"));
                    tvTotalDeaths.setText(mjsonArray.getString("meninggal"));
                    tvTotalRecovered.setText(mjsonArray.getString("sembuh"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response", error.toString());

            }
        });
        queue.add(stringRequest);

    }
}

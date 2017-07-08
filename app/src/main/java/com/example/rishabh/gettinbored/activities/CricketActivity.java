package com.example.rishabh.gettinbored.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.cricketAdapter;
import com.example.rishabh.gettinbored.api.crickApi;
import com.example.rishabh.gettinbored.model.cricketmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CricketActivity extends AppCompatActivity {

    RecyclerView rvcricket;
    cricketAdapter cricketadapter;
    public static final String TAG="hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);
        rvcricket=(RecyclerView)findViewById(R.id.rvcricket);
        rvcricket.setLayoutManager(new LinearLayoutManager(CricketActivity.this));
        cricketadapter = new cricketAdapter(CricketActivity.this,new ArrayList<cricketmodel>());
        Log.d(TAG, "onCreate: hj");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://cricapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final crickApi crickapi = retrofit.create(crickApi.class);

        Callback<ArrayList<cricketmodel>> postcallback3 = new Callback<ArrayList<cricketmodel>>() {
            @Override
            public void onResponse(Call<ArrayList<cricketmodel>> call, Response<ArrayList<cricketmodel>> response) {
                rvcricket.setAdapter(cricketadapter);
                Log.d(TAG, "onResponse: onresponse");
                cricketadapter.updatematches(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<cricketmodel>> call, Throwable t) {
                Toast.makeText(CricketActivity.this, "no matches today", Toast.LENGTH_SHORT).show();
            }
        };
        int userIdReceived = getIntent().getIntExtra("userId", -1);
        if (userIdReceived != -1) {
            crickapi.getstats().enqueue(postcallback3);
        }
        else
            crickapi.getstats().enqueue(postcallback3);


    }
}

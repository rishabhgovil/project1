package com.example.rishabh.gettinbored.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.rishabh.gettinbored.OnItemClickListener;
import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.tvAdapter;
import com.example.rishabh.gettinbored.api.tvApi;
import com.example.rishabh.gettinbored.model.tv_shows;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TV2Activity extends AppCompatActivity {

    RecyclerView rvtv;
    tvAdapter tvadapter;
    public static final String TAG="tv";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        rvtv = (RecyclerView) findViewById(R.id.rvtv);
        rvtv.setLayoutManager(new LinearLayoutManager(this));
        tvadapter = new tvAdapter(this, new ArrayList<tv_shows>());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.episodate.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tvApi tvapi = retrofit.create(tvApi.class);
        tvapi.getshows().enqueue(new Callback<tvclass>() {
            @Override
            public void onResponse(Call<tvclass> call, Response<tvclass> response) {
                tvadapter = new tvAdapter(TV2Activity.this,response.body().getTv_shows());
                rvtv.setAdapter(tvadapter);
                tvadapter.updateshows(response.body().getTv_shows());
                tvadapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(String itemid1) {
                        try{
                            Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(itemid1));
                            startActivity(web);
                        }
                        catch(ActivityNotFoundException ae)
                        {
                            Toast.makeText(TV2Activity.this, "activity not found", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<tvclass> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
                Toast.makeText(TV2Activity.this, "No shows running", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

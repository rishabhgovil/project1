package com.example.rishabh.gettinbored.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rishabh.gettinbored.OnItemClickListener;
import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.tvAdapter;
import com.example.rishabh.gettinbored.adapter.tvAdapter2;
import com.example.rishabh.gettinbored.api.tvApi;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TVActivity extends AppCompatActivity {

    RecyclerView rvtv;
    tvAdapter tvadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        rvtv = (RecyclerView) findViewById(R.id.rvtv);
        rvtv.setLayoutManager(new LinearLayoutManager(TVActivity.this));
       /* tvadapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(int itemid){
                Intent intent=new Intent(TVActivity.this,TV2Activity.class);
                intent.putExtra("page",itemid);
                startActivity(intent);
            }
        });*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.episodate.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tvApi tvapi = retrofit.create(tvApi.class);
        Callback<ArrayList<tvclass>> postCallback = new Callback<ArrayList<tvclass>>() {
            @Override
            public void onResponse(Call<ArrayList<tvclass>> call, Response<ArrayList<tvclass>> response) {
                tvadapter = new tvAdapter(TVActivity.this, response.body());
                rvtv.setAdapter(tvadapter);
            }

            @Override
            public void onFailure(Call<ArrayList<tvclass>> call, Throwable t) {

            }
        };
        int userIdReceived = getIntent().getIntExtra("userId", -1);
        if (userIdReceived != -1) {
            tvapi.getshowforpage(userIdReceived).enqueue(postCallback);
        } else {
            tvapi.getshows().enqueue(postCallback);
        }
    }

}

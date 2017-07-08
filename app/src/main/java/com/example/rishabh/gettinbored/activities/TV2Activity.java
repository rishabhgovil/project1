package com.example.rishabh.gettinbored.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.tvAdapter2;
import com.example.rishabh.gettinbored.api.tvApi2;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TV2Activity extends AppCompatActivity {

    RecyclerView rvtv2;
    tvAdapter2 tvadapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv2);
        rvtv2=(RecyclerView)findViewById(R.id.rvtv2);
        rvtv2.setLayoutManager(new LinearLayoutManager(this));
        tvadapter2 = new tvAdapter2(this,new ArrayList<tvclass>());

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.episodate.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tvApi2 tvapi2=retrofit.create(tvApi2.class);
        Callback<ArrayList<tvclass>> postcallback2=new Callback<ArrayList<tvclass>>() {
            @Override
            public void onResponse(Call<ArrayList<tvclass>> call, Response<ArrayList<tvclass>> response) {
                rvtv2.setAdapter(tvadapter2);
                tvadapter2.updateshow(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<tvclass>> call, Throwable t) {
                Toast.makeText(TV2Activity.this, "No shows", Toast.LENGTH_SHORT).show();
            }
        };
        int userIdReceived = getIntent().getIntExtra("userId", -1);
        if (userIdReceived != -1) {
            tvapi2.getpagessbyid(userIdReceived).enqueue(postcallback2);
        } else {
            tvapi2.getpagessbyid(userIdReceived).enqueue(postcallback2);
        }

    }
}

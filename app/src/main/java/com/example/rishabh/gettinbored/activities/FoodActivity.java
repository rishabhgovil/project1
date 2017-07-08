package com.example.rishabh.gettinbored.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.foodAdapter;
import com.example.rishabh.gettinbored.model.foodmodel;


import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    RecyclerView rvfood;
    foodAdapter foodadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        rvfood=(RecyclerView)findViewById(R.id.rvfood);
        foodadapter=new foodAdapter(this, new ArrayList<foodmodel>());
        rvfood.setAdapter(foodadapter);

       /* final foodApi foodapi=retrofit.create(foodApi.class);

        Call<ArrayList<foodmodel>> foodcallback=foodapi.getFood();
        foodcallback.enqueue(new Callback<ArrayList<foodmodel>>(){
            @Override
            public void onResponse(Call<ArrayList<foodmodel>> call, Response<ArrayList<foodmodel>> response) {
                foodadapter.updatefoods(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<foodmodel>> call, Throwable t) {

            }
        });*/

    }

}

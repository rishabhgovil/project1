package com.example.rishabh.gettinbored.api;

import com.example.rishabh.gettinbored.model.foodmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RISHABH on 05-07-2017.
 */

public interface foodApi {
    @GET("/xml/simple.xml")
    Call<ArrayList<foodmodel>> getFood();
}

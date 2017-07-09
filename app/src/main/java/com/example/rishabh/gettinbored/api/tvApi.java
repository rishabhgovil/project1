package com.example.rishabh.gettinbored.api;

import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RISHABH on 07-07-2017.
 */

public interface tvApi {
    @GET("/api/most-popular?page=1/api/most-popular")
    Call<tvclass> getshows();

}

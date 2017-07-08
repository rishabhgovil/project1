package com.example.rishabh.gettinbored.api;

import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RISHABH on 07-07-2017.
 */

public interface tvApi2 {
    @GET("api/most-popular?page={page}/api/most-popular?page=:page")
    Call<ArrayList<tvclass>> getpagessbyid(@Query("page") int page);
}

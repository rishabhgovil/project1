package com.example.rishabh.gettinbored.api;

import com.example.rishabh.gettinbored.model.newsclass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RISHABH on 04-07-2017.
 */

public interface newsApi {

    @GET("articles?source=the-times-of-india&sortBy=latest&apiKey=d43874e411d74a719490520d7297d028")
    Call<newsclass> getnews();



}

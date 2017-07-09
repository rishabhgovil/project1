package com.example.rishabh.gettinbored.api;

import com.example.rishabh.gettinbored.model.cricketmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RISHABH on 07-07-2017.
 */

public interface crickApi {
    @GET("api/matches/DGireQ2BaMVOzwmDitNfLNqjY1u1")
    Call<cricketmodel> getstats();
}

package com.example.rishabh.gettinbored.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabh.gettinbored.OnItemClickListener;
import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.newsAdapter;
import com.example.rishabh.gettinbored.api.newsApi;
import com.example.rishabh.gettinbored.model.articles;
import com.example.rishabh.gettinbored.model.newsclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity {

    RecyclerView rvnews;
    newsAdapter newsadapter;
    TextView newsurl;
    public static final String TAG="newsactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rvnews=(RecyclerView)findViewById(R.id.rvnews);
        newsurl=(TextView)findViewById(R.id.newsurl);
        rvnews.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
        newsadapter = new newsAdapter(this,new ArrayList<articles>());
        Log.d(TAG, "onCreate: vdv");
        newsadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String itemid) {
                    String togo=newsurl.getText().toString();
                Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(togo));
                startActivity(web);
            }
        });


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        final newsApi newsapi=retrofit.create(newsApi.class);

        newsapi.getnews().enqueue(new Callback<newsclass>() {
            @Override
            public void onResponse(Call<newsclass> call, Response<newsclass> response) {

                newsadapter=new newsAdapter(NewsActivity.this,response.body().getArticles());
                rvnews.setAdapter(newsadapter);
            }

            @Override
            public void onFailure(Call<newsclass> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "No News Update", Toast.LENGTH_SHORT).show();
            }
        });
       




    }
}

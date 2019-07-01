package com.example.taskfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    String TAG = "mainThread";
    public Context mContext = this;
    ArrayList<CardItem> cardsArray;
    public static ArrayList<Article> articles;
// Creates recyclerView and adapter and links them together.
    public void initRecyclerView(){
        Log.d(TAG, "onCreate: Recycler reached");
        recycler = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(cardsArray, mContext);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(recyclerAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Retrofit Object that takes care of parsing JSON file from API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsArticleApi newsApi = retrofit.create(NewsArticleApi.class);
        Call<GeneralItem> call = newsApi
                .getNews("https://newsapi.org/v2/everything?q=bitcoin&from=2019-05-30&sortBy=publishedAt&apiKey=cf253bf3c85c4b5c929aac4f922a76d8");
        Log.d(TAG, "onCreate: enqueuing call");
        call.enqueue(new Callback<GeneralItem>() {
            @Override
            public void onResponse(Call<GeneralItem> call, Response<GeneralItem> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Unsuccessful server call. Code: " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: Successful server call");
                articles = response.body().getArticles();
                ArrayList<CardItem> cardList = new ArrayList<CardItem>();
                for (Article article : articles) {
                    cardList.add(new CardItem(article.getDescription(), article.getUrlToImage()));
                }

                cardsArray = cardList;
                initRecyclerView();


            }


            @Override
            public void onFailure(Call<GeneralItem> call, Throwable t) {
                Log.d(TAG, "onFailure: failed to reach server" + t.getMessage());
            }
        });

    }
}

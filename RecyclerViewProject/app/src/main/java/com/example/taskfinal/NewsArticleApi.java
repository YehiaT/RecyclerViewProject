package com.example.taskfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

// Interface for Retrofit to get the GeneralItem list which will be used to get the Article objects.
public interface NewsArticleApi {
    @GET
    Call<GeneralItem> getNews(@Url String url);
}

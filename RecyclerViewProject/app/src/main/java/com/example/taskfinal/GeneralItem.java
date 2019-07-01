package com.example.taskfinal;

import java.util.ArrayList;
import java.util.List;

//General item fetched by retrofit from api. intended to hold article list.
public class GeneralItem {
    private int totalResults;
    private String status;
    private ArrayList<Article> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}

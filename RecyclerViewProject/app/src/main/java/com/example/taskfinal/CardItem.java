package com.example.taskfinal;

// Object to represent the content of each card. To be used in the onBindView. Holds information of cardViews
public class CardItem {
    private String artText;
    private String artImageUrl;

    public CardItem(String text, String image) {

        artText = text;
        artImageUrl = image;

    }

    public String getArtText() {
        return artText;
    }

    public String getArtImageUrl() {
        return artImageUrl;
    }
}

package com.example.taskfinal;


//Article object that includes all the necessary details about every article to be displayed on the recyclerView

public class Article {
    private String author;
    private String title;
    private String description;
    private String publishedAt;
    private String content;
    private String urlToImage;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    @Override
    public String toString() {
        return "Author: " + author + "\n Title: " + title + "\nDescription: " + description +
                "\nPublished at: " + publishedAt + "\nContent: " + content + "\n\n";
    }
}

package com.example.taskfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        String artText=(String)getIntent().getExtras().get("Text");
        TextView articleText=findViewById(R.id.artDescription);
        articleText.setText(artText);
        String urlToImage=(String)getIntent().getExtras().get("url");
        ImageView img=findViewById(R.id.artImg);
        Glide.with(this).load(urlToImage).into(img);
    }
}

package com.example.loic.comics_app_android.presentation.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.loic.comics_app_android.R;

public class ComicsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);

        // Pour le test
        Intent intent = new Intent(this, ComicDetailActivity.class);
        startActivity(intent);
    }
}

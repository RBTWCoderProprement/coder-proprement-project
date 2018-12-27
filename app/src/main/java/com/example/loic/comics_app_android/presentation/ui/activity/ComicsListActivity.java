package com.example.loic.comics_app_android.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.manager.ComicsManagerImpl;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.presenter.ComicsListPresenter;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicsListActivity extends AppCompatActivity {

    private ComicsListPresenter presenter = new ComicsListPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        presenter.getAllComics();

    }
}

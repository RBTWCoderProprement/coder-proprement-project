package com.example.loic.comics_app_android.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.manager.ComicsManagerImpl;
import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicsListActivity extends AppCompatActivity {

    private ComicsManagerImpl manage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        manage = new ComicsManagerImpl(getResources());
        manage.getComicById(64966).subscribeOn(Schedulers.io()).subscribeWith(new DisposableSingleObserver<ResultsItem>() {
            @Override
            public void onSuccess(ResultsItem resultsItem) {
                Log.d("mlk",resultsItem.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("mlk", e.getMessage());
                e.printStackTrace();
            }
        }).isDisposed();

        manage.getAllComics().subscribeOn(Schedulers.io()).subscribeWith(new DisposableSingleObserver<List<ResultsItem>>() {
            @Override
            public void onSuccess(List<ResultsItem> listResultsItem) {
                for(ResultsItem result : listResultsItem)
                    Log.d("ListComics",String.valueOf(result.getId()));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ListComics", e.getMessage());
                e.printStackTrace();
            }
        }).isDisposed();

    }
}

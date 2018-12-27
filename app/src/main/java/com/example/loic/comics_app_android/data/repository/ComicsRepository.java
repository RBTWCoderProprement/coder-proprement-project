package com.example.loic.comics_app_android.data.repository;

import android.content.res.Resources;
import android.util.Log;

import com.example.loic.comics_app_android.data.manager.ComicsManagerImpl;
import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.util.List;

import io.reactivex.Single;

public class ComicsRepository {
    private ComicsManagerImpl comicsManager;

    public ComicsRepository(Resources asset){
        comicsManager = new ComicsManagerImpl(asset);
    }

    public Single<List<ResultsItem>> getAllComics() {
        return comicsManager.getAllComics();
    }

    public void test(){
        Log.d("mlk", "test");
    }
}

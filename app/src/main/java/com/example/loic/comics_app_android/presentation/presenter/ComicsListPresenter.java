package com.example.loic.comics_app_android.presentation.presenter;


import android.content.res.Resources;
import android.util.Log;

import com.example.loic.comics_app_android.ComicsApplication;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.data.repository.ComicsRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicsListPresenter {

    private ComicsRepository repository = ComicsApplication.getInstance().getRepository();

    public void getAllComics() {
        repository.getAllComics().subscribeOn(Schedulers.io()).subscribeWith(new DisposableSingleObserver<List<ResultsItem>>() {
            @Override
            public void onSuccess(List<ResultsItem> listResultsItem) {
                for(ResultsItem result : listResultsItem) {
                    Log.d("mlk", String.valueOf(result.getId()));
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("mlk", e.getMessage());
                e.printStackTrace();
            }
        }).isDisposed();
    }

}

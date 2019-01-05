package com.example.loic.comics_app_android.presentation.presenter;


import com.example.loic.comics_app_android.ComicApplication;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.data.repository.ComicRepository;
import com.example.loic.comics_app_android.presentation.ui.view.ComicListView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicListPresenter {

    private ComicRepository repository = ComicApplication.getInstance().getRepository();
    private ComicListView view;

    public ComicListPresenter(ComicListView view) {
        this.view = view;
    }

    public void getAllComics() {
        repository.getAllComics().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<ResultsItem>>() {
            @Override
            public void onSuccess(List<ResultsItem> listComic) {
                view.updateList(listComic);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        }).isDisposed();
    }

}

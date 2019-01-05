package com.example.loic.comics_app_android.presentation.presenter;

import com.example.loic.comics_app_android.ComicApplication;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.data.repository.ComicRepository;
import com.example.loic.comics_app_android.presentation.ui.view.ComicDetailView;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicDetailPresenter {

    private ComicRepository repository = ComicApplication.getInstance().getRepository();
    private ComicDetailView view;

    public ComicDetailPresenter(ComicDetailView view) {
        this.view = view;
    }

    public void getComicById(int id) {
        repository.getComicById(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<ResultsItem>() {
            @Override
            public void onSuccess(ResultsItem resultsItem) {
                view.showComic(new ComicDataWrapper(resultsItem));
                view.updateListCreator(resultsItem.getCreators());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        }).isDisposed();
    }

}

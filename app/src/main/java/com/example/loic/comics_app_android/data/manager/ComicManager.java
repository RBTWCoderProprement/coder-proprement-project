package com.example.loic.comics_app_android.data.manager;

import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.util.List;

import io.reactivex.Single;

public interface ComicManager {
    Single<List<ResultsItem>> getAllComics();
    Single<ResultsItem> getComicById(int id);
}

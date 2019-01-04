package com.example.loic.comics_app_android.data.repository;

import android.content.res.Resources;

import com.example.loic.comics_app_android.data.manager.ComicManager;
import com.example.loic.comics_app_android.data.manager.ComicManagerImpl;
import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.util.List;

import io.reactivex.Single;

public class ComicRepository {
    private ComicManager comicManager;

    public ComicRepository(Resources asset) {
        comicManager = new ComicManagerImpl(asset);
    }

    public Single<List<ResultsItem>> getAllComics() {
        return comicManager.getAllComics();
    }

    public Single<ResultsItem> getComicById(int id) { return comicManager.getComicById(id); }
}

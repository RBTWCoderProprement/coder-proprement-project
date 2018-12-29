package com.example.loic.comics_app_android;

import android.app.Application;

import com.example.loic.comics_app_android.data.repository.ComicRepository;

public class ComicApplication extends Application {
    private static ComicApplication App;
    private ComicRepository repository;

    public static ComicApplication getInstance() {
        return App;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App = this;
        repository = new ComicRepository(getResources());
    }

    public ComicRepository getRepository() {
        return repository;
    }
}

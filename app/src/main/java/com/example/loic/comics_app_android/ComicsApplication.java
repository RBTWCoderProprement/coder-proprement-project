package com.example.loic.comics_app_android;

import android.app.Application;

import com.example.loic.comics_app_android.data.repository.ComicsRepository;

public class ComicsApplication extends Application {
    private static ComicsApplication App;
    private ComicsRepository repository;

    public static ComicsApplication getInstance(){
        return App;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App = this;
        repository = new ComicsRepository(getResources());
    }

    public ComicsRepository getRepository() {
        return repository;
    }
}

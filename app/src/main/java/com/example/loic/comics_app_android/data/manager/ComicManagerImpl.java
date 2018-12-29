package com.example.loic.comics_app_android.data.manager;


import android.content.res.Resources;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.Comic;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Single;

public class ComicManagerImpl implements ComicManager {

    private int jsonSuccess = R.raw.comic_succes;
    private int jsonError = R.raw.comic_error;
    private Resources resources;

    public ComicManagerImpl(Resources assetManager) {
        this.resources = assetManager;
    }


    @Override
    public Single<List<ResultsItem>> getAllComics() {
        return Single.create(s -> {
            Gson gson = new Gson();
            Comic response = gson.fromJson(FileToString(), Comic.class);
            if (response.getCode() != 200) {
                s.onError(new Throwable("Error Code"));
                return;
            }
            s.onSuccess(response.getResults());
        });
    }

    private String FileToString() {
        InputStream inputStream = resources.openRawResource(jsonSuccess);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String str;
            StringBuilder buf = new StringBuilder();

            while ((str = reader.readLine()) != null) {
                buf.append(str).append("\r\n");
            }
            reader.close();
            inputStream.close();
            return buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}

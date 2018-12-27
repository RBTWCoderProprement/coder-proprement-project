package com.example.loic.comics_app_android.data.manager;


import android.content.res.Resources;
import android.util.Log;

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

public class ComicsManagerImpl implements ComicsManager {

    private int jsonSuccess = R.raw.comic_succes;
    private int jsonError = R.raw.comic_error;
    private Resources resources;

    public ComicsManagerImpl(Resources assetManager) {
        this.resources = assetManager;
    }


    @Override
    public Single<List<ResultsItem>> getAllComics() {
        return Single.create(s -> {
            Gson gson = new Gson();
            Comic comics = gson.fromJson(FileToString(), Comic.class);
            if(comics.getCode() != 200) {
                s.onError(new Throwable("Error Code"));
                return;
            }
            s.onSuccess(comics.getResults());
        });
    }

    private String FileToString(){
        InputStream inputStream = resources.openRawResource(jsonSuccess);
        try {
            // open a reader on the inputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // String used to store the lines
            String str;
            StringBuilder buf = new StringBuilder();

            // Read the file
            while ((str = reader.readLine()) != null) {
                buf.append(str).append("\r\n");
            }
            // Close streams
            reader.close();
            inputStream.close();
            return buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}

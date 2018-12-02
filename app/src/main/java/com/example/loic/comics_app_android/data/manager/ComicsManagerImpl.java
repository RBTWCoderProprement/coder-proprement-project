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

import io.reactivex.Single;

public class ComicsManagerImpl {

    private int jsonSuccess = R.raw.comic_succes;
    private Resources resources;

    public ComicsManagerImpl(Resources assetManager) {
        this.resources = assetManager;
    }

    public Single<ResultsItem> getComicById(int id) {
        return Single.create(subsciber -> {
            Gson gson = new Gson();
            Comic comics = gson.fromJson(FileToString(), Comic.class);
            if(comics.getCode() != 500) {
                subsciber.onError(new Throwable("Error Code"));
                return;
            }
            for(ResultsItem result: comics.getResults()) {
                if (result.getId() == id) {
                    subsciber.onSuccess(result);
                }
            }
            subsciber.onError(new Throwable("Error Not found"));
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

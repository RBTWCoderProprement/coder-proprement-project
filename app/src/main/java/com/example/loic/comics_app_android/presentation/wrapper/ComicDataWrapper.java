package com.example.loic.comics_app_android.presentation.wrapper;

import android.util.Log;

import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComicDataWrapper {
    private ResultsItem comic;

    public ComicDataWrapper(ResultsItem comic) {
        this.comic = comic;
    }

    public String parseTimeStamp() {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            date = simpleDateFormat.parse(comic.getDate());
            simpleDateFormat.applyPattern("dd/MM/yyyy");
        } catch (ParseException e) {
            Log.e("ComicDateParseError", "Could not parse comic date for comic " + comic.getId());
            return "";
        }
        return simpleDateFormat.format(date);
    }

    public String concatPageDiamondCodePrice() {
        return comic.getPrice() + " $, " + comic.getPageCount() + " pages - " + comic.getDiamondCode();
    }

    public String contentShare() {
        return comic.getTitle() + "\n\n "+ comic.getDescription() + "\n\n" + parseTimeStamp() + " $\nPrix: " + comic.getPrice();
    }

    public ResultsItem getComic() {
        return this.comic;
    }
}

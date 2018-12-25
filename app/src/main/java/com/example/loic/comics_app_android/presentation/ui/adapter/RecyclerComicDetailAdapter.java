package com.example.loic.comics_app_android.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.viewholder.ComicDetailHolder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecyclerComicDetailAdapter extends RecyclerView.Adapter<ComicDetailHolder> {
    private ResultsItem comic;

    public RecyclerComicDetailAdapter(ResultsItem argDataset) {
        comic = argDataset;
    }

    @Override
    public ComicDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_detail_comic, parent, false);
        return new ComicDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(ComicDetailHolder holder, int position) {
          Picasso.get().load(comic.getImage()).into(holder.comicImage);
          holder.comicTitle.setText(comic.getTitle());
          holder.comicSynopsis.setText(comic.getDescription());
          holder.comicDate.setText(parseTimeStamp(comic.getDate()));
          holder.comicPagePriceDiamond.setText(comic.getPrice() + " $, "+ comic.getPageCount() + " pages - " + comic.getDiamondCode());
    }


        @Override
    public int getItemCount() {
        return 1;
    }


    public String parseTimeStamp(String dateTimeStamp) {
        Date d;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            d = dateFormat.parse(dateTimeStamp);
            dateFormat.applyPattern("dd/MM/yyyy");
        } catch (ParseException e) {
            Log.e("ComicDateParseError", "Could not parse comic date");
            return "";
        }
        return dateFormat.format(d);
    }


}

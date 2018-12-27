package com.example.loic.comics_app_android.presentation.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loic.comics_app_android.R;

public class ComicListHolder extends RecyclerView.ViewHolder {
    public ImageView comicImage;
    public TextView comicTitle;
    public TextView comicDate;
    public TextView comicPageCount;
    public ComicListHolder(View v) {
        super(v);
        comicImage = v.findViewById(R.id.comic_image);
        comicTitle = v.findViewById(R.id.comic_title);
        comicDate = v.findViewById(R.id.comic_date);
        comicPageCount = v.findViewById(R.id.comic_page_count);
    }
}
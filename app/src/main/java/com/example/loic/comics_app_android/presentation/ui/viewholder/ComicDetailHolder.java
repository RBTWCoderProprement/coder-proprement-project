package com.example.loic.comics_app_android.presentation.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loic.comics_app_android.R;

public class ComicDetailHolder extends RecyclerView.ViewHolder {
    public ImageView comicImage;
    public TextView comicTitle;
    public TextView comicSynopsis;
    public TextView comicDate;
    public TextView comicPageCount;

    public ComicDetailHolder(View v) {
        super(v);
        comicImage = v.findViewById(R.id.comic_detail_image);
        comicTitle = v.findViewById(R.id.comic_detail_title);
        comicSynopsis = v.findViewById(R.id.comic_detail_synopsis);
        comicDate = v.findViewById(R.id.comic_detail_date);
        comicPageCount = v.findViewById(R.id.comic_detail_price_page_diamond);
    }
}

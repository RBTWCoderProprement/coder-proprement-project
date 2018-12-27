package com.example.loic.comics_app_android.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.viewholder.ComicListHolder;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerComicListAdapter extends RecyclerView.Adapter<ComicListHolder> {
    private List<ResultsItem> comicList;

    //Constructeur à adapter selon les données
    public RecyclerComicListAdapter(List<ResultsItem> comicList) {
        this.comicList = comicList;
    }

    @Override
    public ComicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //New view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_comic, parent, false);
        return new ComicListHolder(v);
    }

    @Override
    public void onBindViewHolder(ComicListHolder holder, int position) {
        ComicDataWrapper comicDataWrapper = new ComicDataWrapper(comicList.get(position));
        ResultsItem comic = comicDataWrapper.getComic();
        Picasso.get().load(comic.getImage()).into(holder.comicImage);
        holder.comicTitle.setText(comic.getTitle());
        holder.comicDate.setText(comicDataWrapper.parseTimeStamp());
        holder.comicPageCount.setText(comic.getPageCount() + " pages");
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }
}

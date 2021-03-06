package com.example.loic.comics_app_android.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.viewholder.ComicListHolder;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicListAdapter extends RecyclerView.Adapter<ComicListHolder> {
    private List<ResultsItem> comicList;
    private AdapterView.OnItemClickListener onComicClick;

    public ComicListAdapter(List<ResultsItem> comicList, AdapterView.OnItemClickListener click) {
        this.comicList = comicList;
        this.onComicClick = click;
    }

    @Override
    public ComicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_comic_item, parent, false);
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComicClick.onItemClick(null,v,position,0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public void updateList(List<ResultsItem> listComic) {
        this.comicList.clear();
        this.addComicsList(listComic);
    }

    private void addComicsList(List<ResultsItem> listComic) {
        this.comicList.addAll(listComic);
        notifyDataSetChanged();
    }
}

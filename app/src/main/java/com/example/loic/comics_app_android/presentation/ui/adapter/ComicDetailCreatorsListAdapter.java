package com.example.loic.comics_app_android.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.presentation.ui.viewholder.ComicDetailCreatorsHolder;

import java.util.List;

public class ComicDetailCreatorsListAdapter extends RecyclerView.Adapter<ComicDetailCreatorsHolder> {
    private List<CreatorsItem> creatorsList;

    public ComicDetailCreatorsListAdapter(List<CreatorsItem> argDataset) {
        creatorsList = argDataset;
    }

    @Override
    public ComicDetailCreatorsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_comic_creators_list, parent, false);
        return new ComicDetailCreatorsHolder(v);
    }

    @Override
    public void onBindViewHolder(ComicDetailCreatorsHolder holder, int position) {
        holder.creator_name.setText(creatorsList.get(position).getName());
        holder.creator_role.setText(creatorsList.get(position).getRole().toUpperCase());
    }

        @Override
    public int getItemCount() {
        return creatorsList.size();
    }

    public void updateList(List<CreatorsItem> creatorsList) {
        this.creatorsList.clear();
        this.addComicsList(creatorsList);
    }

    private void addComicsList(List<CreatorsItem> creatorsList) {
        this.creatorsList.addAll(creatorsList);
        notifyDataSetChanged();
    }
}

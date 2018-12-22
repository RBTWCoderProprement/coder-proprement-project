package com.example.loic.comics_app_android.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.viewholder.ComicsListHolder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerComicsListAdapter extends RecyclerView.Adapter<ComicsListHolder> {
    private List<ResultsItem> itemList;

    //Constructeur à adapter selon les données
    public RecyclerComicsListAdapter(List<ResultsItem> argDataset) {
        itemList = argDataset;
    }

    @Override
    public ComicsListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //New view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_comic, parent, false);
        return new ComicsListHolder(v);
    }

    @Override
    public void onBindViewHolder(ComicsListHolder holder, int position) {
        Picasso.get().load(itemList.get(position).getImage()).into(holder.comicImage);
        holder.comicTitle.setText(itemList.get(position).getTitle());
        holder.comicDate.setText(parseTimeStamp(itemList.get(position).getDate()));
        holder.comicPageCount.setText(itemList.get(position).getPageCount() + " pages");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public String parseTimeStamp(String dateTimeStamp) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            d = sdf.parse(dateTimeStamp);
            sdf.applyPattern("dd/MM/yyyy");
        } catch (ParseException e) {
            Log.e("ComicDateParseError", "Could not parse comic date");
            return "";
        }
        return sdf.format(d);
    }
}

package com.example.loic.comics_app_android.presentation.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.loic.comics_app_android.R;

public class ComicDetailCreatorsHolder extends RecyclerView.ViewHolder {
  public TextView creator_role;
  public TextView creator_name;

    public ComicDetailCreatorsHolder(View v) {
        super(v);
        creator_role = v.findViewById(R.id.creator_role);
        creator_name = v.findViewById(R.id.creator_name);
    }
}

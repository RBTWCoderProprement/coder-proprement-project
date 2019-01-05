package com.example.loic.comics_app_android.presentation.ui.view;

import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;

import java.util.List;

public interface ComicDetailView {
    void showComic(ComicDataWrapper comicDataWrapper);
    void updateListCreator(List<CreatorsItem> creators);
}

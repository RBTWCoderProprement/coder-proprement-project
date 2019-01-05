package com.example.loic.comics_app_android.presentation.ui.view;

import com.example.loic.comics_app_android.data.model.ResultsItem;

import java.util.List;

public interface ComicListView {
    void updateList(List<ResultsItem> listComic);
    void showError(String message);
}


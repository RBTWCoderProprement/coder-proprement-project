package com.example.loic.comics_app_android.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.presenter.ComicListPresenter;
import com.example.loic.comics_app_android.presentation.ui.adapter.RecyclerComicListAdapter;
import com.example.loic.comics_app_android.presentation.ui.view.ComicListView;

import java.util.ArrayList;
import java.util.List;

public class ComicListActivity extends AppCompatActivity implements ComicListView {

    private ComicListPresenter presenter = new ComicListPresenter(this);

    private RecyclerView comicRecyclerView;
    private RecyclerComicListAdapter recyclerComicListAdapter;

    private List<ResultsItem> comicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);

        this.setTitle("Liste de comics");

        comicRecyclerView = findViewById(R.id.comics_list_rv);
        comicRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerComicListAdapter = new RecyclerComicListAdapter(comicList, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComicListActivity.this, ComicDetailActivity.class);
                intent.putExtra("id", comicList.get(position).getId());
                startActivity(intent);
            }
        });


        comicRecyclerView.setAdapter(recyclerComicListAdapter);

        presenter.getAllComics();

    }

    @Override
    public void updateList(List<ResultsItem> listComic) {
        comicList.clear();
        comicList = listComic;
        recyclerComicListAdapter.updateList(listComic);
    }

}

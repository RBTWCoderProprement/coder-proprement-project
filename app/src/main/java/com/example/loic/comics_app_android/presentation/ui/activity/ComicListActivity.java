package com.example.loic.comics_app_android.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.adapter.RecyclerComicsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ComicListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //DEBUG
    private List<ResultsItem> comicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);

        this.setTitle("Liste de comics");

        mRecyclerView = (RecyclerView) findViewById(R.id.comics_list_rv);
        mRecyclerView.setHasFixedSize(true); //Pas de changement de size du layout -> fixe pour les perfs

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //DONNEES EN DUR POUR LE TEST. On envoie les ResultsItem dans la comicList prise par l'adapter

        ResultsItem comic1 = new ResultsItem();
        comic1.setTitle("Despicable Deadpool (2017) #288");
        comic1.setDate("2017-10-25T00:00:00-0400");
        comic1.setImage("http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg");
        comic1.setPageCount(32);

        ResultsItem comic2 = new ResultsItem();
        comic2.setTitle("All-New Wolverine (2015) #26");
        comic2.setDate("2017-10-25T00:00:00-0400");
        comic2.setImage("http://i.annihil.us/u/prod/marvel/i/mg/9/70/59e7b28f0ab61.jpg");
        comic2.setPageCount(32);

        ResultsItem comic3 = new ResultsItem();
        comic3.setTitle("Jean Grey (2017) #8");
        comic3.setDate("2017-10-25T00:00:00-0400");
        comic3.setImage("http://i.annihil.us/u/prod/marvel/i/mg/6/50/59e7b025d65b0.jpg");
        comic3.setPageCount(32);

        ResultsItem comic4 = new ResultsItem();
        comic4.setTitle("Black Panther (2016) #166");
        comic4.setDate("2017-10-25T00:00:00-0400");
        comic4.setImage("http://i.annihil.us/u/prod/marvel/i/mg/7/20/59e7af8d60851.jpg");
        comic4.setPageCount(32);

        ResultsItem comic5 = new ResultsItem();
        comic5.setTitle("Daredevil (2015) #28");
        comic5.setDate("2017-10-25T00:00:00-0400");
        comic5.setImage("http://i.annihil.us/u/prod/marvel/i/mg/6/d0/59e7b078f063b.jpg");
        comic5.setPageCount(32);

        ResultsItem comic6 = new ResultsItem();
        comic6.setTitle("Despicable Deadpool (2017) #288");
        comic6.setDate("2017-10-25T00:00:00-0400");
        comic6.setImage("http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg");
        comic6.setPageCount(32);

        comicList.add(comic1);
        comicList.add(comic2);
        comicList.add(comic3);
        comicList.add(comic4);
        comicList.add(comic5);
        comicList.add(comic6);

        mAdapter = new RecyclerComicsListAdapter(comicList);
        mRecyclerView.setAdapter(mAdapter);
    }
}

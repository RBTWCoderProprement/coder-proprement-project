package com.example.loic.comics_app_android.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.adapter.RecyclerComicDetailAdapter;

import java.util.ArrayList;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ResultsItem comic;
    private List<CreatorsItem> creators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        this.setTitle(R.string.detail_title_bar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // TODO: icône de partage dans la navbar (partage du titre, prix, date de sortie)

        // On récupère le comic avec le string id passé en paramètre :
        /*
            manage = new ComicsManagerImpl(getResources());
            manage.getComicById(64966).subscribeOn(Schedulers.io()).subscribeWith(new DisposableSingleObserver<ResultsItem>() {
                @Override
                public void onSuccess(ResultsItem resultsItem) {
                    Log.d("mlk",resultsItem.toString());
                }

                @Override
                public void onError(Throwable e) {
                    Log.d("mlk", e.getMessage());
                    e.printStackTrace();
                }
            }).isDisposed();
         */

        mRecyclerView = (RecyclerView) findViewById(R.id.comic_detail_rv);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // Test avec des données en dur
        ResultsItem comic = new ResultsItem();
        comic.setTitle("Despicable Deadpool (2017) #288");
        comic.setDate("2017-10-25T00:00:00-0400");
        comic.setDescription("DEADPOOL KILLS CABLE Parts 1 and 2. Deadpool’s going back to his vile beginnings as a mercenary and wanted killer. No more being a hero. No more X-Men. No more Avengers. And if he wants to break bad again, what’s more despicable than killing your best friend? Cable better get ready because his old friend Wade has him in the crosshairs. PLUS: Includes 3 bonus MARVEL PRIMER PAGES! Story by Robbie Thompson and a TBA artist!");
        comic.setIssueNumber(288);
        comic.setDiamondCode("AUG170836");
        comic.setPrice(3.99);

        CreatorsItem creator1 = new CreatorsItem();
        creator1.setName("Gerry Duggan");
        creator1.setRole("writer");
        CreatorsItem creator2 = new CreatorsItem();
        creator2.setName("Nicholas Filardi");
        creator2.setRole("colorist");
        CreatorsItem creator3 = new CreatorsItem();
        creator3.setName("Scott Koblish");
        creator3.setRole("inker");

        creators.add(creator1);
        creators.add(creator2);
        creators.add(creator3);

        comic.setCreators(creators);
        comic.setImage("http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg");
        comic.setPageCount(32);

        mAdapter = new RecyclerComicDetailAdapter(comic);
        mRecyclerView.setAdapter(mAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();
        if (itemId==android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

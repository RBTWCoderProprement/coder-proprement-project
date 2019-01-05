package com.example.loic.comics_app_android.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.presentation.presenter.ComicDetailPresenter;
import com.example.loic.comics_app_android.presentation.ui.adapter.ComicDetailCreatorsListAdapter;
import com.example.loic.comics_app_android.presentation.ui.view.ComicDetailView;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity implements ComicDetailView {

    private ComicDetailPresenter presenter = new ComicDetailPresenter(this);

    public ImageView comicImage;

    public TextView comicTitle;
    public TextView comicSynopsis;
    public TextView comicDate;
    public TextView comicPagePriceDiamond;

    public RecyclerView comicCreatorsList;
    private ComicDetailCreatorsListAdapter creatorsListAdapter;

    private List<CreatorsItem> creators = new ArrayList<>();

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        this.setTitle(R.string.detail_title_bar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        comicImage = findViewById(R.id.comic_detail_image);
        comicTitle = findViewById(R.id.comic_detail_title);
        comicSynopsis = findViewById(R.id.comic_detail_synopsis);
        comicDate = findViewById(R.id.comic_detail_date);
        comicPagePriceDiamond = findViewById(R.id.comic_detail_price_page_diamond);
        comicCreatorsList = findViewById(R.id.comic_detail_creators_list);
        comicCreatorsList.setLayoutManager(new LinearLayoutManager(this));

        creatorsListAdapter = new ComicDetailCreatorsListAdapter(creators);
        comicCreatorsList.setAdapter(creatorsListAdapter);

        id = getIntent().getIntExtra("id", 0);

        presenter.getComicById(id);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_partager:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comic_detail, menu);
        return true;
    }


    @Override
    public void showComic(ComicDataWrapper comicDataWrapper) {
        Picasso.get().load(comicDataWrapper.getComic().getImage()).into(comicImage);
        comicTitle.setText(comicDataWrapper.getComic().getTitle());
        comicSynopsis.setText(comicDataWrapper.getComic().getDescription());
        comicDate.setText(comicDataWrapper.parseTimeStamp());
        comicPagePriceDiamond.setText(comicDataWrapper.concatPageDiamondCodePrice());
    }

    @Override
    public void updateListCreator(List<CreatorsItem> creators) {
        creatorsListAdapter.updateList(creators);
    }
}

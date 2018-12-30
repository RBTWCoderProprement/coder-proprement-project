package com.example.loic.comics_app_android.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.loic.comics_app_android.R;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.ui.adapter.ComicDetailCreatorsListAdapter;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity {
    private List<CreatorsItem> creators = new ArrayList<>();

    public ImageView comicImage;
    public TextView comicTitle;
    public TextView comicSynopsis;
    public TextView comicDate;
    public TextView comicPagePriceDiamond;
    public RecyclerView comicCreatorsList;
    private RecyclerView.Adapter creatorsListAdapter;

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

        comicImage = findViewById(R.id.comic_detail_image);
        comicTitle = findViewById(R.id.comic_detail_title);
        comicSynopsis = findViewById(R.id.comic_detail_synopsis);
        comicDate = findViewById(R.id.comic_detail_date);
        comicPagePriceDiamond = findViewById(R.id.comic_detail_price_page_diamond);
        comicCreatorsList = findViewById(R.id.comic_detail_creators_list);

//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);

        Picasso.get().load(comic.getImage()).into(comicImage);
        comicTitle.setText(comic.getTitle());
        comicSynopsis.setText(comic.getDescription());
        comicDate.setText(parseTimeStamp(comic.getDate()));
        comicPagePriceDiamond.setText(comic.getPrice() + " $, "+ comic.getPageCount() + " pages - " + comic.getDiamondCode());

        creatorsListAdapter = new ComicDetailCreatorsListAdapter(comic.getCreators());
        comicCreatorsList.setAdapter(creatorsListAdapter);

//        final ArrayAdapter<String> comicCreatorsAdapter = new ArrayAdapter<String>(ComicDetailActivity.this,
//                android.R.layout.simple_list_item_1, prenoms);
//        comicCreatorsList.setAdapter(comicCreatorsAdapter);
//        holder.comicCreatorsList.setAdapter(comicCreatorsList);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                finish();
                return true;
            case R.id.menu_partager:
                //shareComic();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comic_detail, menu);
        return true;
    }

    public String parseTimeStamp(String dateTimeStamp) {
        Date d;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            d = dateFormat.parse(dateTimeStamp);
            dateFormat.applyPattern("dd/MM/yyyy");
        } catch (ParseException e) {
            Log.e("ComicDateParseError", "Could not parse comic date");
            return "";
        }
        return dateFormat.format(d);
    }
}

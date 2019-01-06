package com.example.loic.comics_app_android;

import com.example.loic.comics_app_android.data.model.Comic;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.data.model.ResultsItem;
import com.example.loic.comics_app_android.presentation.wrapper.ComicDataWrapper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComicDataWrapperTest {
    @Test
    public void comicDataWrapperTest(){
        CreatorsItem creatorsItem1 = new CreatorsItem();
        creatorsItem1.setName("creator name");
        creatorsItem1.setRole("writer");

        CreatorsItem creatorsItem2 = new CreatorsItem();
        creatorsItem2.setName("creator name");
        creatorsItem2.setRole("inker");

        List<CreatorsItem> creatorsItemList = new ArrayList<>();
        creatorsItemList.add(creatorsItem1);
        creatorsItemList.add(creatorsItem2);

        ResultsItem resultsItem = new ResultsItem();
        resultsItem.setId(68547);
        resultsItem.setTitle("Titre");
        resultsItem.setDescription("Description");
        resultsItem.setImage("Image");
        resultsItem.setPageCount(30);
        resultsItem.setPrice(10.5);
        resultsItem.setDiamondCode("AUG170836");
        resultsItem.setDate("2017-10-25T00:00:00-0400");
        resultsItem.setCreators(creatorsItemList);

        List<ResultsItem> resultsItemList = new ArrayList<>();
        resultsItemList.add(resultsItem);

        Comic comic = new Comic();
        comic.setCode(200);
        comic.setResults(resultsItemList);

        ComicDataWrapper comicDataWrapper = new ComicDataWrapper(comic.getResults().get(0));

        assertEquals("25/10/2017", comicDataWrapper.parseTimeStamp());
        assertEquals("10.5 $, 30 pages - AUG170836", comicDataWrapper.concatPageDiamondCodePrice());
        assertEquals("Titre\n25/10/2017\n\nPrix: 10.5$",comicDataWrapper.contentShare());


    }
}

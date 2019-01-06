package com.example.loic.comics_app_android;

import com.example.loic.comics_app_android.data.model.Comic;
import com.example.loic.comics_app_android.data.model.CreatorsItem;
import com.example.loic.comics_app_android.data.model.ResultsItem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComicTest {
    @Test
    public void comicModelTest(){
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

        assertEquals(200, comic.getCode());
        assertEquals(68547,comic.getResults().get(0).getId());
        assertEquals("Titre", comic.getResults().get(0).getTitle());
        assertEquals("Description", comic.getResults().get(0).getDescription());
        assertEquals("Image", comic.getResults().get(0).getImage());
        assertEquals(30, comic.getResults().get(0).getPageCount());
        assertEquals(10.5, comic.getResults().get(0).getPrice(),0);
        assertEquals("AUG170836", comic.getResults().get(0).getDiamondCode());
        assertEquals("2017-10-25T00:00:00-0400", comic.getResults().get(0).getDate());
        assertEquals("creator name", comic.getResults().get(0).getCreators().get(0).getName());
        assertEquals("writer", comic.getResults().get(0).getCreators().get(0).getRole());

    }
}

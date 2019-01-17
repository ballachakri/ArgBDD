package com.selenium.maven.argosbdd;

import com.selenium.maven.argosbdd.Hooks.Hooks;
import com.selenium.maven.argosbdd.Results.ResultsPage;
import com.selenium.maven.argosbdd.Search_and_Utils.SearchPage;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegressionTest extends Hooks {

    private SearchPage sPage = new SearchPage ();
    private ResultsPage rPage = new ResultsPage ();

    @Test
    public void searchProductTest ( ) {

        sPage.choiceProduct ("laptop");
        String actualItem = rPage.getSearchedItem ();
        boolean cond = actualItem.equalsIgnoreCase ("laptop");
        Assert.assertTrue (cond);
        Assert.assertEquals ("Laptop", actualItem);
    }

    @Test
    public void byReviewTest ( ) {
        sPage.choiceProduct ("laptop");
        rPage.filterByReview ("5only");

        List <Double> actualReview = rPage.getByReview ();
        assertThat ("Wrong values are stored", actualReview, everyItem (greaterThanOrEqualTo (5.0)));
    }

    @Test
    public void byPriceTest ( ) {
        sPage.choiceProduct ("nike");
        rPage.filterByPriceRange ("£25 - £50");
        List <Double> priceDisplayed = rPage.getPriceRange ();
        System.out.println (priceDisplayed);

    }
    @Test
    public void sortByHighToLowTest ( ) {
        sPage.choiceProduct ("laptop");
        rPage.filterByReview ("5only");
        rPage.sortByLowToHigh ("Price: High - Low");

        System.out.println (" Assertation left");
        List <Double> hightolowPrice= rPage.getPriceSortHighToLow ();

        System.out.println (hightolowPrice.size ());
        System.out.println (hightolowPrice);




    }

}
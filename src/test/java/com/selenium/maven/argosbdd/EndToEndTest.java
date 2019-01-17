package com.selenium.maven.argosbdd;

import com.selenium.maven.argosbdd.Hooks.Hooks;
import com.selenium.maven.argosbdd.Results.ResultsPage;
import com.selenium.maven.argosbdd.Search_and_Utils.SearchPage;
import com.selenium.maven.argosbdd.ShoppingResults.ShoppingResults;
import org.junit.Test;

public class EndToEndTest extends Hooks {

    private SearchPage sPage=new SearchPage ();
    private ResultsPage rPage=new ResultsPage ();
    private ShoppingResults tPage=new ShoppingResults ();

@Test
public void searchProductAndAddToBasket()
{

    sPage.choiceProduct ("laptop");
    rPage.filterByReview ("5only");

    String chosenProduct= rPage.selectRandomProduct ();
    System.out.println (chosenProduct);
    System.out.println (" Assertation left");
    tPage.productToTrolley ();
    tPage.goToTrolley ();
}
@Test
public void checkOuts()
{
    sPage.choiceProduct ("laptop");
    rPage.filterByReview ("5only");
    // rPage.sortByLowToHigh ("Price: High - Low");
    String chosenProduct= rPage.selectRandomProduct ();
    System.out.println (chosenProduct);
    System.out.println (" Assertation left");

//    tPage.productToTrolley ();
//    tPage.goToTrolley ();
//    tPage.collection ("IG1");
//    tPage.chooseStore ();
}
}


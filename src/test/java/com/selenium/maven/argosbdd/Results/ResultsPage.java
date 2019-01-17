package com.selenium.maven.argosbdd.Results;

import com.selenium.maven.argosbdd.DriverHelper.DriverHelper;
import com.selenium.maven.argosbdd.Search_and_Utils.RandomNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverHelper {

    public String getSearchedItem ( ) {
        String item = driver.findElement (By.cssSelector (".font-condensed.search-title__term")).getText ();
        return item;
    }

    public void filterByReview (String reviewChoice)
    {
        List <WebElement> eleList = driver.findElements (By.cssSelector (".ac-facet__label"));

        for (WebElement rl : eleList) {
            if (rl.getText ().equalsIgnoreCase (reviewChoice)) {
                rl.click ();
                break;
            }
        }
    }
    public List <Double> getByReview ()
    {
            List <Double> reviewListDisplayed = new ArrayList <> ();

            List <WebElement> eleList = driver.findElements (By.cssSelector (".ac-star-rating"));

            for (WebElement rl : eleList) {
                String reviewValueString = rl.getAttribute ("data-star-rating");
                double reviewValueDouble = Double.parseDouble (reviewValueString);
                 reviewListDisplayed.add (reviewValueDouble);
            }

            return reviewListDisplayed;
    }
    public void filterByPriceRange (String priceRange)
    {

        List <WebElement> eleList = driver.findElements (By.cssSelector (".ac-facet__label"));

        for (WebElement rl : eleList) {

            if (rl.getText ().equalsIgnoreCase (priceRange)) {
                rl.click ();
                break;
            }
        }
    }
    public List <Double> getPriceRange () {
        List <Double> priceListDisplayed = new ArrayList <> ();
        List <WebElement> eleList = driver.findElements (By.cssSelector (".ac-product-price__amount"));

        for (WebElement rl : eleList) {
            String reviewValueString = rl.getAttribute (".ac-star-rating");
            double getPriceList = Double.parseDouble (rl.getText ().replace ("£", ""));

              priceListDisplayed.add (getPriceList);
        }

            return priceListDisplayed;

    }
    public void sortByLowToHigh(String choice)
    {
        Select allDropDownList= new Select (driver
                .findElement ((By.cssSelector (".font-standard.form-control.sort-select"))));
        allDropDownList.selectByVisibleText (choice);


    }

    public List <Double> getPriceSortHighToLow()

    {
        List <Double> priceList= new ArrayList <> ();

        List <WebElement> eleList = driver.findElements (By.cssSelector (".ac-product-price__amount"));

        for (WebElement rl : eleList) {

        String reviewValueString = rl.getAttribute (".ac-star-rating");
        double getPriceList= Double.parseDouble (rl.getText ().replace ("£",""));

        priceList.add (getPriceList);

        }
        return priceList;
    }





    public String selectRandomProduct()
    {
     List<WebElement> eleList=driver.findElements (By.cssSelector (".ac-product-card__name"));

     int productsDisplayed=eleList.size ();

     System.out.println ("Total number of products displayed to choose randomly  :" + productsDisplayed);

     RandomNumber rndNumber=new RandomNumber ();
     int random= rndNumber.randomNumberGenerated (productsDisplayed);

     WebElement randomProduct=eleList.get (random);

     String chooseProduct=randomProduct.getText ();
     randomProduct.click ();
        System.out.println ("The random Product :   " +chooseProduct);

     return chooseProduct;

    }

}




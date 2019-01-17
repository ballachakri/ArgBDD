package com.selenium.maven.argosbdd.Search_and_Utils;

import com.selenium.maven.argosbdd.DriverHelper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends DriverHelper
{
    public void choiceProduct(String myProduct)
    {
        WebElement ele=driver.findElement (By.cssSelector ("#searchTerm"));
        ele.sendKeys (myProduct);
        driver.findElement (By.cssSelector (".argos-header__search-button")).click ();

//        sleep (3000);
//        new WebDriverWait (driver,20).until (ExpectedConditions.textToBePresentInElementLocated
//                (By.cssSelector (".font-condensed.search-title__term"),myProduct));
    }
}

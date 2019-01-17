package com.selenium.maven.argosbdd.DriverHelper;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.invoke.SwitchPoint;
import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public static WebDriver driver;

    private String browser = "chrome";

    public void ChoiceTheBrowser ( ) {
        switch (browser) {
            case "chrome":

                ChromeDriverManager.getInstance (DriverManagerType.CHROME).setup ();
                driver = new ChromeDriver ();
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance (DriverManagerType.EDGE).setup ();
                driver = new InternetExplorerDriver ();
                break;
            case "Safari" :
                driver =new SafariDriver ();
                break;
            default:
                driver=new FirefoxDriver();
                break;
        }

    }

    public void navigateToBrowser(String url)
    {
        driver.get (url);
    }

    public void maxiBrowser()
    {
        driver.manage ().window ().maximize ();
    }

    public void killCookies()
    {
        driver.findElement (By.linkText ("GOT IT")).click ();
    }

    public void applyWait()
    {
        driver.manage ().timeouts ().implicitlyWait (30, TimeUnit.SECONDS);
    }

    public void sleep(int msec)
    {
        try {
            Thread.sleep (3000);
        }catch (InterruptedException e)
        {
            e.printStackTrace ();
        }
    }

    public void closeTheBrowser()
    {
        driver.quit ();

    }
}
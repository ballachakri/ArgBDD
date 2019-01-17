package com.selenium.maven.argosbdd.Hooks;

import com.selenium.maven.argosbdd.DriverHelper.DriverHelper;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    DriverHelper dHelper=new DriverHelper ();

    @Before
    public void openTheBrowser()
    {
    dHelper.ChoiceTheBrowser ();
    dHelper.navigateToBrowser ("http://www.argos.co.uk");
    dHelper.maxiBrowser ();
    dHelper.killCookies ();
    }

    @After
    public void shutDownBrowser()
    {
        dHelper.closeTheBrowser ();
    }
}

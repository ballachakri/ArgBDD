package com.selenium.maven.argosbdd.Search_and_Utils;

import java.util.Random;

public class RandomNumber
{
public int randomNumberGenerated(int total)
{
    Random r=new Random ();
    int v=r.nextInt (total);
    return v;
}
}

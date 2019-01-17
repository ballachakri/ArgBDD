package com.selenium.maven.argosbdd.JavaPractice;

import java.util.Random;

public class JavaRandom {

    public static void main (String[] args) {
        Random rnd=new Random ();
        int ranNumber=rnd.nextInt (300);
        System.out.println (ranNumber);

    }
}

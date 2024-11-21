package com.sort;

import java.util.ArrayList;
import java.util.Random;



public class App 
{
    public static void main( String[] args )
    {
        int n = 5;
        ArrayList <Integer> arr =new ArrayList<>();
        Random rand = new Random();
        
        for(int i = 0; i<n; i++){
            arr.add(i, rand.nextInt(n+5));
        }
        System.out.println(arr);
        Quicksort.quickSort(arr, 0, n-1);
        System.out.println(arr);
    }
}

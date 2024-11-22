package com.sort;

import java.util.ArrayList;
import java.util.Random;



public class App 
{
    public static void checkSpeed(ArrayList <Integer> arr, String sort){
        if(sort.equals("Quicksort")){
           
            double startTime = System.currentTimeMillis();
            Quicksort.quickSort(arr, 0, arr.size()-1);
            double stopTime = System.currentTimeMillis();
            System.out.println("The Quicksort function sorted the array in "+(stopTime-startTime)/1000+" s.");
        }
    }
    public static void main( String[] args )
    {
       

        int n = 20000000;
        ArrayList <Integer> arr =new ArrayList<>();
        Random rand = new Random();
        
        for(int i = 0; i<n; i++){
            arr.add(i, rand.nextInt(n+5));
        }
        checkSpeed(arr, "Quicksort");
    }
}

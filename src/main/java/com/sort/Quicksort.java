package com.sort;


import java.util.ArrayList;
public class Quicksort {
    public static void quickSort(ArrayList<Integer> arr, int n){
        int pivot = arr.size()/2; 
        for(int i = 0; i<n; i++){
            System.out.println(arr.get(i));
        }
    }
    
}
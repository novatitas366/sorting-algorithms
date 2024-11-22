package com.sort;


import java.util.ArrayList;

public class Quicksort {
    public static void quickSort(ArrayList<Integer> arr, int start, int end){
        
        if(start>=end){
            return;
        }
        int pivot = m_findPivotAndSort(arr, start, end);
        
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
        
    }

    private static int m_findPivotAndSort(ArrayList<Integer> arr, int start, int end){
        
        int pivot = (start+end)/2;
        int temp = arr.get(end);
        arr.set(end, arr.get(pivot));
        arr.set(pivot, temp);


        int i = start-1;

        for(int j = start; j<end; j++){
            if(arr.get(j) <= arr.get(end)){
                i++;
                temp = arr.get(j);
                arr.set(j, arr.get(i));
                arr.set(i, temp);
            }
        }
        i++;
        temp = arr.get(end);
        arr.set(end, arr.get(i));
        arr.set(i, temp);
        

        
        return i;
    }
}

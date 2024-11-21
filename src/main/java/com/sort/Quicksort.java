package com.sort;


import java.util.ArrayList;

public class Quicksort {
    public static void quickSort(ArrayList<Integer> arr, int start, int end){
        if(start>=end){
            return;
        }
        //int pivot = m_findPivotAndSort(arr, start, end);
        int pivot= m_findPivotAndSortDiff(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    private static int m_findPivotAndSort(ArrayList<Integer> arr, int start, int end){
        int pivot = (start+end)/2;
        int temp = arr.get(end);
        arr.set(end, arr.get(pivot));
        arr.set(pivot, temp);


        int i = start-1;

        for(int j = 0; j<end; j++){
            if(arr.get(j) <= arr.get(end)){
                if(i == 5){
                    i-=2;
                    break;
                }
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

    private static int m_findPivotAndSortDiff(ArrayList<Integer> arr, int start, int end){
        int pivot = (start+end)/2;
        int temp = arr.get(end);
        arr.set(end, arr.get(pivot));
        arr.set(pivot, temp);

        int itemFromLeft = start;
        int itemFromRight = end-1;

        while(itemFromLeft < itemFromRight){
            if(itemFromLeft > itemFromRight){
                break;
            }
            if(arr.get(itemFromLeft) <= arr.get(end)){
                itemFromLeft++;
                continue;
            }
            if(arr.get(itemFromRight) >= arr.get(end)){
                itemFromRight--;
                continue;
            }

            if(itemFromRight == itemFromLeft){
                itemFromLeft++;
                itemFromRight--;
                continue;
            }
            if(arr.get(itemFromRight) < arr.get(end) && arr.get(itemFromLeft) > arr.get(end)){
                temp = arr.get(itemFromLeft);
                arr.set(itemFromLeft, arr.get(itemFromRight));
                arr.set(itemFromRight, temp);
            }
        }
        
        temp = arr.get(end);
        arr.set(end, arr.get(itemFromLeft));
        arr.set(itemFromLeft, temp);
        
        return itemFromLeft;
    }
    
}

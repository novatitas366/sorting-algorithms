package com.sort;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

public class Quicksort {

    private final static AtomicInteger activeTaskCount = new AtomicInteger(0);

    public static void quickSort(ArrayList<Integer> arr, int start, int end){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        if(start>=end){
            return;
        }
        int pivot = m_findPivotAndSort(arr, start, end);
        activeTaskCount.incrementAndGet();

        executor.submit(() -> {
            quickSort(arr, start, pivot-1);
            if (activeTaskCount.decrementAndGet() == 0) {
                executor.shutdown();
            }
        });

            
        activeTaskCount.incrementAndGet();
        executor.submit(() -> {
            quickSort(arr, pivot+1, end);
            if(activeTaskCount.decrementAndGet() == 0){
                executor.shutdown();
            }
        
        });
        executor.shutdown();
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
    public static void QuickSortWithTime(ArrayList <Integer> arr, String sort){
            double startTime = System.currentTimeMillis();
            Quicksort.quickSort(arr, 0, arr.size()-1);
            double stopTime = System.currentTimeMillis();
            System.out.println("The Quicksort function sorted the array in "+(stopTime-startTime)/1000+" s.");
        
    }
}

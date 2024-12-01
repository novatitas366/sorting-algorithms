package com.sort;
import java.util.*;


public class Shell {
    public static void shellSort(Integer[] arr) {
        int n = arr.length;
        int h = 1;

        while (h < n/3) {
            h = 3*h+1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j=i; j>=h && arr[j] < arr[j-h]; j-=h) {
                    swap(arr, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double ShellSortWithTime(ArrayList<Integer> arr){
        Integer[] array = arr.toArray(new Integer[0]);
        double startTime = System.currentTimeMillis();
        Shell.shellSort(array);
        arr.clear();
        arr.addAll(Arrays.asList(array));
        double stopTime = System.currentTimeMillis();
        System.out.println("The ShellSort function sorted the array in " + (stopTime - startTime) / 1000 + " s.");
        return stopTime - startTime;
    }
}

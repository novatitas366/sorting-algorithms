package com.sort;

import java.util.ArrayList;

public class Heap {
    public static void heapSort(ArrayList<Integer> arr) {
        int size = arr.size();

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        for (int i = size - 1; i > 0; i--) {

            int temp = arr.get(0); 
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            heapify(arr, i, 0);

        }
    }

    public static void heapify(ArrayList<Integer> arr, int size, int i) {

        int largest = i;

        int left = 2 * i + 1;

        int right = 2 * i + 2;

        if (left < size && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < size && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            heapify(arr, size, largest);
        }
    }
    public static void printArray(ArrayList<Integer> arr) {
        System.out.print("{");
        for (int i = 0; i < arr.size(); i++) {
            if (i != arr.size() - 1) {
                System.out.print(arr.get(i) + ", ");
            }
            else {
                System.out.print(arr.get(i) + "}");
            }
        }
        System.out.println();
    }
    public static double HeapSortWithTime(ArrayList<Integer> arr) {
        /*long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();
        double timeSpent = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("The Heapsort function sorted the array in %.6f seconds.%n", timeSpent);*/

        double startTime = System.currentTimeMillis();
        Heap.heapSort(arr);
        double stopTime = System.currentTimeMillis();
        System.out.println("The Heapsort function sorted the array in " + (stopTime - startTime) / 1000 + " s.");
        return stopTime - startTime;
    }
}

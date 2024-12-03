package com.sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.File;
import java.io.FileNotFoundException;


public class App 
{
    public static void createFileWithNumbers(){
        int n = 2000000;
        ArrayList <Integer> arr =new ArrayList<>();
        Random rand = new Random();
        
        for(int i = 0; i<n; i++){
            arr.add(i, rand.nextInt(n+5));
        }
        try{
        FileWriter fw = new FileWriter("arr.txt");
        for(int i = 0; i<arr.size(); i++){
            fw.write(arr.get(i).toString());
            fw.write(System.lineSeparator());
        }
        fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void fiveArrayTest(){
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i = 0; i<5; i++){
            double shellTimeVid=0;
            double heapTimeVid=0;
            double quickTimeVid=0;
            createFileWithNumbers();
            fileToArray(arr);
            for(int j = 0; j<6; j++){
                shellTimeVid += Shell.ShellSortWithTime(arr);
                heapTimeVid += Heap.HeapSortWithTime(arr);
                quickTimeVid += Quicksort.QuickSortWithTime(arr);
                System.out.println();
                fileToArray(arr);
            }
            shellTimeVid = (shellTimeVid / 6.0) / 1000;
            heapTimeVid = (heapTimeVid / 6.0) / 1000;
            quickTimeVid = (quickTimeVid / 6.0) / 1000;
            shellTimeVid = new BigDecimal(shellTimeVid).setScale(3, RoundingMode.HALF_UP).doubleValue();
            heapTimeVid = new BigDecimal(heapTimeVid).setScale(3, RoundingMode.HALF_UP).doubleValue();
            quickTimeVid = new BigDecimal(quickTimeVid).setScale(3, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Shellsort average Time: "+shellTimeVid+" s.");
            System.out.println("Heapsort average Time: "+heapTimeVid+" s.");
            System.out.println("Quicksort average Time: "+quickTimeVid+" s.");
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static void almostSortedArraySort(){
        for(int i = 0; i<5; i++){
            
            ArrayList<Integer> arr = new ArrayList<>();
            createFileWithNumbers();
            fileToArray(arr);
            double QuicksortAvg=0;
            double HeapAvg=0;
            double ShellAvg=0;
            sortArrayNotComplete(arr);
            
            for(int j = 0; j<5; j++){
                ShellAvg+=Shell.ShellSortWithTime(arr);
                HeapAvg+=Heap.HeapSortWithTime(arr);
                QuicksortAvg+=Quicksort.QuickSortWithTime(arr);
                System.out.println();
                sortArrayNotComplete(arr);
            }
            ShellAvg = (ShellAvg/5)/1000;
            HeapAvg = (HeapAvg/5)/1000;
            QuicksortAvg= (QuicksortAvg/5)/1000;
            ShellAvg = new BigDecimal(ShellAvg).setScale(3, RoundingMode.HALF_UP).doubleValue();
            HeapAvg = new BigDecimal(HeapAvg).setScale(3, RoundingMode.HALF_UP).doubleValue();
            QuicksortAvg = new BigDecimal(QuicksortAvg).setScale(3, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Shellsort average Time: "+ShellAvg+" s.");
            System.out.println("Heapsort average Time: "+HeapAvg+" s.");
            System.out.println("Quicksort average Time: "+QuicksortAvg+" s.");
            System.out.println("----------------------------------------------------------------");
            System.out.println();
    }
        
    }
    public static void fileToArray(ArrayList <Integer> arr){
        arr.clear();
        File file = new File("arr.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()){
                arr.add(sc.nextInt());
            }
            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void sortArrayNotComplete(ArrayList<Integer> arr){
        fileToArray(arr);
        Quicksort.quickSort(arr, 0, arr.size()-1);
        for(int j = 0; j < 10; j++){
            Random random = new Random();
            arr.add(random.nextInt());
        }
    }
    public static void main( String[] args )
    {
        
        //fiveArrayTest();
        
        
        almostSortedArraySort();        
        
        
        
    }
}

package com.sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class App 
{
    public static void createFileWithNames(){
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

    public static void main( String[] args )
    {
        createFileWithNames();

        ArrayList <Integer> arr = new ArrayList<>();

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
        
        
        
        
        Shell.ShellSortWithTime(arr);
        Heap.HeapSortWithTime(arr);
        Quicksort.QuickSortWithTime(arr);
        
    }
}

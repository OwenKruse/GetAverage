package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/kruse.owen/IdeaProjects/GetAverage/src/com/company/List"));
        String str;

        List<String> list = new ArrayList<String>();
        while((str = in.readLine()) != null){
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);
        System.out.println(median(stringArr));
        System.out.println(countZero(stringArr));
        System.out.println(countBelow(stringArr, 1.88));
    }
    static double getAverage(String[] arr){
        double sum = 0;
        for (String s : arr) {
            sum += Double.parseDouble(s);
        }
        return sum/arr.length;
    }
    static double median(String[] arr){
        int middle = arr.length/2;
        if(arr.length%2 == 1){
            return Double.parseDouble(arr[middle]);
        }else{
            return (Double.parseDouble(arr[middle-1]) + Double.parseDouble(arr[middle]))/2;
        }
    }
    static int countZero(String[] arr){
        int count = 0;
        for (String s : arr) {
            if(Double.parseDouble(s) == 0){
                count++;
            }
        }
        return count;
    }
    static int countBelow(String[] arr, double num){
        int count = 0;
        for (String s : arr) {
            if(Double.parseDouble(s) < num){
                count++;
            }
        }
        return count;
    }
}



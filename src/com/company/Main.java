package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.util.Scanner;
import com.company.betTest;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("The median of numbers after 10 is: " +median(listOfNumsAfter10(numArray())));
        System.out.println(betTest.total(1.3, 1, Main.listOfNumsAfter10(numArray())));
    }
    static void plot() throws IOException {
    //create an instance of JFrame class
    JFrame frame = new JFrame();
    // set size, layout and location for frame.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new plot());

    frame.setSize(800, 800);
    frame.setLocation(100, 100);
    frame.setVisible(true);


    }
    static double findLargest(double[] numArray) {
        double largest = numArray[0];
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] > largest) {
                largest = numArray[i];
            }
        }
        return largest;
    }
    static int countOutliers(double[] numArray) {
        double count = 0;
        int i = 0;
        for (double num : numArray) {
            if (num < getAverage(numArray) + 1.5 * (getAverage(numArray) - getMin(numArray))) {
                i++;
            }
        }
        return i;
    }

    static double[] removeOutliers(double[] numArray) {
        double[] newArray = new double[numArray.length];
        int i = 0;
        for (double num : numArray) {
            if (num < getAverage(numArray) + 1.5 * (getAverage(numArray) - getMin(numArray))) {
                newArray[i] = num;
                i++;
            }
        }
        return newArray;
    }
    static double getMin(double[] numArray) {
        double min = numArray[0];
        for (double num : numArray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    public static double[] addX(int n, double arr[], double x)
    {
        int i;

        // create a new array of size n+1
        double[] newarr = new double[]{};

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }
    static int numsAfter10(double[] numArray) {
        int i = 0;
        for (double num : numArray) {
            if (num >= 10) {
                i++;
            }
        }
        return i;
    }
    static double[] listOfNumsAfter10(double[] arr){
        double[] sum = new double[numsAfter10(arr)];
        for (int i = 0; i < sum.length -1; i++) {
            if(arr[i] >= 10){
                double a = arr[i + 1];
                sum[i] = a;
            }
        }
        int current = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[current++] = arr[i];
            }
        }
        arr = Arrays.copyOf(arr, current);
        return arr;
    }

    static double getAverageOf10(double[] arr){
        //get the average of numbers after a number >= 10
        double sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 10){
                sum += arr[i + 1];
                count++;
            }
        }
        return sum/count;
    }
    static double getAverage(double[] arr){
        double sum = 0;
        for (double d : arr) {
            sum += d;
        }
        return sum/arr.length;
    }
    static double[] numArray() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/owenkruse/Downloads/GetAverage/src/com/company/List"));
        String str;
        List<String> list = new ArrayList<String>();
        while((str = in.readLine()) != null){
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);
        double[] doubleArr = new double[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            doubleArr[i] = Double.parseDouble(stringArr[i]);
        }
        return doubleArr;
    }
    static double median(double[] arr){
        double median = 0;
        if(arr.length % 2 == 0){
            median = (arr[arr.length/2] + arr[arr.length/2 - 1])/2;
        }
        else{
            median = arr[arr.length/2];
        }
        return median;
    }
    static int countZero(double[] arr){
        int count = 0;
        for(double d : arr){
            if(d == 0){
                count++;
            }
        }
        return count;
    }
    static int belowMedian(double[] arr, double median){
        int count = 0;
        for(double d : arr){
            if(d < median){
                count++;
            }
        }
        return count;
    }
    static int countBelow(double[] arr, double average){
        int count = 0;
        for(double d : arr){
            if(d < average){
                count++;
            }
        }
        return count;
    }


    public static class plot extends JPanel{
        double[] cord = numArray();
        double marg = 5;
        public plot() throws IOException {
        }

        protected void paintComponent(Graphics grf){
            //create instance of the Graphics to use its methods
            super.paintComponent(grf);
            Graphics2D graph = (Graphics2D)grf;

            //Sets the value of a single preference for the rendering algorithms.
            graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // get width and height
            int width = getWidth();
            int height = getHeight();

            // draw graph
            graph.draw(new Line2D.Double(marg, marg, marg, height-marg));
            graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));

            //find value of x and scale to plot points
            double x = (double)(width-2*marg)/(cord.length-1);
            double scale = (double)(height-2*marg)/getMax();

            //set color for points
            graph.setPaint(Color.RED);

            // set points to the graph
            for(int i=0; i<cord.length; i++){
                double x1 = marg+i*x;
                double y1 = height-marg-scale*cord[i];
                graph.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
            }
        }

        //create getMax() method to find maximum value
        private double getMax(){
            double max = -Integer.MAX_VALUE;
            for(int i=0; i<cord.length; i++){
                if(cord[i]>max)
                    max = cord[i];

            }
            return max;
        }

        //main() method start

}
}



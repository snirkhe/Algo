package com.sher;
import java.util.List;

public class Midpoint {
    static int left = 4, right = 10000000;
    static final int INT_SIZE = 32;


    static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are: \n");
        for (i = 0; i < size; i++)
        {

            int k = arr[i];
            if (arr[Math.abs(k)] >= 0)
                arr[Math.abs(k)] = -arr[Math.abs(k)];
            else
                System.out.print(Math.abs(k));
        } }


    public static void main(String arg[]) {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        printRepeating(arr, arr.length);
    }
}

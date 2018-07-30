package com.sher.array;

/**
 * Given an unsorted array of size n. Array elements are in range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in array.
 * Find these two numbers.
 *
 * Examples:
 *
 *   arr[] = {3, 1, 3}
 *   Output: 2, 3   // 2 is missing and 3 occurs twice
 *
 *   arr[] = {4, 3, 6, 2, 1, 1}
 *   Output: 1, 5  // 5 is missing and 1 occurs twice
 */
public class FindRepeatingAndMissing {
    public static void main(String arg[]) {
        int arr[] = {3, 1, 3};
        find(arr);
    }

    static void find(int arr[]) {
        if (arr.length < 2)
            return;//bug

        int n = 0;
        //assuming that array does not have 0.
        for (int i = 0; i < arr.length; i++) {
            n ^= arr[i];
            n ^= i +1;
        }

        int bit = n & ~ (n - 1);
        int k = 0; //even k = n  will work;
        for (int i = 0; i < arr.length; i++) {
            if ((i & bit) == 1) {
                k ^= arr[i];
            }
            if ((i+1 & bit) == 1) {
                k ^= i+1;
            }
        }

        System.out.println("First :" + k + "; Second :" + (k^n));


    }

}

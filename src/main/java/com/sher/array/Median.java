package com.sher.array;

/**
 * https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
 * Input : ar1[] = {-5, 3, 6, 12, 15}
 *         ar2[] = {-12, -10, -6, -3, 4, 10}
 *         The merged array is :
 *         ar3[] = {-12, -10, -6, -5 , -3,
 *                  3, 4, 6, 10, 12, 15}
 * Output : The median is 3.
 *
 * Input : ar1[] = {2, 3, 5, 8}
 *         ar2[] = {10, 12, 14, 16, 18, 20}
 *         The merged array is :
 *         ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
 *         if the number of the elements are even,
 *         so there are two middle elements,
 *         take the average between the two :
 *         (10 + 12) / 2 = 11.
 * Output : The median is 11.
 *
 * O(log(min(n, m)))
 */
public class Median {

    public static void main(String arg[]) {
       // int ar1[] = {-5, 3, 6, 12, 15};
       // int  ar2[] = {-12, -10, -6, -3, 4, 10};

        int ar1[] = {2, 3, 5, 8};
        int ar2[] = {10, 12, 14, 16, 18, 20};
        System.out.println(median(ar1, ar2));
    }

    static int median(int arg1[], int arg2[]) {
        int n = arg1.length;
        int m = arg2.length;
        int length = 0, median  = 0;
        if ((m + n) % 2 == 0) { //even
            length = (m+n) / 2;
        } else {
            length  = 1 + (m+n)/2;
        }

        int fe = -1, j = 0;
        int i = 0;
        int c = 0;

        while (c < length) {
            if (i < n && j < m && arg1[i] < arg2[j]) {
                i++;
            } else {
                j++;
            }
            c++;
        }

        if ((m + n) % 2 == 0) { //even
            median = Math.max(arg1[i - 1], arg2[j -1]);
            int v1 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE;
            if (i < n)
                v1 = arg1[i];
            if (j < m)
                v2 = arg2[j];

            int m1 = Math.min(v1, v2);
            median  = (median + m1)/ 2;
        } else {
            median = Math.max(arg1[i - 1], arg2[j -1]);
        }

        return median;
    }
}

package com.sher.array;

import java.util.Arrays;

/**
 * https://www.programcreek.com/2014/05/leetcode-h-index-java/
 */
// In a sorted array (desc) H-Index is Max of Min of (a[i], i+1)

// For ASC sorted array
//   HIndex = Max of Min of (A[i], Len - i);
public class HIndex {

    public static void main(String arg[]) {
         int []citations = {10, 8, 5, 3, 3};
        System.out.println(hIndex(citations));

    }
    //ASC array
    static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for(int i = 0; i < citations.length; i++){
            int smaller = Math.min(citations[i], citations.length - i);
            result = Math.max(result, smaller);
        }

        return result;
    }
}

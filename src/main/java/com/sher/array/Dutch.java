package com.sher.array;

import java.util.Arrays;

public class Dutch {

    public static void main(String arg[]) {
        int []citations = {2, 0 ,1,0,2 ,1,1, 2,2};
        int a[] = sortColors(citations);
        System.out.println(Arrays.toString(a));

    }

    static int [] sortColors(int A[]) {
        int left=0, right = A.length - 1;
        int i = 0;
        while(i<=right) {
            if(A[i] == 0)
                swap(A, i++, left++);
            else if(A[i] == 1)
                i++;
            else if(A[i] == 2)
                swap(A, i , right--); //No I ++

            System.out.println(Arrays.toString(A));
        }

        return A;
    }

    static void swap(int []A, int i, int j) {
        int t = A[i];
        A[i] = A[j]; A[j] = t;
    }
}

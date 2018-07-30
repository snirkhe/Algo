package com.sher.dp;

public class RodCut {

    // A Dynamic Programming solution for Rod cutting problem

        /* Returns the best obtainable price for a rod of
           length n and price[] as prices of different pieces */
        static int cutRod(int price[],int n)  {
            int dp[] = new int[n+1];
            dp[0] = 0;

            // Build the table val[] in bottom up manner and return
            // the last entry from the table
            for (int i = 1; i<=n; i++)
            {
                int max_val = Integer.MIN_VALUE;
                for (int j = 1; j <= i; j++)
                    max_val = Math.max(max_val,
                            price[j - 1] + dp[i-j]);
                dp[i] = max_val;
            }

            return dp[n];
        }

        /* Driver program to test above functions */
        public static void main(String args[]) {
            int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
            int size = arr.length;
            //Answer should be 22
            System.out.println("Maximum Obtainable Value is " +
                    cutRod(arr, size));
        }

    /* This code is contributed by Rajat Mishra */

}

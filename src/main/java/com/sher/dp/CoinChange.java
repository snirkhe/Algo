package com.sher.dp;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {
    public static void main(String arg[]) {
        //int s[] = {2, 5, 3, 6};
        //int n = 10;
        int s[] = {1, 5, 6, 9};
        int n = 12;
        int o = minCoinChange(n, s);
        System.out.println("Answer should be 10. But it is :" + o);
    }

    static int coinChange(int n, int s[]) {
        int dp [] = new int [n + 1];
        dp[0] = 1;
        Arrays.fill(dp, 0);
        for (int i=0; i <= n; i++) {
            for (int j = 0; j < s.length; j++) {
                int val = s[j];
                if (val <= i) {
                    dp[j] = dp[j] + dp[i - val];
                }
            }
        }
        return dp[n];

    }

    static int minCoinChange(int n, int s[]) {
        int dp[] = new int[n + 1];

        //i = amount
        //j = coin, set
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        HashMap set = new HashMap<Integer, Integer>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <  s.length; j++) {
                if (i >= s[j]) {
                    //dp[i] = Math.min(1 + dp[i - s[j]], dp[i]);
                    int sol = dp[i - s[j]];
                    if (sol + 1 < dp[i]) {
                        dp[i] = sol + 1;
                        set.put(i, s[j]);
                    }
                }
            }
        }
        System.out.println(set);
        int k = n;
        int sum = 0;
        while (set.containsKey(k) && sum < n) {
            int v = (int)set.get(k);
            System.out.println(v);
            sum += v;
            k = v;
        }
        return dp[n];
    }
}

package com.sher.dp;


/**
 * In computer science, edit distance is a way of quantifying how dissimilar
 * two strings (e.g., words) are to one another
 * by counting the minimum number of operations required to transform one string into the other.
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * https://www.youtube.com/watch?v=Qc2ieXRgR0k&list=PLOtl7M3yp-DV69F32zdK7YJcNXpTunF2b&index=19
 */

//There are many practical applications of edit distance algorithm,
// refer Lucene API for sample. Another example, display all the words in a dictionary
// that are near proximity to a given word incorrectly spelled word.

public class EditDistance {

    static int editDistance(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
           return s2.length();
        }

        if (s2 == null || s2.length() == 0) {
            return s1.length();
        }

        int dp[][] = new int[s1.length() + 1] [s2.length() + 1];
        int i, j=0;
        for (i =0; i <= s1.length(); i++) {
            for (j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if( j == 0) {
                    dp[i][j] = i;
                } else {
                    if (s1.charAt(i -1) == s2.charAt(j -1)) {
                        // i - 1 is because dp starts from index 1 (as 0 index is taken by usecase length 0)
                        // and s1 and s2 starts with index 0;
                        dp[i][j] = dp[i -1][j - 1];
                    } else {
                        dp [i][j] = 1 + Math.min(dp[i - 1][j - 1],       //replace
                                Math.min(dp[i - 1] [j], dp[i] [j - 1])); // Insert = dp[i] [j - 1]
                    }
                }

            }
        }
        return dp[i - 1][j - 1];
    }

    public static void main(String arg[]) {
        //Input:   str1 = "sunday", str2 = "saturday"
        //Output:  3

        //Input:   str1 = "geek", str2 = "gesek"
        //Output:  1
        int o = editDistance("sunday", "saturday");
        System.out.println(o);

    }
}

package com.sher.dp;


// JAVA Code for Dynamic Programming |
// Set 9 (Binomial Coefficient, Or N Choose K)
// C(n, k) = n! / (k! * (n - k)!
// C(n, k) = C (n -1, k- 1) + C ( n -1, k)
// C(n,n) = 1 // Only one way to choose all from all.
// C(n, 0) = 1 // Choosing nothing for nothing.
public class Binomial {

    static int binomialCoeff(int n, int k) {
        int C[][] = new int[n+1][k+1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= min(i, k); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j]; // Picked jth in the set + Did not pick jth in the set.
            }
        }
        return C[n][k];
    }

    // A utility function to return minimum of two integers
    static int min(int a, int b)
    {
        return (a<b)? a: b;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int n = 5, k = 2; //answer should be 10
        System.out.printf("Value of C(%d, %d) is %d ",
                n, k, binomialCoeff(n, k));
    }
}

// This code is contributed by Arnav Kr. Mandal.

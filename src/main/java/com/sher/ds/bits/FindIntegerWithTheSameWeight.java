package com.sher.ds.bits;


/**
 * Define the weight of a non negative integer x to be the number of bits that are set to 1 in its binary
 * representation. For example, since 92 in base-2 equals (1011100)2, the weight of 92 is 4.
 * Write a program which takes as input a non negative integer x and returns a number y
 * which is not equal to x, but has the same weight as x and their difference, | y - x\,
 * is as small as possible. You can assume x is not 0, or all Is.
 * For example, if x = 6 (110), you should return 5(101). //11 = 1011
 */
public class FindIntegerWithTheSameWeight {
    public static void main(String arg[]) {
        int n = 11;
        System.out.println(sameWeight(n));
    }


    private static int sameWeight(int n) {
        for (int i = 0 ; i < (32 - 1); i ++)
         if (((n >>> i) & 1) != ((n >>> i + 1) & 1)) {
            //mismatch, swap bits.
            n = n ^ ((1 << i) | (1 << (i + 1)));
            return n;
        }
        return n;
    }

    //Another problem Find higher Integer With The Same Weight ?
}

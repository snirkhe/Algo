package com.sher.ds.bits;

public class SwapBits {

    static int swap(int n) {
        int bit = 0;
        while (n != 0) {
            bit = bit | (n & 1);
            n = n >>> 1;
            if (n != 0)  //never forget
              bit = bit <<1;

        }
        return bit;
    }


    public static void main (String arg[]) {
        int number = 16; // 13 -> 11, 15->15, 16-> 1
        System.out.println(swap(number));

    }
}

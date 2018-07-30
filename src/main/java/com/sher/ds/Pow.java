package com.sher.ds;

public class Pow {

    public static void main(String arg[]) {
        System.out.println(pow (2, 5));
    }

    static long pow(int x, int y) {
        long r = 1;
        int count = 0;
        while (y != 0) {
            if (y % 2 == 1) {
                r = r * x;
                y--;
            } else {
                r = r * r;
                y = y /2;
            }
            count ++;
        }
        System.out.println("p:"  + count);
        return r;
    }
}

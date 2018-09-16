package com.sher.string;

public class Multiply {
    public static void main(String arg[]) {
        String s2 = "123", s1 = "456";
        System.out.println(multiply(s1, s2));
    }

//    static int multiply(String s1, String s2) {
//            int sum = 0;
//            int pi=0;
//            for (int i = s1.length() - 1; i >= 0; i--) {
//                int s = s1.charAt(i) - '0' ;
//                int r = 0, c = 0;
//                int pj = 0;
//
//                for (int j = s2.length() -1; j >=0; j--) {
//                    int t = s2.charAt(j) - '0';
//                    int x = (s * t) + c;
//                    int y = x % 10;
//                    c = x / 10;
//                    r = r + (int)(y * Math.pow(10, pj++));
//                }
//            sum = sum + (int)(r * Math.pow(10, pi++));
//        }
//        return sum;
//    }
    static int multiply(String s1, String s2) {
        int r = 0;
        for (int i = 0; i < s1.length(); i++) {
            char x =  s1.charAt(i);
            int c = 0, y =  0, t = 0;
            for (int j = 0; j < s2.length(); j++) {
                int v = (x - '0') * (s2.charAt(j) - '0');
               t = t * 10 + v;
            }
            r = r * 10 + t;
        }
        return r;
    }

}

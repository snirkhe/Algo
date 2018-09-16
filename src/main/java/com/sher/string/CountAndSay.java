package com.sher.string;

/**
 * The first term is "1"
 *
 * Second term is "11", generated by reading first term as "One 1"
 * (There is one 1 in previous term)
 *
 * Third term is "21", generated by reading second term as "Two 1"
 *
 * Fourth term is "1211", generated by reading third term as "One 2 One 1"
 *
 * Input: n = 5
 * Output: 111221
 */
public class CountAndSay {
    public static void main (String[] args) {
        System.out.println("GfG!");
        countandsay(5);
    }

    static void countandsay(int n) {
        String s = "", r = "1";
        for (int i=1; i < n; i++) {
            int c = 0;
            char lc = '-';
            for (int j = 0; j < r.length(); j++) {
                if (lc == r.charAt(j)) {
                    c++;
                } else {
                    if (c != 0) {
                        s = s + c + lc;
                    }
                    lc = r.charAt(j);
                    c = 1;
                }
            }
            s =  s + c + lc;
            r = s;
            s = "";
        }
        System.out.println(r);
    }
}

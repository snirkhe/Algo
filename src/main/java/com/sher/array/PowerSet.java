package com.sher.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Find all the subsets of a given set.
 *
 * Input:
 * S = {a, b, c, d}
 * Output:
 * {}, {a} , {b}, {c}, {d}, {a,b}, {a,c},
 * {a,d}, {b,c}, {b,d}, {c,d}, {a,b,c},
 * {a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}
 *
 * https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 */
public class PowerSet {
    public static void main(String arg[]) {
        int s[] = {1, 2, 3, 4};
        int sdup[] = {1, 2, 2};
        powerSetDedup(sdup);
    }

    static void powerSetDedup(int s[]) {
        int n = 1 << s.length;
        String str = "";
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < s.length; j++) {
                if ((i & (1 << j)) > 0) {
                    temp += s[j] + ",";
                }
            }

            set.add(temp);
        }
        for (String ss:set) {
            System.out.println("{" + ss + "}");
        }
    }

    static void powerSet(int s[]) {
        int n = 1 << s.length;
        String str = "";

        for (int i = 0; i < n; i++) {
            System.out.print("\n{");
            for (int j = 0; j < s.length; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(s[j] + " ");
                }
            }
            System.out.print("}");
        }
    }
}

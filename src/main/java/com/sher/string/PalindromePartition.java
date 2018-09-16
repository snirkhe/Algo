package com.sher.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartition {
    public static void main(String arg[]) {
        Set<String> set = new HashSet<String>();
        call("nitin", set);
        System.out.println(set);
    }

    static void call(String s, Set set) {
        if (s == null || s.isEmpty()) return;
        //printIfPalinDrome(s, set);

        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            if (printIfPalinDrome(s1, set)) {
                String s2 = s.substring(i, s.length());
                call(s2, set);
            }

        }
        System.out.println("");
    }

    static boolean printIfPalinDrome(String s, Set set) {
        int i =0, j = s.length() -1;
//
//        if (s.length() == 1){
//            System.out.println(s);
//            return;
//        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        //set.add(s);
        System.out.print(s + " ");
        return true;

    }
}

package com.sher.string;


/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 */

/**
 * First do a char count in 256 array.
 * Then add char to string.
 * If string's last char is bigger than current char and last char has more than 1 count,
 * then throw away last char. We will handle it next time we encounter it.
 */
public class RemoveDuplicateLetters {
    public static void main (String arg[]) {
        remove("bcabc");
    }

    static void remove(String s) {
        char m[] = new char [256];
        boolean visited[] = new  boolean[256];
        String result = null;

        for (char  c:s.toCharArray()) m[c] ++;
        for (char c:s.toCharArray()) {
            m[c] --;
            if (visited[c]) continue;
            visited[c] = true;
            if (result == null) {
                result = "" + c;
            } else {
                char lastChar = result.charAt(result.length() - 1);
                while (c < lastChar && m[lastChar] > 0) {
                    result = result.substring(0, result.length() - 1);
                    visited[lastChar] = false;
                    if (result.length() == 0)
                        break;
                    lastChar = result.charAt(result.length() - 1);
                }

                result = result + c;

            }
        }
        System.out.println(result);
    }
}

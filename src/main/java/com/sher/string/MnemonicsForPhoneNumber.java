package com.sher.string;

public class MnemonicsForPhoneNumber {
    private String dict[] = {"ABC", "DEF", "GHI",
            "JKL", "MNO", "PQRS",
            "TUV", "XYZ"};

    void callRecurrsion(String prefix, String digits) {
        if (digits.length() == 0) {
            System.out.println(prefix);
            return;
        } else {
              char c = digits.charAt(0);
              digits = digits.substring(1);
                for (char k:dict[c-'2'].toCharArray()) {
                    callRecurrsion(prefix + k, digits);
                }
        }
    }


    void callNonRecurrsion(String prefix, String digits) {
        //TODO
    }

//    Input: nums = [1,2,3]
//    Output:
//            [
//            [3],
//            [1],
//            [2],
//            [1,2,3],
//            [1,3],
//            [2,3],
//            [1,2],
//            []
//            ]
    void subMain() {
        int nums1[] = {1,2,3};
        int nums2[] = {1,2,2};
        subset2("", nums2, 0);
    }

    void subset1(String s, int n[], int i) {
        if (i == n.length) {
            System.out.println("[" + s + "]");
            return;
        }
        int k = n[i];
        subset1(s, n, i + 1);
        subset1(s+k, n, i + 1);

    }

    void subset2(String s, int n[], int i) {
        if (i == n.length) {
            System.out.println("[" + s + "]");
            return;
        }
        int k = n[i];
        subset2(s, n, i + 1);

        if (s.length() == 0 ||  k != (s.charAt(s.length() -1) - '0'))
          subset2(s+k, n, i + 1);

    }

    int decodeWaysGFG(char []digits, int n) {
        if (n == 0 || n == 1) //An empty digit sequence is considered to have one decoding.
            return 1;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = decodeWays(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += decodeWays(digits, n - 2);

        return count;
    }


    int decodeWays(char []digits,  int  start) {
        int n = digits.length - start;
        if (n == 0 || n == 1) //An empty digit sequence is considered to have one decoding.
            return 1;

        // Initialize count
        int count = 0;

        for (int i = start; i < digits.length; i++) {
            if (isValid(digits, start, i))
              count += decodeWays(digits, i + 1);
        }
        return count;
    }

    boolean isValid(char digits[], int s, int e) {
        int n =  0;
        for (int i = s; i <= e; i++) {
            n = n * 10 + digits[i] - '0';
        }

        if (n > 0 && n <= 26)
            return true;

        return false;
    }




    public static void main(String arg[]) {
        MnemonicsForPhoneNumber n = new MnemonicsForPhoneNumber();
       // n.callRecurrsion("", "012", 0);
        //n.subMain();
        System.out.println(n.decodeWays("226".toCharArray(),  0));
    }
}

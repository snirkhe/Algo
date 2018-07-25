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

    public static void main(String arg[]) {
        MnemonicsForPhoneNumber n = new MnemonicsForPhoneNumber();
        n.callRecurrsion("", "234");
    }
}

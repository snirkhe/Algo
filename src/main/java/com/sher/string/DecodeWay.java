package com.sher.string;

//https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
public class DecodeWay {
    static int cc = 0;
    static int arr[] = new int [3];
    public static void main(String arg[]) {
        System.out.println(decode("1234".toCharArray(), 0));
        //System.out.println("=" + cc);

    }
    static int decode(char []str, int s) {
       int count  = 0;
       if (str.length == s || str.length - 1 == s) //if one char or empty string.
           return 1;
       for (int i = s ; i < str.length; i++) {
           if (isvalid(str, s, i)) {
               count  += decode(str, i+1);
           }

       }
        return count;
    }

    static boolean isvalid(char []str, int start, int end) { //inclusive
        if (end - start > 1) return false; //more than two char
        if (end < start || end >= str.length) return false;
        if (start != end) {//two char
            if (str[start] - '0' > 2) return false;
            if (str[start] -'0' == 2 && str[end] - '0' > 6) return false;
        }

        if (str[start] - '0' < 1) return false;

        return true;
    }

}

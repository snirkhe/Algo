package com.sher.string;

//https://buttercola.blogspot.com/search?q=Generalized+Abbreviation+

import java.util.LinkedList;

public class GeneralizedAbbreviation {
    public static void main(String arg[]) {
        //abbr("word", "", 0);
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    static void abbr(String word, String result, int s) {
        if (s == word.length()) {
            System.out.println(result);
            return;
        }

        for (int i= s; i < word.length(); i++) {
            String first = word.substring(s, i);
            if (i == s) {
                abbr(word.substring(i+1), result, s+1);
            } else {
                abbr(word.substring(i+1), result+i, s+1);
            }
        }
    }

    static boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] arr = preorder.split(",");

        for(int i=0; i<arr.length; i++){
            stack.add(arr[i]);

            while(stack.size()>=3
                    && stack.get(stack.size()-1).equals("#")
                    && stack.get(stack.size()-2).equals("#")
                    && !stack.get(stack.size()-3).equals("#")){

                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);

                stack.add("#");
            }
        }

        if(stack.size()==1 && stack.get(0).equals("#"))
            return true;
        else
            return false;
    }
}

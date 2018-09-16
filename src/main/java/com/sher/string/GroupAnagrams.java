package com.sher.string;

import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List list = new LinkedList();
        int arr[] = new int[strs.length];
        int i = 0;
        for (String s:strs) {
            for (int j=0;j < s.length(); j++) {
                arr[i] |= 1 << (s.charAt(j) - 'a');
            }
            i++;
        }

//        List l = new LinkedList<String>();
//        l.add(strs[0]);
//        list.add(l);
//        for (int i = 1; i < strs.length;i++) {
//            for (int j=0; j < list.size(); j++) {
//                if ()
//            }
//        }

        return null;
    }

    public static void main (String arg[]) {
        String [] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);
        System.out.println("Hello");
    }
}
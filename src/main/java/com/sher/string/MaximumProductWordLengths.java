package com.sher.string;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
public class MaximumProductWordLengths {

    public int maxProduct(String[] words) {
        if(words==null || words.length==0)
            return 0;

        int[] arr = new int[words.length];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                arr[i] |= (1<< (c-'a'));
            }
        }

        int result = 0;

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if((arr[i] & arr[j]) == 0){
                    result = Math.max(result, words[i].length()*words[j].length());
                }
            }
        }

        return result;
    }
}

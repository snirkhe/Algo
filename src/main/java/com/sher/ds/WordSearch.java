package com.sher.ds;
/**
 * http://www.programcreek.com/2014/06/leetcode-word-search-java/
 * @author snirkhe
 * 
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example, given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *
 */
public class WordSearch {
	
	public static void main(String arg[]) {
		String word = "SEE";
		char abc[] = {'A', 'B' , 'C', 'D', 'E'};
		int i = 0, j = abc.length - 1;
		while (i < j) {
			char t = abc[i];abc[i] = abc[j];abc[j] = t;
			i++; j--;
		}
		System.out.println(abc);
		int val = 0;
		System.out.println(1<<val);
		//char matrix[][] = { {'A', 'B' ,'C', 'E'}, {'S','F','C','S'},{'A','D','E','E'}};
		//System.out.println(find( word, matrix));
	}
	
	static boolean find(String word, char[][]matrix) {
		int k = 0;
		char c = word.charAt(0);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (c == matrix[i][j]) {
					if (match(i, j , matrix, word, 0) == true)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean match(int i, int j, char[][] matrix, String word,
			int k) {
		char t = matrix[i][j];
		matrix[i][j] = '#';
		//matrix[i][j] = '#';
		if (k >= word.length() - 1) {
		  return true;
		} else {
			k++;
		}
		boolean flag = false;
		char c = word.charAt(k);
		if (i > 0 && c == matrix[i -1][j]) {
			flag =  match(i -1 , j , matrix, word, k);
		} 
		
		if (flag == false && i + 1 < matrix.length  && c == matrix[i +1][j] ) {
			flag = match(i + 1 , j , matrix, word, k);
		}  
		
		if (flag == false && j > 0 && c == matrix[i][j -1]) {
			flag =  match(i , j -1 , matrix, word, k);
		}  
		
		if (flag == false && j < matrix.length && c == matrix[i][j +1] ) {
			flag = match(i , j + 1 , matrix, word, k);
		}
		matrix[i][j] = t;
		return flag;
	}
}

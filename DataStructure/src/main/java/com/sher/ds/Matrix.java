package com.sher.ds;

public class Matrix {
	
	public static void main(String arg[]) {
		int [][] matrix = { { 1, 2, 3 }, {4, 5, 6}, {7 ,8 , 9}};
		print(matrix);

		//rotateBy90(matrix);
	}

	static void print(int [][] matrix) {
		for (int k[]:matrix) {
			for (int j:k) {
				System.out.print(j + ",");
			}
			System.out.println("");
		}
		System.out.println("=============");
	}

	/**
	 * first row of source ------> last column of destination
	 * second row of source ------> last but-one column of destination
	 * so ... on
	 * last row of source ------> first column of destination
	 * 
	 * //matrixNew[c][m - 1 - r] = matrix[r][c];
	 * 
	 * Story : Pahale Chutiya phir Ram - Raone = Royal challenge {[c] [R-r-1] = [r][c]}
	 */
	static void rotateBy90(int [][] matrix ) {

		int R = matrix.length, C = matrix[0].length;
		int [][] matrixNew = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int j = R - 1 - r;

				matrixNew[c][R - 1 - r] = matrix[r][c];
				//System.out.println("R:" + r + ", j:" +j + " V:" + matrixNew[c][j]);
			}	
		}
		print(matrixNew);
	}

	/*
	// O(n^2) time and O(1) space algorithm ( without any workarounds and hanky-panky stuff! )

	Rotate by +90:
		Transpose
		Reverse each row

	Rotate by -90:
		Transpose
		Reverse each column

	Rotate by +180:
		Method 1: Rotate by +90 twice
		Method 2: Reverse each row and then reverse each column

	Rotate by -180:
		Method 1: Rotate by -90 twice
		Method 2: Reverse each column and then reverse each row
		Method 3: Reverse by +180 as they are same
	 */
	static void rotateBy90WithNoExtraSpace(int [][] matrix ) {
		transpose(matrix);
		reserverRows(matrix);
		print(matrix);
	}

	/* https://en.wikipedia.org/wiki/Transpose 
	 * Transpose Algo: 
	 *  for n = 0 to N - 2
    	for m = n + 1 to N - 1
        swap A(n,m) with A(m,n)
	 */

	static void transpose(int [][] matrix ) {
		final int R = matrix.length, C = matrix[0].length;
		int k = 1;
		for (int r = 0; r < R - 1  ; r++) { // -1 because of  L share (upside down) and elements at diagonal are unchanged
			for (int c = r + 1; c < R; c++) {
				//System.out.println("K=" + k++);
				int t = matrix[c][r];
				matrix[c][r] = matrix[r][c];
				matrix[r][c] = t;
			}
		}
		print(matrix);
	}
	static void reserverRows(int [][] matrix ) {
		final int R = matrix.length, C = matrix[0].length;
		for (int r = 0; r < R; r++) {
			int c= 0, e = C - 1;
			while (c < e) {
				int t = matrix[r][c];
				matrix[r][c] = matrix[r][e];
				matrix[r][e] = t;
				c ++; e--;
			}
		}
	}

	/**
	 * In given array find zero and replace the entire row and column with zeros 
	 * 
	 *    Input
	 *     1  2  3  4
	 *     5  6  7  8
	 *     9  10 0  11
	 *     12 13 14 14
	 *     
	 *     1  2  0  4
	 *     5  6  0  8
	 *     0  0  0  0
	 *     12 13 0  14
	 *     
	 */
	static void replace(int [][] matrix ) {
		int n = matrix.length;
		boolean[] row = new boolean[n];
		boolean[] column = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println("Matrix After Setting zero:-");
		print(matrix);
	}
}

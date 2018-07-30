package com.sher;

public class Matrix {
	
	public static void main(String arg[]) {
		int [][] matrix = { { 1, 2, 3, 4 }, {5, 6, 7, 8}, {9 , 10 , 11, 12}};
		print(matrix);

		spiral(matrix);
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
	
	// My own code
	static void rotateBy90_2(int [][] matrix ) {
		int [][]  m = matrix;
		int len = matrix.length - 1;
		for (int r = 0; r < matrix.length /2; r++) { // len/2 because second half will be modified automatically
			for (int c = r; c < matrix.length - 1 - r; c++) { //- 1 because last column is already modified, so no need.
				int t = m[r][c];
				m[r][c] = m[len - c ][r];
				m[len - c ][r] = m[len -r][len -c];
				m[len -r][len -c] = m [c] [len -r];
				m[c][len -r] = t;
			}
		}
		print(matrix);
		
	}
	/*
	 * SpaceO(1), time O(N^2)
	 */
	public static void rotateByNinetyToLeft(int[][] m) {

	    int e = m.length - 1;
	    int c = e / 2;
	    int b = e % 2;
	    for (int r = c; r >= 0; r--) {
	        for (int d = c - r; d < c + r + b; d++) {
	            int t   = m[c - r][d];
	            m[c - r][d] = m[d][e - c + r];
	            m[d][e - c + r] = m[e - c + r][e - d];
	            m[e - c + r][e - d] = m[e - d][c - r];
	            m[e - d][c - r] = t;
	        }
	    }
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

	static void spiral(int [][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int t = 0, b = n - 1, l = 0, r = m -1, i=0, j=0;
		while (l <= r && t <= b) {
			i = l;
			while (i <= r) {
				System.out.print(matrix[t][i]  + ",");
				i++;
			}
			t++;
			if (t > b) {
				return;
			}
			j = t;
			while (j <= b) {
				System.out.print(matrix[j][r] + ",");
				j++;
			}
			r--;

			if (l > r) return;
			i = r;
			while ( i >= 0) {
				System.out.print(matrix[b][i] + ",");
				i--;
			}
			b --;
			if (t > b) return;;
			j = b;
			while ( j >= t) {
				System.out.print(matrix[j][l] + ",");
				j--;
			}
			l++;
		}
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

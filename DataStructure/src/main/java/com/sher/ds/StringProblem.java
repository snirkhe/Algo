package com.sher.ds;

public class StringProblem {
	//Write All Permutations of a String
	int arg[] = { 1, 2, 3, 4};
	
	private static void allPermutations(int idx) {
		System.out.print(idx);
		for (int i = idx  -1; i >=0; i++) {
			allPermutations(i);
		}	
	}

	public static void main(String arg[]) {
		allPermutations(arg.length - 1);
	}
}

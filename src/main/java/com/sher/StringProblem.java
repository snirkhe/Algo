package com.sher;

public class StringProblem {
	//Write All Permutations of a String
	String text = "abcd";

	private static void allPermutations(String pre, String text) {
		//prepare prefix
		if (text.length() == 0) {
			System.out.println(pre);
			return;
		}
		for (int i =0; i < text.length(); i ++) {
			char c = text.charAt(i);
			allPermutations(pre + c, text.substring(0, i) + text.substring(i+ 1));
		}

	}

	public static void main(String arg[]) {
		//allPermutations("", "abcd");
		Abc123 a = new Abc123();
		a.print("", "123");
	}

	static class Abc123 {
		boolean isValid(int k) {
			if (k > 0 && k < 27) 
				return true;
			return false;
		}

		void print(String pre, String text) {
			StringBuilder bld = new StringBuilder(pre);
			for (int i =0; i< text.length(); i++) {
				String s = "" + text.charAt(i);
				if (isValid(Integer.parseInt(s))) {
					bld.append("-" + text.charAt(i));
				}
			}
			System.out.println(bld);
			bld = new StringBuilder(pre);
			for (int i = 0; i< text.length(); i = i + 2) {
				String s = "" + text.charAt(i) + text.charAt(i + i) ;
				if (isValid(Integer.parseInt(s))) {
					bld.append("-" + text.charAt(i));
				}
			}

		}
	}
}

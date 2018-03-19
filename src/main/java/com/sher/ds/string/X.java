package com.sher.ds.string;

public class X {
	public static void find(String soFar, String text) {
		//final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (text.length() ==  0) {
			System.out.println(soFar);
			return ;
		}
		String pre = "";
		while (text.length() > 0) {
			if (pre.length() >= 2) {
				break;
			}
				pre = pre + text.charAt(0);
				text = text.substring(1);
				find (soFar +"-" + pre, text);
			
		}
	}

	public static void main(String arg[]) {
		X.find("", "1234");
	}
}

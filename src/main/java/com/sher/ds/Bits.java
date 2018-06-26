package com.sher.ds;

public class Bits {
	public static void count(int n) {
		int c = 0 ;
		while (n !=0) {
		  n = (n & n -1);
		  c++;
		}
		System.out.println(c);
	}

	static int Add(int x, int y)
	{
		// Iterate till there is no carry
		while (y != 0)
		{
			// carry now contains common
			// set bits of x and y
			int carry = x & y;

			// Sum of bits of x and
			// y where at least one
			// of the bits is not set
			x = x ^ y;

			// Carry is shifted by
			// one so that adding it
			// to x gives the required sum
			y = carry << 1;
		}
		return x;
	}

	public static void main(String arg[]) {
		Bits.count(16);
	}
}

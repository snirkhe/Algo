package com.sher.bits;

public class Calculate {
	public static void count(int n) {
		int c = 0 ;
		while (n !=0) {
		  n = (n & n -1);
		  c++;
		}
		System.out.println(c);
	}

	static int add(int x, int y)
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

	static void multiply(int n,  int k) {
		int r = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				r = add(r , k);
			}
			n = n >>> 1;
			k = k << 1;
		}
		System.out.println(r);
	}

	//O(LogN)
	static void divide(int x, int y) {
		int r = 0;
		while (x >= y) { // x !=0 is also correct
			int s = 0;
			while (x >= (y << s)) { //multiply by 2.
				s ++;
			}
			s--;
			r = r + (1 << s);
			x = x - (y << s);
		}

		System.out.println("Q:" + r + ", R:" + x);
	}

	static long pow(int x, int y) {
		int count = 0;
		if (y == 0) return 1;
		long r = 1;

		while (y != 0) {
			if (y % 2 == 1) {
				r = r * x;
				y -- ;
			} else {
				x = x * x; // <<- Pay attention
				y = y /2;
			}
			//y = y >>> 1;
		}
		System.out.println("p:"  + r);
		return r;
	}
	public static void main(String arg[]) {
		Calculate.pow(2,4);
		//Calculate.divide(30, 5);
	}
}

package com.sher.ds;

/**
 * http://algorithms.tutorialhorizon.com/introduction-to-dynamic-programming-fibonacci-series/
 * Assuming 1,1,2,3,5
 *
 */
public class Fibonacci {

	/**
	 * The complexity of a naive recursive fibonacci is 2^n
	 */
	int fib(int n) {
		if (n < 2) {
			return 1;
		}
		else {
			int k = fib(n-2)+fib(n-1);
			return k;
		}
	}

	/**
	 * Dynamic programming Bottom Up approach
	 * Time complexity: O(n)
	 * Aux Space: O(n)
	 */
	int fibUsingBottomUp(int n) {
		int fib[] = new int[n+1];
		fib[0] = 1; fib[1] = 1;
		for (int i = 2; i <=n; i++) {
			fib[i] = fib[i-1] + fib[i -2];
		}
		return fib[n];
	}

	/**
	 * Dynamic programming Top down approach
	 * Time complexity: O(n)
	 * Aux Space: O(n)
	 */
	int fibUsingTopDown(int n) {
		int fib[] = new int[n+1];
		fib[0] = 1; fib[1] = 1;
		return fibUsingTopDown2(n, fib);
	}
	
	private int fibUsingTopDown2(int n, int fib[]) {
		if (n < 2) {
			return fib[n];
		}
		else {
			if (fib[n] > 0) return fib[n];
			fib[n] = fibUsingTopDown2(n - 1, fib) + fibUsingTopDown2(n -2, fib);
		}
		return fib [n];
	}
	
	public static int fib2(int n) {
		int p1 = 1, p2 = 0;
		System.out.println(0);
		System.out.println(1);
		for (int i = 2 ; i <= n; i++) {
			int t = p1 + p2;
			p2 = p1;
			p1 = t;
			System.out.println(t);
		}
		return p1;
	}

	public static int factorial(int n) {
		int p = 1;
		for (int i = 1 ; i <= n; i++) {
			p = i * p;
			//System.out.println(p);
		}
		return p;
	}

	public static void main(String s[]) {
		int n = 10;
		Fibonacci f =  new Fibonacci();
		System.out.println("Fib naive:" + f.fib(n));
		System.out.println("Fib BottomUp:" + f.fibUsingBottomUp(n));
		System.out.println("Fib TopDown:" + f.fibUsingTopDown(n));
	}
}


// Factorial
// Breadth first
// Depth first
// Find nth node
// Tree traverser
// Bubble sort
// O notation
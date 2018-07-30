package com.sher.array;

/**
 * Given an array of integers where each element represents the max number of 
 * steps that can be made forward from that element. Write a function to return the 
 * minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.
 * Example:
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 * @author snirkhe
 *
 */
public class MinimumNumberofJumps {

	public static void main(String arg[]) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 8, 9};
		System.out.println("\n Minimum number of jumps to reach end is 1:"+ minJumps(arr));
		System.out.println("\n Minimum number of jumps to reach end is 2:"+ minJumps2(arr));
	}

	private static int minJumps(int[] arr) {
		int jumps[] = new int[arr.length];
		int vals[] = new int[arr.length];
	
		for (int i= 0; i< arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
		}
		int k = 0;
		jumps[0] =0;
		for (int i= 1; i< arr.length; i++) {
			int j = 0;
			for ( j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
				jumps[i] = jumps[j] + 1;		 
	             break;
					//System.out.println(jumps[i]);
	                
				//	jumps[i] = Pow.min (jumps[i],  1 + jumps[j]);
				}
				
			}
			vals[i] = j;
		}

		int i = arr.length - 1;
		while (i > 0) {
			i = vals[i];
		//for (int i=0; i< ; i++) {
			System.out.print(arr[i] + ",");
		
		}
		return jumps[arr.length - 1];
	}

	private static int minJumps2(int[] a) {
		int maxReached  = 0;
		int dp[] = new int [a.length];
		dp[0] = 0;
		for (int i = 1; i < a.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i =0 ; i < a.length; i++) {
			maxReached = Math.max(maxReached, a[i] + i);
			if(dp[i] == Integer.MAX_VALUE && maxReached > i)
				dp[i] = 1;
			dp[a[i]] = Math.min(dp[a[i]], dp[i] + 1);
			if (maxReached >= a.length)
				return dp[a[i]];
		}

		return 0;
	}
}

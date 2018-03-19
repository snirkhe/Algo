package com.sher.ds.string;

/**
//Two elements whose sum is closest to zero
Question: An Array of integers is given, both +ve and -ve. 
You need to find the two elements such that their sum is closest to zero.
For the below array, program should print -80 and 85.

1,60,-10,70,-80,85


 */
public class TwoArrayWithSumCloseToZero {

	void twoArrayWithSumCloseToZero() {
		int a[] = {1,60,-10,70,-80,85};
		// Sort array
		quickSort(a, 0, (a.length - 1));  //It is random 
		//System.out.println(a);
		for (int aa =0; aa < a.length; aa++) {
			System.out.print(a[aa]+ ",");
		}
		//array sorted.
		int i = 0, j  =  a.length -1;
		int sum = a[i] + a[j]; 
		int minsum = 10000;
		
		while (i < j) {
			sum = a[i] + a[j]; 
		
			if (Math.abs(minsum) > Math.abs(sum)) {
				minsum = sum;
			}
			if (sum > 0) {
				j--;
			} else {
				i ++;
			}
		}
		System.out.println("M:" + minsum);
	}
	
	
	/**
	 * http://www.algolist.net/Algorithms/Sorting/Quicksort
	 * 
	 */
	void quickSort(int arr[], int start, int end) {
		//if ()
		//System.out.println("XX:" + start +"," + end);
		int mid = start +   (end - start) /2;
		int i = start;
		int j = end;
		int pivot = arr[mid];
		//System.out.println("Pivot is:" + pivot);
		//System.out.println("J is:" + j);
		// small before pivot, big after pivot
		while (i < j) {
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int t = arr[i]; arr[i] = arr[j]; arr[j] = t; // Swap;
			}
		}
	
		//System.out.println("M:" + mid + ",J=" +j);
		//At this point i == j, And pivot is on index j.
		if (start < j)
			quickSort(arr, start, j); //start is inclusive and j is exclusive
		if (j + 1 < end)
			quickSort(arr, j+1 , end); //j is inclusive and end is exclusive
	}
	
	public static void main(String arg[]) {
		new TwoArrayWithSumCloseToZero().twoArrayWithSumCloseToZero();
	}
}

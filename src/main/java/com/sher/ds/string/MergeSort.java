package com.sher.ds.string;

public class MergeSort {
	public static void main(String arg[]) {
		int a[] = {1,60,-10,70,-80,85,45,32};
		new MergeSort().mergeSort(a, 0, a.length - 1);
		for (int aa =0; aa < a.length; aa++) {
			System.out.print(a[aa] + " ,");
		}
		System.out.println("\b");
	}


	private void mergeSort(int a[], int start, int end) {
		int mid =  start +  (end - start) / 2;
		-
		if (end == start) { //just one element
			return;
		}
		else {//more than 1 element
			mergeSort(a, start, mid); 
			mergeSort(a,  mid + 1, end);
			merge(a, start, mid , end);
		}
	}

	private void merge(int[] a, int start, int mid, int end) {
		int b[] = new int [1+ mid - start];
		int c[] = new int [end - mid];
		
		 for (int i = 0; i < b.length; i ++) {
			 b[i] = a[start + i];
		 }
		 for (int i = 0; i < c.length; i ++) {
			 c[i] = a[mid + 1 + i];
		 }
		 int k = start;
		 int i=0,j =0;
		 for (; i < b.length && j < c.length; ) {
			 if (b[i] > c[j]) {
				 a[k++] = c[j++]; 
			 } else {
				 a[k++] = b[i++]; 
			 }
		 }
		 
		 while (i < b.length) {
			 a[k ++] = b[i++];
		 }
		 while (j < c.length) {
			 a[k ++] = c[j++];
		 }
	}
	
	
	

}

package com.sher.sort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String arg[]) {
        int arr[] =  {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int mid =  (left + right) / 2;
        int pivot = arr[mid];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        System.out.println("M:"+mid +",i:" + i);
        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);

    }

    static void quickSort(int arr[], int left, int right) {
        partition(arr, left, right);
    }


    static void quickSort(int arr[]) {
        int start = 0,end = arr.length -1;
        quickSort(arr, start, end);
    }

//    static void quickSort(int arr[], int start, int end) {
//        int pIndex = position(arr, start, end);
//
//    }
//
//    static int position(int arr[], int start, int end) {
//        if (start > end)
//            return -1;
//        int mid =  (start  + end )/ 2;
//        int p = arr[mid];
//        int i = start, j = end;
//        while (i <= j) {
//            while (arr[i] < p){
//                i++;
//            }
//
//            while (arr[j] > p){
//                j--;
//            }
//
//            if (i <= j) {
//                int t = arr[i];
//                arr[i] = arr[j];
//                arr[j] = t;
//                i++; j--;
//            }
//        }
//        if (start < mid)
//        quickSort(arr, start, mid - 1);
//        if (end > mid)
//        quickSort(arr, mid + 1, end);
//        return mid;
//    }

}

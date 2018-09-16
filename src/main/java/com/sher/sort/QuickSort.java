package com.sher.sort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String arg[]) {
        int arr[] =  {378, 478, 550, 103, 203, 631, 220, 234, 279, 368};



        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j]  = t;
    }

    static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int mid =  (left + right) / 2;
        int pivot = arr[mid];
        //swap(arr, right, pivot);

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        System.out.println("Pivot :" + pivot +", i:" + i);
        return i;
    }

    static int partition2(int arr[], int left, int right) {
        int i = left, j = right;
        //int mid =  (left + right) / 2;
        int pivot = arr[right];
        //swap(arr, right, pivot);
        //int i = left;
        for (j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }

//            if (i <= j) {
//                swap(arr, i, j);
//                i++;
//                j--;
//            }
        }
        //now j and pivot are same;
        swap(arr, i, j);
        System.out.println("Pivot :" + pivot +", i:" + (i ));
        return i;
    }



    static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int pivot = partition2(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot +1 , right);
        }
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

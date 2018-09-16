package com.sher.array;

public class SearchSmallest {

    public static int searchSmallest(int []arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { //A.get(mid)<A.get(right).
                // Minimum cannot be in A.subList(mid + 1, right + 1)
                // so it must be in // A.sublist(left, mid + 1).
                right = mid;
            }
            return left;
        }
        return -1;
    }

    public static void main(String arg[]) {
        //int arr[] =  {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
        int arr[] = { 10, 5, 2, 7, 1, 9 };
        int k = 15; // Ans is 4


    }


}

package com.sher.array;

/**
 * Write a program that takes an array denoting the daily stock price,
 * and returns the maximum profit that could be made by buying and then selling one share of that stock.
 * As an example, consider the following sequence of stock prices:
 * (310,315,275,295,260,270,290,230,255,250).
 * The maximum profit that can be made with one buy and one sell is 30—buy at 260 and sell at 290.
 */
public class BuyStock {

    public static void main(String args[]) {
        // Answer should be 30 for first and 55 for second
        int arr[] = {310,315,275,295,260,270,290,230,255,250};

        //int arr[] = {12,11,13,9,12,8,14,13,15};
        System.out.println("First: " + buySellOnce(arr));
        System.out.println("Second:" + buySellMultiple(arr));

    }

    private static int buySellOnce(int arr[]) {
        if (arr == null || arr.length < 2) return 0;
        int min = arr[0], profit = 0;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            profit = Math.max(profit, arr[i] - min);
        }
        return profit;
    }


    private static int buySellTwice(int arr[]) {
        if (arr == null || arr.length < 2) return 0;
        int min = arr[0], profit = 0;
        int profitFirst[] = new int[arr.length];
        profitFirst[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            profitFirst[i] = arr[i] - min;
        }
        int max = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            max = Math.max(arr[i], max);
            profit = Math.max(max - arr[i] + profitFirst[i -1], profit);
        }
        return profit;
    }

    //https://www.geeksforgeeks.org/stock-buy-sell/
    private static int buySellMultiple(int arr[]) {
        int min = arr[0], profit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != i + 1 && arr[i + 1] > arr[i]) {
                min = Math.min(arr[i], min);
            } else {
                profit += arr[i] - min;
                if (arr.length > i + 1)
                  min = arr[i + 1];
            }
        }
        return profit;
    }
}

package ArrayQuestions;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//        Example 1:
//
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//        Example 2:
//
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//2,1,4 --> 3
//[1,4,2] --> 3
// 2,4,1 --> 2

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import java.util.Arrays;

public class BestTimeToBuy {
    public static void main(String[] args) {
//        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        int[] prices = {10, 22, 5, 80};
//        int[] prices = {100, 180, 260, 310, 40, 535, 695};

//        System.out.println(maxProfitSingleTran(prices));
        System.out.println(maxProfitKTran(prices, 2));
    }

    public static int maxProfitMultipleTran(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int maxProfit = 0;
        boolean isBuy = true;

        for(int i = 1; i < prices.length; i++) {
            // keep checking if the prices are increasing that we are setting it to max variable
            if (prices[i] >= prices[i - 1]) {
                max = prices[i];
                isBuy = true;
                // keep checking if the prices are decreasing that we are setting it to min variable
            } else if (prices[i] <= prices[i - 1]) {
                // first we are getting the profit from previous transaction
                if (isBuy) {
                    maxProfit += max - min;
                }
                min = prices[i];
                isBuy = false;
            }

        }

        if (isBuy) {
            maxProfit += max - min;
        }
        return maxProfit;
    }

    private static int maxProfitSingleTran(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, (price - min));
        }
        return max;
    }

    private static int maxProfitKTran(int[] prices, int k) {

      // creating 3D array for memoization to store
        // the maximum profit achievable starting from day i, with k transactions remaining, and the current state (buy or sell)
        int[][][] memo = new int[prices.length][k + 1][2];
//
//        for (int[][] arr2D : memo) {
//            for (int[] arr1D : arr2D) {
//                Arrays.fill(arr1D, -1);
//            }
//        }
        return maxProfit(0, k, 1, prices, memo);
    }

    //recursion
    private static int maxProfit(int i, int k, int isBuy, int[] prices, int[][][] memo) {

        // base condition, check if
        // 1. number of transactions are over OR
        // 2. we reached at the end of proces array
        if (k <= 0 || i >= prices.length) {
            return 0;
        }

        int res = 0;
        int profit;

        // using memoization
//        if (memo[i][k][isBuy] != -1) {
//            return memo[i][k][isBuy];
//        }

        // check 3 conditions:
        // 1. if we buy at current price
        // 2. if we sell at current prices (makes one transaction)
        // 3. if we ignore the current price
        if (isBuy == 1) {
            profit = maxProfit((i + 1), k, 0, prices, memo) - prices[i];
            res = Math.max(profit ,res);
        } else {
            profit = prices[i] + maxProfit((i + 1), (k - 1), 1, prices, memo);
            res = Math.max(profit ,res);
        }

        profit = maxProfit((i + 1), k, isBuy, prices, memo);
        res  = Math.max(res, profit);

        // using memoization
//        memo[i][k][isBuy] = res;

        return res;
    }


}

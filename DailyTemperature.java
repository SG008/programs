//Given an array of integers temperatures represents the daily temperatures,
// return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
// If there is no future day for which this is possible, keep answer[i] == 0 instead.
//        Example 1:
//
//        Input: temperatures = [73,74,75,71,69,72,76,73]
//        Output: [1,1,4,2,1,1,0,0]
//        Example 2:
//
//        Input: temperatures = [30,40,50,60]
//        Output: [1,1,1,0]
//        Example 3:
//
//        Input: temperatures = [30,60,90]
//        Output: [1,1,0]
//{55, 38, 53, 81, 61, 93, 97, 32, 43, 78};  //[3,1,1,2,1,1,0,1,1,0]
//https://leetcode.com/problems/daily-temperatures/submissions/1384175288/

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> temps = new Stack<>();

        if (temperatures.length == 0) {
            return result;
        } else if (temperatures.length == 1) {
            result[0] = 0;
            return result;
        }

        temps.push(0);

        for (int i = 1; i < temperatures.length; i++) {

            while (!temps.isEmpty() && temperatures[temps.peek()] < temperatures[i]) {
                Integer index = temps.pop();
                result[index] = i - index;
            }
            temps.push(i);
        }

        return result;
    }

}

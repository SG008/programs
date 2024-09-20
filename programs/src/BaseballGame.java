//You are keeping the scores for a baseball game with strange rules.
//At the beginning of the game, you start with an empty record.
//You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record
// and is one of the following:
//
//        An integer x.
//        Record a new score of x.
//        '+'.
//        Record a new score that is the sum of the previous two scores.
//        'D'.
//        Record a new score that is the double of the previous score.
//        'C'.
//        Invalidate the previous score, removing it from the record.
//        Return the sum of all the scores on the record after applying all the operations.
//
//        The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer
//        and that all operations are valid.
//
//
//
//        Example 1:
//
//        Input: ops = ["5","2","C","D","+"]
//        Output: 30
//        Explanation:
//        "5" - Add 5 to the record, record is now [5].
//        "2" - Add 2 to the record, record is now [5, 2].
//        "C" - Invalidate and remove the previous score, record is now [5].
//        "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//        "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//        The total sum is 5 + 10 + 15 = 30.
//        Example 2:
//
//        Input: ops = ["5","-2","4","C","D","9","+","+"]
//        Output: 27
//        Explanation:
//        "5" - Add 5 to the record, record is now [5].
//        "-2" - Add -2 to the record, record is now [5, -2].
//        "4" - Add 4 to the record, record is now [5, -2, 4].
//        "C" - Invalidate and remove the previous score, record is now [5, -2].
//        "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//        "9" - Add 9 to the record, record is now [5, -2, -4, 9].
//        "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//        "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//        The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
//        Example 3:
//
//        Input: ops = ["1","C"]
//        Output: 0
//        Explanation:
//        "1" - Add 1 to the record, record is now [1].
//        "C" - Invalidate and remove the previous score, record is now [].
//        Since the record is empty, the total sum is 0.

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"1","C"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> records = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equalsIgnoreCase("+")) {
                Integer pop = records.pop();
                int i1 = records.peek() + pop;
                records.push(pop);
                records.push(i1);
            } else if(operations[i].equalsIgnoreCase("D")) {
                records.push(records.peek() * 2);
            } else if(operations[i].equalsIgnoreCase("C")) {
                records.pop();
            } else {
                records.push(Integer.valueOf(operations[i]));
            }
        }

        int result = 0;

        while(!records.isEmpty()) {
            result += records.pop();
        }

        return result;
    }
}

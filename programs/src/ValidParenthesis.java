//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//
//        Output: true
//
//        Example 2:
//
//        Input: s = "()[]{}"
//
//        Output: true
//
//        Example 3:
//
//        Input: s = "(]"
//
//        Output: false
//
//        Example 4:
//
//        Input: s = "([])"
//
//        Output: true

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s= "()[]{}";
        System.out.println(isValid(s));
    }
    
    public static boolean isValid(String s) {
        Stack<Character> p = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(' || t == '{' || t == '[') {
                p.push(t);
            } else {
                if(p.isEmpty()) {
                    return false;
                }
                char ch = p.pop();
                if((t == '}' && ch == '{') || (t == ')' && ch == '(') || (t == ']' && ch == '[')) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }

        return p.isEmpty();
    }
}

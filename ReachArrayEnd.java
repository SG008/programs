// write a program to check if we can reach at the end of an array
// given {3,2,1,0,4} --> first elements is 3 so jumps we can take is (3, 2, 1), element == maximum number of jumps we can take
// check we can reach at the end of an array

/* program explanation

Input: nums = [2,3,1,1,4]
We start at the second position from the last.

[2,3,1,1,4]
       i g

i = current position
g = goal
Let's use the formula above.

current position + maximum jump >= goal
= 3 + 1 >= 4
= true
We can reach the current goal(= index 4) from current position(= index 3), that means if we reach index 3, we are sure that we can definitely reach the goal(= the last index).

That's why we can move goal to index 3.

Next,

[2,3,1,1,4]
     i g
current position + maximum jump >= goal
= 2 + 1 >= 3
= true
If true, we are sure we can reach index 3 from index 2. We know that if we reach index 3, we can reach the last index, so update goal with index 2. In the next time, if we can reach index 2, that means we can reach the last index(= 4)

Next,

[2,3,1,1,4]
   i g
I'll speed up.

current position + maximum jump >= goal
= 1 + 3 >= 2
= true
[2,3,1,1,4]
 i g
current position + maximum jump >= goal
= 0 + 2 >= 1
= true
In the end,

[2,3,1,1,4]
 g
Now, goal is index 0. That means we can reach the goal because we start from index 0, so before we return true or false, we check this condition.

if goal == 0
In this case

return true
 */
public class ReachArrayEnd {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        int[] arr2 = {2,3,1,1,4};
        System.out.println(canJump(arr));
        System.out.println(canJump(arr2));
    }

    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}

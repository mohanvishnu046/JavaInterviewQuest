package stack_prob;

import java.util.Arrays;
import java.util.Stack;

public class StackNextGreater {
    /*find next greater number in an array */
    public static void main(String[] args) {
//        int[] array = {6,7,2,9,0,5,8,2};//[7, 9, 9, -1, 5, 8, -1, -1]
        int[] array = {6,8,0,1,9};//[8, 9, 1, 9, -1]

        System.out.println(Arrays.toString(findNextGreaterNo(array)));
    }

    private static int[] findNextGreaterNo(int[] array) {

        Stack<Integer> stack = new Stack<>();
        int len = array.length;

        int[] res = new int[len];
        for(int n = len-1; n >= 0; n--) {
            int num = array[n];
            while (!stack.empty() && stack.peek() <= num) {
                stack.pop();
            }
            if(stack.empty())
                res[n] = -1;
            else res[n] = stack.peek();

            stack.push(num);
        }

        return res;
     }
}

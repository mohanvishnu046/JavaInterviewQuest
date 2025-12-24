package main.java.dsa150q;

import java.util.Arrays;

public class FindMaxSumSubArray {
    public static void main(String[] args) {
        int[] array = {1,3,-12,8,5,4,9,-11,6};
        System.out.println(Arrays.toString(findMaxSubArray(array)));
    }
    private static int[] findMaxSubArray(int[] array) {
        int maxSum=array[0], currentSum=array[0];
        int tempStart=0, maxSumStarts=0, maxSumEnds=0;
        for(int e =1 ;e<array.length;e++) {
                if(array[e]>currentSum+array[e]){
                currentSum=array[e];
                tempStart = e;
            }else currentSum+=array[e];

            if (currentSum > maxSum){
                maxSum = currentSum;
                maxSumStarts = tempStart;
                maxSumEnds = e;
            }
        }
        return Arrays.copyOfRange(array,maxSumStarts,maxSumEnds+1);
    }
}

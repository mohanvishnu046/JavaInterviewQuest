package main.java.dsa150q;

import java.util.Arrays;

public class FindMaxSumSubArray {
    public static void main(String[] args) {
        int[] array = {1,3,-12,8,5,4,9,-11,6};
        System.out.println(Arrays.toString(findMaxSubArray(array)));
        practices(new int[]{1, -2, 4, 3, 7, 1});
        practices(array);
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
    private static void practices(int[] array){
        int maxSum=array[0],currSum=array[0];
        int maxStart=0,maxEnd=0,tempStart=0;
        for(int i=1;i<array.length;i++){
            if(array[i]>currSum+array[i]){
                currSum = array[i];
                tempStart=i;
            }else currSum+=array[i];

            if(currSum>maxSum){
                maxSum = currSum;
                maxStart = tempStart;
                maxEnd = i;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,maxStart,maxEnd+1)));
    }
}

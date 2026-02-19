package main.java.arrays_Q;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Two_Sum_DSA {
    ///find sum of 2 num subSequent sum equals to target
    public static void main(String[] args) {
        int[] array = {1,2,4,1,3,5,1,6,7};
        int target = 9;
        getsubSequentElementsSum(array, target);
        getAny2ElementsSum(array,target);
    }

    private static void getAny2ElementsSum(int[] array, int target) {
        Set<Integer> presence = new HashSet<>();

        for(int n :array){
            int sub = target - n;
            if(presence.contains(sub)) {
                System.out.println("[" + sub + " " + n + "]");
                break;
            }else presence.add(n);
        }
    }

    public static void getsubSequentElementsSum(int[] array, int target){
        for(int i=0,j=1;j< array.length;i++,j++){
            if(array[i]+array[j]==target) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(array, i, j + 1)));
                break;
            }
        }
    }
}

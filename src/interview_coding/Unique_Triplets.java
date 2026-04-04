package interview_coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unique_Triplets {
    //find all unique triplets sum is 0 in an array.
    public static void main(String[] args) {
        int[] array = {1,-2,2,-1,3,0};
        System.out.println("triplets list : "+getTriplets(array));
    }

    private static List<List<Integer>> getTriplets(int[] array) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(array);

        for(int i=0; i<array.length;i++){
            if(i>0 && array[i]==array[i-1])
                continue;
            int left = i+1;
            int right = array.length-1;
            while(left<right){
                int total = array[i]+array[left]+array[right];

                if(total == 0){
                    result.add(Arrays.asList(array[i],array[left],array[right]));
                    while(left<right && array[left]==array[left+1])
                        left++;
                    while(left<right && array[right]==array[right-1])
                        right--;
                    left++;
                    right--;
                }else if(total < 0){
                    left++;
                }else right--;
            }
        }
        return result;
    }
}

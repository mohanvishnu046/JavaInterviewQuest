package main.java.arrays_Q;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] array = {1,3,4,6,5,61,7,9,31,11};
        System.out.println(anyMatch(array));
        System.out.println(anyMatchUsingSet(array));
    }
    private static boolean anyMatch(int[] array) {
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]==array[j])
                    return true;
            }
        }
        return false;
    }

    private static boolean anyMatchUsingSet(int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(int i:array){
            if(!set.add(i))
                return true;
        }
        return false;
    }
}

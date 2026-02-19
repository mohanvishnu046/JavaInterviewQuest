package main.java.arrays_Q;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,4,5,1,6,7};

        Set<Integer> uniqueSet = new HashSet<>();
        for(int i=0;i< array.length;i++){
            if(!uniqueSet.add(array[i]))
                System.out.print(array[i]+" ");
        }
    }
}

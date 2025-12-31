package main.java.arrays_Q;

import java.util.Arrays;

public class MoveOnesToRight {
    private static int reverse(int n){
        if(n==0) return 0;
        System.out.print(n%10);
        return reverse(n/10);
    }
    public static void main(String[] args) {
        int[] array = {3,1,5,1,0,8,1,6,1,7,8};
//        reverse(45678);
        System.out.println(Arrays.toString(array));
        int index =0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=1)
                array[index++]=array[i];
        }
        while(index < array.length) {
            array[index++]=1;
        }
        System.out.println(Arrays.toString(array));
    }
}
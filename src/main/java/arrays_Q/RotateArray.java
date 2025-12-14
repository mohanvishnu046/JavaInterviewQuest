package main.java.arrays_Q;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int moveLeft = 2;
        rotate(array,moveLeft,false);// right shift
//        rotate(array,moveLeft,true);// left shift
        System.out.println(Arrays.toString(array));
    }
    private static void rotate(int[] array,int skip,boolean leftShift){
        int len = array.length;
        skip = skip%len;

        if(leftShift) {
            swap(array, 0,skip-1);
            swap(array,skip,len-1);
            swap(array,0,len-1);
        }else{
            swap(array, len-skip,len-1);
            swap(array,0,len-skip-1);
            swap(array,0,len-1);
        }
    }
    private static void swap(int[] array,int s, int e){
        while(s<e){
            int temp = array[s];
            array[s]=array[e];
            array[e] = temp;
            s++;
            e--;
        }
    }
}

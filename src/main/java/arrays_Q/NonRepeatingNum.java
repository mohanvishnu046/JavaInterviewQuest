package main.java.arrays_Q;

public class NonRepeatingNum {
    public static void main(String[] args) {
        int[] array ={2,3,4,3,2,1,9,4,1};// Contains exactly one non-repeating num
        findNonRepeatingNum(array);
    }
    private static void findNonRepeatingNum(int[] array) {
        int nonRepeat = 0;
        for(int n:array){
            nonRepeat^=n;
            nonRepeat^=0;
        }
        System.out.println(nonRepeat);
    }
}

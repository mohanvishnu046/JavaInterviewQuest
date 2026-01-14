package main.java.arrays_Q;

public class FindUniqueNum {
    public static void main(String[] args) {
        findUniqueNum();
    }
/*
* Here an array has ele twice and it contain only one unique.
* */
    private static void findUniqueNum() {
        int[] array = {2,4,2,6,4,1,1};
        int xor = 0;
        for(int i=0;i<array.length;i++)
            xor^=array[i];
        System.out.println(xor);
    }
}

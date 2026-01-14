package main.java.arrays_Q;

public class FindMissingNumInArray {
    /*
    * Find missing num in an array of whole number of size n */
    public static void main(String[] args) {
        missingNumInArray();
    }

    private static void missingNumInArray(){
        int[] array = {4,3,0,2};
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum^=i;
            System.out.print(sum+" :: ");
            sum^=array[i];
            System.out.println(sum);
        }
        sum^=array.length;
        System.out.println(sum);
    }
}

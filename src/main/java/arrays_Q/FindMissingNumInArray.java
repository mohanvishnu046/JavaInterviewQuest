package main.java.arrays_Q;

public class FindMissingNumInArray {
    /*
    * Find missing num in an array of whole number of size n */
    public static void main(String[] args) {
        int[] array = {4,1,0,2};
        missingNumInArray(array);
        prac(array);
    }

    private static void missingNumInArray(int[] array){//other solution sum natural number - sum of array;
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum^=i;//^ bitwise operator works at bits level means same bits 0 diff 1;
//            System.out.print(sum+" :: ");
            sum^=array[i];
//            System.out.println(sum);
        }
        sum^=array.length;
        System.out.println(sum);
    }

    private static void prac(int[] array){
        int sum=0;
        for(int i = 0;i < array.length ; i++){
            sum^=i;
            sum^=array[i];
        }
        sum^=array.length;
        System.out.println(sum);

    }
}

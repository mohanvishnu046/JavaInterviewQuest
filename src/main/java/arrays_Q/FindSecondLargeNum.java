package main.java.arrays_Q;

public class FindSecondLargeNum {
    public static void main(String[] args) {
        int[] array = {-2,4,9,1,5,34,7,34};
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for(int num: array){
            if(num>firstMax){
                secondMax = firstMax;
                firstMax = num;
            }else if(num>secondMax && num != firstMax)
                secondMax = num;
        }
        System.out.println(secondMax);
    }
}

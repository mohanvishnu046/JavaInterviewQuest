package main.java.dsa_prod;

public class BinarySearch_DSA_01 {
    //Binary Search is O(logn) which optimized  searching a target value in sorting array.
    public static void main(String[] args) {
        int[] array = {2,5,7,9,10,11,16,19,26,57,89};
        int target = 89;
        System.out.println("index: "+searchTarget(array,target,0, array.length-1));
    }

    private static int searchTarget(int[] array, int target, int left,int right) {
        if(left>right)
            return -1;

        int mid = left +(right-left)/2;

        if(array[mid]==target)
            return mid;
        if(array[mid]<target)
            return searchTarget(array,target,mid+1, right);

        return searchTarget(array,target,left, mid-1);
    }
}

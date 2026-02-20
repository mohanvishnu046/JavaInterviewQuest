package main.java.dsa_prod;

import java.util.Arrays;

public class MergeSorting_DSA_2 {
    public static void main(String[] args) {
        int[] array = {20,5,71,89,10,1,16,90,26,7,9};
        System.out.println(Arrays.toString(array));

        mergeSorting(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    private static void mergeSorting(int[] array, int left, int right) {

        if(left<right){
            int mid =left+(right-left)/2;

            mergeSorting(array,left,mid);
            mergeSorting(array,mid+1,right);
            mergeSorted(array,left,mid,right);

        }

    }

    private static void mergeSorted(int[] array, int left, int mid, int right) {

        int n1 = mid-left+1;
        int n2= right-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i]=array[left+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=array[mid+1+i];
        }

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                array[k] =L[i];
                i++;
            }else {
                array[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            array[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            array[k]=R[j];
            j++;
            k++;
        }
    }
}

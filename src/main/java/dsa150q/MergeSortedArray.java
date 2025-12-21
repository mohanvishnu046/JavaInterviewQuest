package main.java.dsa150q;

import java.util.Arrays;

public class MergeSortedArray {

    // merge two sorted arrays into single sorted array.
    public static void main(String[] args) {
        int[] a1= {3,9,27,42,90,135,146,789,908};
        int[] a2= {19,23,39,56,68};
        int l1=a1.length, l2=a2.length;
        int[] a3 = new int[l1+l2];
        int n=0,f1=0,f2=0;
        while(f1<l1 && f2<l2){
            if(a1[f1]<a2[f2])
                a3[n++]=a1[f1++];
            else a3[n++] = a2[f2++];
        }
        while(f1<l1)
            a3[n++]=a1[f1++];
        while(f2<l2)
            a3[n++]=a2[f2++];

        System.out.println(Arrays.toString(a3));
    }
}

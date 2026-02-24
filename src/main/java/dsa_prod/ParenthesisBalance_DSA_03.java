package main.java.dsa_prod;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class ParenthesisBalance_DSA_03 {
    public static void main(String[] args) {
        int[] array = {2,5,7,9,10,11,16,19,26,57,89};
        int target = 7;
//        binarySearchPrac(array,target);
        int[] unsortedArray = {20,5,71,89,10,1,16,90,26,7,9};
//        mergeSortArray(unsortedArray);

        System.out.println(checkParenthesisBalance("{{([()])}}"));//true
        System.out.println(checkParenthesisBalance("{{}(([()])}}"));//false
        System.out.println(checkParenthesisBalance("((("));//false
        fibonacciSeries(10);
    }

    private static boolean checkParenthesisBalance(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else if(c==')'||c=='}'||c==']') {
                if(stack.isEmpty())
                    return false;
                char e = stack.pop();
                if(c==')'&& e=='(' ||c=='}'&& e=='{' ||c==']'&& e=='['){
                //do nothing...
                } else return false;
            }
        }
        return stack.isEmpty();
    }


    //    practice
    static void binarySearchPrac(int[] array, int target) {
        System.out.println("found at index: "+getTargetIndex(array,target,0,array.length));
    }
    static int getTargetIndex(int[] array, int target, int left, int right){
        if(left>right)
            return -1;
        int mid = left+(right-left)/2;

        if(array[mid]==target)
            return mid;
        if(array[mid]>target)
            return getTargetIndex(array,target,left,mid);
        else return getTargetIndex(array,target,mid+1,right);
    }

    static void mergeSortArray(int[] array){
        System.out.println(Arrays.toString(array));
        mergeSorting(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSorting(int[] array, int left, int right) {
        if(left<right){
            int mid = left+(right-left)/2;
            mergeSorting(array,left,mid);
            mergeSorting(array,mid+1,right);
            mergeSort(array,left,mid,right);
        }
    }

    private static void mergeSort(int[] array, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2= right-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=array[left+i];

        for(int i=0;i<n2;i++)
            R[i]=array[mid+1+i];

        int i=0,j=0,k=left;
        while(i < n1 && j < n2){
            if(L[i]<=R[j]) {
                array[k] = L[i];
                i++;
            }else{
                array[k] = R[j];
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

    private static void fibonacciSeries(int n){
        Stream.iterate(new long[] {0,1}, pair -> new long[] {pair[1],pair[0]+pair[1]})
                .limit(n)
                .map(pair->pair[0])
                .forEach(x-> System.out.print(x+" "));
    }

}

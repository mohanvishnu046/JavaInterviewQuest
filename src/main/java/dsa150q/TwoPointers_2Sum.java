package main.java.dsa150q;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPointers_2Sum {
    public static void main(String[] args) {
//        int[] array = {2,7,11,15};
        int[] array = {12,7,15,3,1,9};
        int target = 10;

//        twoSum(array,target);
        twoSumIndexes(array, target);
//        twoSumSorted(array, target);
    }

    private static void twoSumSorted(int[] array, int target) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int f=0,sum=0;
        int l=array.length-1;
        boolean flag=false;
        while(f<l){
            sum=array[f]+array[l];
            if(sum > target)
                l--;
            else if(sum < target) f++;
            else{
                flag=true;
                break;
            }
        }
        if(flag)
            System.out.println(f+" : "+array[f]+" :: "+l+" : "+array[l]);
        else System.out.println("Not exist");
    }

    public static void twoSumIndexes(int[] array,int target) {
        //If array is unsorted and has -nev values
        System.out.println(Arrays.toString(array)+" :: "+target);
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean found = false;
        for(int f=0;f<array.length;f++){
            int s = target - array[f];
            if (map.containsKey(s)){
                System.out.println(f+" : "+array[f]+" :: "+map.get(s)+" : "+s);
                return;
            }
            map.put(array[f],f);
        }
        System.out.println("not exist");

    }
    public static void twoSum(int[] array,int target) {// use full if number as output not their indexes.
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int s=0,e= array.length-1;
        boolean found=false;
        while(s<e){
            int sum = array[s]+array[e];
            if(sum>target)
                e--;
            else if(sum<target)
                s++;
            else {
                found=true;
                break;
            }
        }
        if(found)
            System.out.println(s+" : "+e+" :: "+array[s]+" : "+array[e]);
        else System.out.println("Not exist");

    }
}

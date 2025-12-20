package main.java.dsa150q;

import java.util.Arrays;

public class TwoPointers_2Sum {
    public static void main(String[] args) {
        int[] array = {4,7,5,11,3,2,8,9,1,12};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int s=0,e= array.length-1;
        int target =39;
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

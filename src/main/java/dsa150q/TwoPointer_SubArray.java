package main.java.dsa150q;

import java.util.Arrays;

//two-pointer / sliding-window
public class TwoPointer_SubArray {
    public static void main(String[] args) {
        int[] array = {4,7,5,11,3,2,8,9,1,12};
        int target = 22;
        brutForce(array,target);
        optimize(array,target);
    }

    // recalculation of sum is eliminated, index exclusive and inclusive confusion is not present.
    public static void optimize(int[] array, int target) {
        System.out.println(Arrays.toString(array)+" : "+target);

        boolean found = false;
        int s=0;
        int sum=0;
        int end=0;
        for(int e=0;e<array.length;e++){
            sum+=array[e];
            while(sum>target){
                sum-=array[s];
                s++;
            }
            if(sum==target){
                end =e;
                found = true;
                break;
            }
        }

        if(found){
            int[] subArray = Arrays.copyOfRange(array,s,end+1);
            System.out.println(Arrays.toString(subArray));
        }else System.out.println("Not exist");
    }

    public static void brutForce(int[] array, int target) {
        System.out.println(Arrays.toString(array)+" : "+target);
        int s=0,e=1;
        while(e<array.length){// In this approach we recalculating sum using while out and for inner is not good to use
            int sum=0;
            for(int i=s;i<e;i++){// here s is inclusive and e is exclusive which makes the output bit confuse.
                sum+=array[i];
                if(sum>target)
                    break;
                if(sum==target)
                    break;
            }
            if(sum==target)
                break;
            else if(sum<target)
                e++;
            else s++;
        }
        System.out.println(s+" :: "+e);
        int[] subArray = Arrays.copyOfRange(array,s,e);
        System.out.println(Arrays.toString(subArray));

        /*output here
        * [4, 7, 5, 11, 3, 2, 8, 9, 1, 12] : 22
        * index 4 (inner) :: 8 (outer/exclusive)*/
    }
}

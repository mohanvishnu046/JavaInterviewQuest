package main.java.Lists_Q;

import java.util.*;

public class FindMissingNum {
    /*
    * Find missing num from a list of natural numbers
    * */
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,3,5,2);
        int size = ls.size()+1;
        int expectedSum = size*(size+1)/2;
        int actualSum = ls.stream().mapToInt(Integer::intValue).sum();
        System.out.println("missing num is "+(expectedSum-actualSum));


        /*
        * If list is un-order and  contains negative numbers*/
        List<Integer> nev = Arrays.asList(-1,3,5,2,0);

        int min = Collections.min(nev);
        int max = Collections.max(nev);

        Set<Integer> set = new HashSet<>(nev);
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                System.out.println("missing num : "+i);
                break;
            }
        }

    }
}

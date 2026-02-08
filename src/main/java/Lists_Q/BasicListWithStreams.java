package main.java.Lists_Q;

import java.util.Collections;
import java.util.List;

public class BasicListWithStreams {
    public static void main(String[] args) {
        List<Integer> ls = List.of(1,2,4,7,1,4,6,2,1,6,1);
        getOnlyDuplicates(ls);
        getDistinct(ls);
        getNoRepeatingInts(ls);

    }

    private static void getOnlyDuplicates(List<Integer> ls) {
        List<Integer> integerList = ls.stream()
                .filter(o -> Collections.frequency(ls, o) > 1)//here frequency gives count of o in ls everytime > 1, so gives all ele with count >1,
                .distinct()//that the reason to remove duplicates use distinct.
                .toList();
        System.out.println("getOnlyDuplicates: "+integerList);
    }
    private static void getDistinct(List<Integer> ls) {
        List<Integer> integerList = ls.stream()
                .distinct()
                .toList();
        System.out.println("getDistinct: "+integerList);
    }
    private static void getNoRepeatingInts(List<Integer> ls) {
        List<Integer> integerList = ls.stream()
                .filter(n->Collections.frequency(ls,n)==1)
                .toList();
        System.out.println("getNoRepeatingInts: "+integerList);
    }
}

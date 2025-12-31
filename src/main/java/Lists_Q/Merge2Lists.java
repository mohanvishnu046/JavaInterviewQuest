package main.java.Lists_Q;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Merge2Lists {
    public static void main(String[] args) {
        List<Integer> l1=List.of(2,4,6,8,9,1,4,2);
        List<Integer> l2=List.of(91,4,5,82,9,11,43,2);

        List<Integer> merge = Stream.concat(l1.stream(), l2.stream())
                .distinct()
                .sorted(Comparator.reverseOrder())//  sorted and reverse in desc.
                .collect(Collectors.toList());
        System.out.println(merge);
    }
}

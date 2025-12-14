package main.java.arrays_Q;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivideOddEven {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Map<String, List<Integer>> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(n -> n % 2 == 0?"Even":"Odd"));
        System.out.println(collect);
        List<Integer> Odd = collect.get("Odd");
        System.out.println(Odd);
        List<Integer> even = collect.get("Even");
        System.out.println(even);
     }
}

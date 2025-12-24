package main.java.streams_Q;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStreams {
    public static void main(String[] args) {
        int[] array = {4,2,6,8,9,1,5,7,3};
        usingStreams(array);
        Map<String, Integer> map = new HashMap<>(Map.of("apple", 2,"banana", 7,"orange",5,"kiwi",1,"papaya",9,"melon",3));

    }

    private static void usingStreams(int[] array) {
//        int max = Arrays.stream(array).max().orElse(-1);
//        int max = Arrays.stream(array).max().getAsInt();
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int max = list.stream()
                        .max(Comparator.comparing(Integer::intValue))
                                .get();
        long count = list.stream().filter(x->x%2!=0).count();
        System.out.println(max);
        System.out.println(count);

    }
}

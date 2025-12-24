package main.java.streams_Q;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.stream.Collectors;

public class SortWithStreams {
    public static void main(String[] args) {
        int[] array = {4,2,6,8,9,1,5,7,3};
        System.out.println(Arrays.toString(justSort(array)));
        System.out.println(Arrays.toString(justSortdsce(array)));

        Map<String, Integer> map = new HashMap<>(Map.of("apple", 2,"banana", 7,"orange",5,"kiwi",1,"papaya",9,"melon",3));
        System.out.println(justMapSort(map));

    }

    private static Map<String,Integer> justMapSort(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
//                .sorted(Comparator.comparingInt(Map.Entry::getValue))//asc
                .sorted(Comparator.comparingInt(Map.Entry<String,Integer>::getValue).reversed())//desc
                .collect(Collectors.toMap(Map.Entry::getKey
                , Map.Entry::getValue
                                ,(o,n)->o
                ,LinkedHashMap::new));
    }

    private static int[] justSort(int[] array){
        return Arrays.stream(array).sorted().toArray();
    }
    private static int[] justSortdsce(int[] array){
        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

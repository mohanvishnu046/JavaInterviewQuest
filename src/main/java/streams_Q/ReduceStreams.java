package main.java.streams_Q;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReduceStreams {
    public static void main(String[] args) {
        int[] array = {4,2,6,8,9,1,5,7,3};
        System.out.println(usingReduce(array));

        Map<String, Integer> map = new HashMap<>(Map.of("apple", 2,"banana", 7,"orange",5,"kiwi",1,"papaya",9,"melon",3));
//        System.out.println(justMapSort(map));
    }

    private static int usingReduce(int[] array) {
        int result;
        result = Arrays.stream(array)//get sum
//                .reduce(0,Integer::sum);
//                .reduce(Integer.MIN_VALUE, Integer::max);//getmax
                .reduce(Integer.MAX_VALUE, Integer::min);//getmin
        return result;
    }
}

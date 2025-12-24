package main.java.streams_Q;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapInStreams {
    public static void main(String[] args) {
        int[] array = {4,2,6,8,9,1,5,7,3};
        System.out.println(Arrays.toString(usingMap(array)));

        Map<String, Integer> map = new HashMap<>(Map.of("apple", 2,"banana", 7,"orange",5,"kiwi",1,"papaya",9,"melon",3));
//        System.out.println(justMapSort(map));

    }

    private static int[] usingMap(int[] array) {
        int[] res = Arrays.stream(array).filter(n->n%2==0).map(n->n*n).sorted().toArray();
        return res;
    }
}

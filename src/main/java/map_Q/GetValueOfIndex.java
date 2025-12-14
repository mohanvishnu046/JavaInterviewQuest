package main.java.map_Q;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetValueOfIndex {
    public static void main(String[] args) {
        Map<Character,Integer> map = new LinkedHashMap<>(Map.of('A', 1));
        map.put('V', 2);
        map.put('N', 3);
        map.put('P', 4);
        map.put('O', 5);
        System.out.println(map);
        int index =3;

        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        int i=0;
        while(it.hasNext()){
            Map.Entry<Character, Integer> next = it.next();
            if(i==index){
                System.out.println("value by iterator :: "+next.getValue());
                break;
            }
            i++;
        }
        map.entrySet().stream()
                .skip(index)
                .findFirst()
                .ifPresentOrElse(x-> System.out.println("value by streams : "+x.getValue()), () -> System.out.println("index out of bound streams"));

    }
}

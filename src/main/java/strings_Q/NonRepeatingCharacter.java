package main.java.strings_Q;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {

    /*first non repeating character*/
    public static void main(String[] args) {
        String str = "swiss";

        str.chars().mapToObj(a->(char)a)
                .collect(Collectors.groupingBy(Function.identity()
                        , LinkedHashMap::new
                        , Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresentOrElse(System.out::println,()-> System.out.println("No unique char"));

    }
}

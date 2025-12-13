package main.java.strings_Q;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountChars {
    public static void main(String[] args) {
        String str = "hello world is first program for coders";

        Map<Character,Long> charFreq = str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("charFreq : "+charFreq);

        Map<Character,Long> duplicateChars = charFreq.entrySet().stream()
                .filter(e->e.getValue()>1 && !e.getKey().equals(' '))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,HashMap::new));
        System.out.println("duplicate Chars : "+duplicateChars);

        Map<Character,Long> uniqueChars = charFreq.entrySet().stream()
                .filter(e->e.getValue()==1)
                .collect(Collectors.toMap(Map.Entry::getKey
                        , Map.Entry::getValue
                        ,(n1,n2)->n1//Merge function to eliminate duplicates
                        , LinkedHashMap::new));
        System.out.println("Unique chars : "+uniqueChars);

        String uniString = charFreq.entrySet().stream()
                        .filter(e->e.getValue()==1)
                        .map(Map.Entry::getKey)
                        .map(String::valueOf)
                        .collect(Collectors.joining(""));
        System.out.println("get chars of unique : "+uniString);

        String duplicates = charFreq.entrySet()
                        .stream()
                .filter(e->e.getValue()>1 && e.getKey()!=' ')
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("get chars of duplicates : "+duplicates);
    }
}

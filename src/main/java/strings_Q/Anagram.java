package main.java.strings_Q;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {//give args as listen silent
        System.out.println(Arrays.toString(args));
        if(args.length==2) {
            String s1 = args[0];
            String s2 = args[1];
            System.out.println(s1 + " :: " + s2);
            s1 = s1.replaceAll("\\s", "");
            s2 = s2.replaceAll("\\s", "");

            Map<Character, Long> s1Chars = s1.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Character, Long> s2Chars = s2.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            if (s1Chars.equals(s2Chars))
                System.out.println("Its an Anagram");
            else System.out.println("Its not an Anagram");
        }else System.out.println("give valid args with separated by space ");

    }
}

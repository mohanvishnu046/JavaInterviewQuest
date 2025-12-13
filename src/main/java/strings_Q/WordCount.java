package main.java.strings_Q;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String str = "hello world is first program for coders";

        long len = Arrays.stream(str.split("")).filter(w->!w.isBlank())
                .count();
        System.out.println("len :: "+len);

        String noSpace = Arrays.stream(str.split(" ")).collect(Collectors.joining());
        System.out.println(noSpace);

        String word = "program";
        int target = 3;
        char targetChar = 'g';
        char found = word.chars()
                .mapToObj(c->(char)c)
                .skip(target)
                .findFirst().get();

        boolean match = word.chars()
                        .skip(target)
                        .limit(1)
                        .anyMatch(c->c==targetChar);

        System.out.println("character :: "+found);
        System.out.println("character match :: "+match);
    }
}

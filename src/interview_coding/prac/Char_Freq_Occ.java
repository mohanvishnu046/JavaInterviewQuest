package interview_coding.prac;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Char_Freq_Occ {
    public static void main(String[] args) {
        String str = "hello world test";
        List<Character> chars = str.chars().mapToObj(c->(char)c)
                .toList();

        String strChars = chars.stream()
                .filter(c -> Collections.frequency(chars, c) == 1 && c != ' ')
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(strChars);

//        fibonacci series using streams;
        Stream.iterate(new long[] {0,1}, pair-> new long[] {pair[1],pair[0]+pair[1]})
                .limit(10)
                .map(x->x[0])
                .forEach(x-> System.out.print(x+" "));
    }
}

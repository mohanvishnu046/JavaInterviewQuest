package main.java.streams_Q;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitiateStreams {
    public static void main(String[] args) {
        int[] array = {3,9,7,8,1,6,2,5,1};
        String[] strArray ={"apple","banana","kiwi","orange"};

        //1.array -> streams
        IntStream stream_01 = Arrays.stream(array);
        Stream<String> stream_char = Arrays.stream(strArray);

        //2. list -> streams
        List<String> ls = List.of(strArray);
        Stream<String> stream = ls.stream();

        //3. using of
        Stream<String> stringStream = Stream.of("luck", "pavan", "kalyan");
        Stream<Integer> integerStream = Stream.of(1, 3, 5, 6, 8, 97);
        Stream<Character> characterStream = Stream.of('a', 'v', 'd', 'l', 'h');

        //4. using generate it takes supplier as arg which doesn't have args just returns
        Stream<Double> generate = Stream.generate(Math::random).limit(5);

        Random random = new Random();
        Stream<Integer> generateInteger = Stream.generate(random::nextInt).limit(5);


    }
}

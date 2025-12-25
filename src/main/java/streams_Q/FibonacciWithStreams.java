package main.java.streams_Q;

import java.util.stream.Stream;

public class FibonacciWithStreams {
    public static void main(String[] args) {
        Stream.iterate(new long[] {0,1}, pair -> new long[] {pair[1],pair[0]+pair[1]})
                .limit(10)
                .map(pair -> pair[0])
                .forEach(x-> System.out.print(x+" "));
    }
}

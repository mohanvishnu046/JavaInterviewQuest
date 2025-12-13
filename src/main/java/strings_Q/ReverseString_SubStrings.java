package main.java.strings_Q;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseString_SubStrings {
    public static void main(String[] args) {
        reverseWord();
        reverseString();
    }
    private static void reverseString(){
        String str = "developer";
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0;i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
    private static void reverseWord(){
        String str = "hello world program for every developer";
        String rev = Arrays.stream(str.split(" "))
                .map(w->new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(rev);
    }

}

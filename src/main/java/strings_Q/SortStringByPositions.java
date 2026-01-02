package main.java.strings_Q;

import java.util.Arrays;

public class SortStringByPositions {
    /*
    * is1 Thi0s T3est 2a
    * out out This is a Test*/
    public static void main(String[] args) {
        String str = "is1 Thi0s T3est 2a";
        String[] arrayStr = str.split("\\s+" );
        int len = arrayStr.length;
        String [] result = new String[len];
        for(String s:arrayStr){
            StringBuilder sb = new StringBuilder();
            int position = 0;
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i)))
                    position = Character.getNumericValue(s.charAt(i));
                else sb.append(s.charAt(i));
            }
            result[position] = sb.toString();
        }
        System.out.println(Arrays.toString(result));
        System.out.println(String.join(" ",result));
    }
}

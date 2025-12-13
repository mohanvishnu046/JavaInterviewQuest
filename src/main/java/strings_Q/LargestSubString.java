package main.java.strings_Q;

import java.util.*;


public class LargestSubString {
    public static void main(String[] args) {

        System.out.println(getLargestSubString("dbcbeasfrrg"));
    }
    private static String getLargestSubString(String str){
        int maxStart =0,s =0,e=0,maxLen=0;
        Set<Character> charOcc= new LinkedHashSet<>();
        while(e<str.length()) {
            char c = str.charAt(e);
            if (!charOcc.contains(c)){
                charOcc.add(c);
                if(maxLen<e-s+1) {
                    maxLen = e - s + 1;
                    maxStart=s;
                }
                e++;
            }else{
            charOcc.remove(str.charAt(s));
            s++;
            }
        }
        return str.substring(maxStart,maxStart+maxLen);
     }

}

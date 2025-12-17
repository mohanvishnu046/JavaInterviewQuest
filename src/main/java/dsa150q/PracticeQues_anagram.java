package main.java.dsa150q;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeQues_anagram {
    public static void main(String[] args) {
        String s1="iSilent";
        String s2="Listeni";
        System.out.println(isAnagram(s1,s2));
        System.out.println(isAnagramOptimal(s1,s2));
        System.out.println(isAnagramStream(s1,s2));
    }
    private static boolean isAnagram(String s1,String s2){
        s1=s1.replaceAll("\\s", "").toLowerCase();
        s2=s2.replaceAll("\\s", "").toLowerCase();

        System.out.println(s1+" : "+s2);

        if(s1.length()!=s2.length())
            return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:s1.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        for(char c:s2.toCharArray()){
            if(!map.containsKey(c)||map.get(c)==0)// checks the key presence and its value is 0,
                return false;
            else map.put(c,map.get(c)-1);// but we need to reduce it by 1
        }
        return true;
    }

    private static boolean isAnagramOptimal(String s1,String s2){
        s1=s1.replaceAll("\\s", "").toLowerCase();
        s2=s2.replaceAll("\\s", "").toLowerCase();

        if(s1.length()!= s2.length())
            return false;

        int[] count = new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int i:count)
            if(i!=0)
                return false;
        return true;
    }

    private static boolean isAnagramStream(String s1,String s2){
        s1=s1.replaceAll("\\s", "").toLowerCase();
        s2=s2.replaceAll("\\s", "").toLowerCase();

        if(s1.length()!= s2.length())
            return false;

        Map<Character,Long> s1Chars = s1.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<Character,Long> s2Chars = s2.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        if(s1Chars.equals(s2Chars))
            return true;
        else return false;
    }
}

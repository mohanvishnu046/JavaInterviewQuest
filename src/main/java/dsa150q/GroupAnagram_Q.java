package main.java.dsa150q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram_Q {
    public static void main(String[] args) {
        String[] array1 = {"eat","ate","nat","tea","tan","bat"};
        String[] array2 = {""};
        String[] array3 = {"a"};
        getGroupAnagram(array1);
        getGroupAnagram(array2);
        getGroupAnagram(array3);
    }

    private static void getGroupAnagram(String[] array) {
        HashMap<String, List<String>> group = new HashMap<>();
        for(String s : array){
//            String key = getCountArray(s);
            String key = getSortedString(s);//sorting makes complexity
            group.computeIfAbsent(key, keyIgnore->new ArrayList<>()).add(s);

        /* if(group.containsKey(key)) {                 // it was replaced by computeIfAbsent
                List<String> anagrams = group.get(key);
                anagrams.add(s);
                group.put(key, anagrams);
            }else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                group.put(key, anagrams);
            }*/
        }
        System.out.println(group);
        System.out.println(group.values());
    }

    private static String getSortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String getCountArray(String s1){
        s1 = s1.replaceAll("\\s","").toLowerCase();
        int[] count = new int[26];
        for(char c:s1.toCharArray())
            count[c-'a']++;
        return Arrays.toString(count);
    }
}

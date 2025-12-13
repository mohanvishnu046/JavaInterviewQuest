package main.java.strings_Q;

import java.util.ArrayList;
import java.util.List;

public class Permute_String {
    public static void main(String[] args) {
        findCombinations("abc");
    }
    private static void findCombinations(String str){
        List<String> combos= new ArrayList<>();
        permute(combos,str.toCharArray(),0);
        System.out.println(combos);
    }
    private static void permute(List<String> permutes,char[] chars,int index){
        if(index== chars.length-1){
            permutes.add(String.valueOf(chars));
        }

        for(int i=index;i<chars.length;i++){
            swap(chars,i,index);
            permute(permutes,chars,index+1);
            swap(chars,i,index);
        }
    }
    static void swap(char[] array, int s, int e){
        char temp = array[s];
        array[s] = array[e];
        array[e] = temp;
    }
}

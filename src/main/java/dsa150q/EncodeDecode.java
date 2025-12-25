package main.java.dsa150q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        String[] array = {"we","are","looking","for","developer", "with", "Salary", "35000"};

        String encodedStr = encode(array);
        System.out.println(encodedStr);

        System.out.println(Arrays.toString(decode(encodedStr)));
    }

    private static String encode(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (String str : array)
            sb.append(str.length()).append("#").append(str);
        return sb.toString();
    }
    private static String[] decode(String str) {
        int i=0;
        List<String> ls = new ArrayList<>();

        while(i<str.length()){
            int ln=0;
            while(str.charAt(i)!='#'){
                ln=ln*10+(str.charAt(i)-'0');
                i++;
            }
            i++;
            StringBuilder newStr =new StringBuilder();
            for(int k=0;k<ln;k++){
                newStr.append(str.charAt(i));
                i++;
            }
            ls.add(newStr.toString());
        }
        return ls.toArray(String[]::new);
    }
}

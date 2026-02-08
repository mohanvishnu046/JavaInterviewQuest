package interview_coding;

import java.io.FilterOutputStream;

public class Q_1_StrVowelConsonant {
    /*
    * Take a string find 1st vowel and move consonants to end and add "ay"*/
    public static void main(String[] args) {
        String str = "cheese";//output: "eesechay"

        System.out.println(VCSplit(str));
        System.out.println(VCPrac(str));

    }

    private static String VCPrac(String str){
        int found=-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||
                    str.charAt(i)=='A'||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O'||str.charAt(i)=='U') {
                found = i;
                break;
            }
        }
        return (found != -1)? STR."\{str.substring(found)}\{str.substring(0, found)}ay" :"";
    }

    private static String VCSplit(String str){
        int found=-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='A'|| str.charAt(i)=='E'|| str.charAt(i)=='I'|| str.charAt(i)=='O'|| str.charAt(i)=='U'||
                    str.charAt(i)=='a'|| str.charAt(i)=='e'|| str.charAt(i)=='i'|| str.charAt(i)=='o'|| str.charAt(i)=='u') {
                found = i;
                break;
            }
        }
        return (found!=-1) ?str.substring(found) + str.substring(0, found) + "ay": "";
    }
}

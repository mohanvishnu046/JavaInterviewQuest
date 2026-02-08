package interview_coding;

public class perfectCompressStr {
    public static void main(String[] args) {
        String str = "a3c4p8a2j3c7m9";
        String perfectStr = makePerfect(str);
        System.out.println(str+"\n"+perfectStr);
    }
    static String makePerfect(String str){
        int[] charArray = new int[256];
        for(int i=0;i<str.length()-1;i+=2)
            charArray[str.charAt(i)]+=str.charAt(i+1)-'0';

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<256;i++){
            if(charArray[i]>0)
                sb.append((char) i).append(charArray[i]);
        }
        return sb.toString();
    }
}

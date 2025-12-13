package main.java.numeric_Q;

public class ArmStrongNum {
    public static void main(String[] args) {
        int dig,sum=0,num = 153; //548834
        int len = String.valueOf(num).length();

        while(num!=0){
            dig = num%10;
            sum+=Math.pow(dig, len);
            num/=10;
        }
        System.out.println(sum);
    }
}

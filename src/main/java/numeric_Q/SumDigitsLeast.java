package main.java.numeric_Q;

public class SumDigitsLeast {
    public static void main(String[] args) {
        long num = 334523462L;
        boolean flag =true;
        int sum;
        while(flag){
            sum = getSumDig(num);
            System.out.println(num+" : "+sum);
            num = sum;
            if(sum>0 && sum<=9)
                flag=false;
        }

    }

    private static int getSumDig(long num) {
        int sum =0;
        long dig;
        while(num!=0){
            dig = num%10;
            sum += (int) dig;
            num/=10;
        }
        return sum;
    }

}

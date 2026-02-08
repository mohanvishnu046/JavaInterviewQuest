package interview_coding;

public class DecimalToBinary {
    public static void main(String[] args) {
        int n= 69;
        String optimalBinary = decimalToBinaryOptimal(n);
        String binary = decimalToBinary(n);
        System.out.println("optimal :"+optimalBinary);
        System.out.println(" binary :"+binary);
        System.out.println(" binary prac :"+decimalToBinaryPrac(n));
        int decimal = binaryToDecimal(binary);
        System.out.println("decimal :"+decimal);
        System.out.println("decimal prac:"+binaryToDecimalPrac(binary));

    }

    static String decimalToBinary(int num){
        StringBuilder binary = new StringBuilder();
        while(num>0){
            binary.append((num % 2));
            num/=2;
        }
        return binary.reverse().toString();
    }
    static String decimalToBinaryOptimal(int num){
        StringBuilder binary = new StringBuilder();
        while(num>0){
            binary.append((num & 1));
            num>>=1;
        }
        return binary.reverse().toString();
    }
    static int binaryToDecimal(String binary){
      int binaryInt = Integer.parseInt(binary);
      int decimal =0;
      int base=1;
      while(binaryInt>0){
          int lastBit= binaryInt%10;
          decimal+=lastBit*base;
          base<<=1;
          binaryInt/=10;
      }
      return decimal;
    }
    static String decimalToBinaryPrac(int num){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append(num&1);
            num>>=1;
        }
        return  sb.reverse().toString();
    }

    static int binaryToDecimalPrac(String str){
        int binaryInt = Integer.parseInt(str);
        int base =1;
        int decimal=0;
        while(binaryInt>0){
            int lastDig=binaryInt%10;
            decimal+=lastDig*base;
            base<<=1;
            binaryInt/=10;
        }
        return decimal;

    }
}

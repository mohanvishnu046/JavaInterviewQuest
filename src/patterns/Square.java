package patterns;

public class Square {
    public static void main(String[] args) {

    }
    private static void printSquare(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==0||i==size-1)
                    System.out.print("*");
                if(j==0||j==size-1)
                    System.out.print("*");
            }
            for(int j=0;j<size;j++){
                if(i==0||i==size-1)
                    System.out.print("*");
                if(j==0||j==size-1)
                    System.out.print("*");
            }
        }
    }
}

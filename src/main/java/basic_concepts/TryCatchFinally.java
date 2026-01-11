package main.java.basic_concepts;

public class TryCatchFinally {
    public static void main(String[] args) {
        try{
            throw new ArithmeticException("Exception from try");
        }finally {
            throw new RuntimeException("Exception from Finally");
        }
    }/*
    *Here try block exception  is overrides by finally block
    */
}

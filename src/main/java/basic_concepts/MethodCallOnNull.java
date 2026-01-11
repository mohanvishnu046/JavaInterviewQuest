package main.java.basic_concepts;


public class MethodCallOnNull {
    public static void show(){
        System.out.println("From show");
    }
    /*
    * we can call a static method on null reference*/

    public static void main(String[] args) {
        MethodCallOnNull mn =null;
        mn.show();
    }
}

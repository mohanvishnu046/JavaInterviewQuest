package main.java.java_concepts;

public class SealedClassDemo{

    /*sealed Class : sealed classes restrict which classes can extend them, providing better control
    * introduced in java17.
    * sealed classes must use permits key word to permit which class can inherits its properties
    * sub classes can be
    * 1. final : stops here, extends not allowed
    * 2. sealed : restricts which class can extends
    * 3. non-sealed :removes all restrictions and allows ultimate inheritance.
    * */

    public static void main(String[] args) {
        Payment payParent = new Payment();
        Payment payCreditCard = new CreditCard();
        Payment payUPI = new UPI();
        Payment googlePay = new GooglePay();
        payParent.pay(300);
        payCreditCard.pay(450);
        payUPI.pay(250);
        googlePay.pay(1300);
    }
}

sealed class  Payment permits CreditCard,UPI{
    public void pay(double amount){
        System.out.println("Payment of "+amount);
    }
}

final class CreditCard extends Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Payment of "+amount+" from CreditCard");
    }
}

non-sealed class UPI extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of "+amount+" Using UPI");
    }
}

class GooglePay extends UPI{
    @Override
    public void pay(double amount) {
        System.out.println("Payment of "+amount+" Using GoolgePay UPI");
    }
}
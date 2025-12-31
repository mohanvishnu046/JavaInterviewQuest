package main.java.java_concepts;

class A {
    public synchronized void mA(B b){
        System.out.println(Thread.currentThread().getName()+" Starts executing mA");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" calls b's last method");
        b.last();
    }
    public synchronized void last(){
        System.out.println("From A's last method");
    }
}
class B {
    public synchronized void mB(A a){
        System.out.println(Thread.currentThread().getName()+" Starts executing mB");
        try {
            Thread.sleep(2000);//without sleep then no chance of dead lock situation. because chance of execution 
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" calls a's last method");
        a.last();
    }
    public synchronized void last(){
        System.out.println("From B's last method");
    }
}
public class DeadLock_Starvation extends Thread {
    /*
    * If two threads are waiting for each other forever such type of infinite waiting is called DEADLOCK.
    * Synchronized keyword is only reason for dead lock situation, hence while using synchronized key word we have to take special care
    * there are no resolution for dead lock but several prevention techniques are available.
    *
    * */
    A a = new A();
    B b = new B();


    public static void main(String[] args) {
        DeadLock_Starvation ds = new DeadLock_Starvation();
        ds.nonStaticMethod();// to call nonstatic method instance of DeadLock_Starvation is used.
    }

    private void nonStaticMethod() {
        this.start();
        b.mB(a);
    }

    @Override
    public void run() {
        a.mA(b);
    }
}

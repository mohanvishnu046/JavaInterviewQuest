package main.java.java_concepts;


public class SynchronizedDemo {
    public static void main(String[] args) {
        Display d = new Display();
        Thread t1 = new Thread(new DisplayExecute(d,"dhoni"));
        Thread t2 = new Thread(new DisplayExecute(d,"kohli"));
        Thread t3 = new Thread(new DisplayExecute(d,"rohit"));
        Thread t4 = new Thread(new DisplayExecute(d,"pandya"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Display{

    public synchronized void wish(String name){
        for(int i=0;i<5;i++) {
            System.out.print(Thread.currentThread().getName()+" : Good morning: ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
    }
}
class DisplayExecute implements Runnable{
    Display d;
    String name;
    public DisplayExecute(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}
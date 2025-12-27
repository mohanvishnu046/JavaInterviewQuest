package main.java.java_concepts;


public class SynchronizedDemo {
    /*
     * Synchronization in Java:
     *
     * Instance synchronized method requires Object-level lock (lock on current object).
     *
     * Static synchronized method requires Class-level lock (lock on Class object).
     *
     * While a thread is accessing a static synchronized method, other threads
     * cannot access other static synchronized methods of the same class,
     * but they can access non-static synchronized methods (object-level lock).
     *
     * While a thread is accessing a synchronized method of an object,
     * other threads cannot access other synchronized methods of the same object,
     * but they can access non-synchronized (normal) methods.
     *
     * Race condition occurs when multiple threads access shared data concurrently
     * and at least one thread modifies the data, leading to data inconsistency.
     * Synchronization methods or blocks are used to resolve race conditions.
     *
     * Synchronized block can be applied in three ways:
     * 1. On current object (this)
     * 2. On a particular object
     * 3. On class object (ClassName.class)
     */
    public static void main(String[] args) {
        Display d = new Display();
        Display d1 = new Display();
        Thread t1 = new Thread(new DisplayExecute(d,"dhoni"));
        Thread t2 = new Thread(new DisplayExecute(d1,"kohli"));
//        Thread t3 = new Thread(new DisplayExecute(d,"rohit"));
//        Thread t4 = new Thread(new DisplayExecute(d,"pandya"));
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}
class Display{
//  Synchronization used when multiple threads accessing same object. which may cause data inconsistency
//  for object we have non sync and sync area where non sync methods can access by multiple  threads
//  But sync area where methods are synchronized methods are stored , these methods can be called by one thread at time.


//    If multiple threads accessing same obj then synchronization required
//    If multiple threads access multiple obj then synchronization not required

//    public synchronized void wish(String name){// when multiple threads are accessing need Object level lock;
    public void wish(String name){// when multiple threads are accessing need Object level lock;
        //......too many lines of code....
        int num =5;
        System.out.println(Thread.currentThread().getName()+" .......start of too many lines");
//         below lines are example for synchronized block types.
//        synchronized (this) {// By passing this means current object level lock is required here
        synchronized (Display.class) {// By passing this means particular Class level lock is required here
        //In Synchronized block lock concept is applicable to class and object but not primitive data types eg below line
//        synchronized (num) {// It throws unexpected exception it requires object not int
            for (int i = 0; i < num; i++) {
                System.out.print(Thread.currentThread().getName() + " : Good morning: ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name);
            }
        }
        System.out.println(Thread.currentThread().getName()+" end of too many lines");
        //......too many lines of code....
    }

    public static synchronized void wishStatic(String name){// When multiple threads are accessing need Class level lock;
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
package main.java.java_concepts;

import java.util.Stack;

public class InterThreadCommunication {

    /* InterThread Communication b/w threads:
    * Two Threads can communication with each other by using wait(), notify(), notifyAll() methods
    *
    * The thread which is expecting updation is responsible to call wait method then that thread entre into waiting state
    * The thread which is responsible to updation, after update it's responsible to call notify() then waiting thread gets notification
    * then it continue to work on by using newly updated data.
    *
    * wait(), notify(), notifyAll() methods present in Object class but not in thread class, Because thread can call these methods on any java object.
    *
    * At to call wait(), notify(), notifyAll(); on any obj, Thread should be owner of that obj. i.e, the thread should has lock of that object.
    * i.e, the thread should be synchronized area.
    * Hence we can call wait(), notify(), notifyAll() only from synchronized area. otherwise we get runtime exception saying illegalMonitorStateException.
    *
    * If a thread calls wait() method on any obj it will immediately release lock of that obj, and entered into waiting state
    * eg: if a thread holds 5 lock related to 5 diff objects then if we call wait on one obj then it releases that obj lock
    * that thread remains 4 lock.
    *
    * If a thread call notify() on any obj it will release the lock, but may not immediately.
    * except notify(),notifyAll(), wait() there is no other method where thread release the lock.
    *
    * difference b/w notify(); and notifyAll();
    *
    * notify(); its call notify on obj to send notification for waiting thread, But if multiple threads are waiting then only one thread gets notify.
    * notifyAll(); it will notify all threads and all threads wait for to get lock of that obj, so one after the other get chance to execute.
    * Here notifyAll notifies only threads that are waiting for a particular obj
    * eg: 100 threads in waiting state, 60 threads for obj1 and 40 threads for obj2
    * but notifyAll on obj1,notifyAll(); means only those 60 threads wait to get lock to proceed there execution.
    *
    * */
    public static void main(String[] args) {
        MyThread task = new MyThread();
        Thread mt = new Thread(task);
        mt.start();
        /*try {
            Thread.sleep(10000);// what if main thread is not executed along or before child thread.
            *//*output:
            * Child Thread starts its procedure
            * Child Thread notifies main thread
            * Main thread calling wait on obj to proceed its work
            * *//*
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        synchronized (task) {
            try {
//            mt.join();// main thread wait until child thread finish its task
                System.out.println("Main thread calling wait on obj to proceed its work");
//                while (!task.done)
                    task.wait(5000);// By passing time args even if thread didn't got notification it will continue after 5 sec.
                System.out.println("Main thread got notification that child thread is finished/(about to finish) its work");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(task.total);
        }
        /* // In the below code main thread calls wait on stack but not in synchronized block
            Stack<Character> stack = new Stack<>();
//        synchronized (stack) {
            try {
                stack.wait(2000);// wait 2 sec but here no other thread to notify so after 2 seconds its start running..
            } catch (InterruptedException e) {// which is checked exception.
                throw new RuntimeException(e);
            }
//        }
        */
    }
}
class MyThread implements Runnable{
    int total=0;
    boolean done =false;
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Child Thread starts its procedure");
            for (int i = 1; i <= 100; i++)
                total = total + i;
            done=true;
            notify();
            System.out.println("Child Thread notifies main thread");
        }
    }
}

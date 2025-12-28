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
    *
    * */
    public static void main(String[] args) {
        MyThread task = new MyThread();
        Thread mt = new Thread(task);
        mt.start();
        synchronized (task) {
            try {
//            mt.join();// main thread wait until child thread finish its task
                while (!task.done)
                    task.wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(task.total);
        }
        /* Stack<Character> stack = new Stack<>();
            try {
                stack.wait();
            }catch (InterruptedException e) {// which is checked exception.
                throw new RuntimeException(e);
            }
            stack.notify();
            stack.notifyAll();
         */
    }
}
class MyThread implements Runnable{
    int total=0;
    boolean done =false;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++)
                total = total + i;
            done=true;
            notify();
        }
    }
}

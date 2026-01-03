package main.java.java_concepts;

public class DaemonThread {
    /*DaemonThreads:
    * Thread which are executing in the Background are called daemonThreads.
    * eg : garbage collector/signal dispatcher/ attach listener..etc..
    *
    * these daemon thread provide support for non daemon threads
    * eg, if main thread (program runs by thread) runs with low memory then JVM runs garbage collector to destroy useless obj
    * so that no of bytes of free memory will be improve, with this free memory main thread continue with its execution.
    *
    * usually daemon threads having low priority but based on our requirement daemon threads can run high priority also.
    *
    * we can check daemon nature of a thread by using isDaemon() of thread class.
    * we can change daemon nature of a thread by using setDaemon()
    * change daemon nature is possible before starting a thread only, In case we try to change daemon nature it throws RE(IllegalThreadStateException).
    *
    * what is default nature of Thread?
    * By default main thread is non-daemon nature, and all remaining threads daemon nature will be inherited from parent to child
    * i.e, if parent thread is daemon then child thread also daemon
    * if parent thread is non-daemon then child thread also non-daemon
    *
    * For main, its impossible to change daemon nature of main thread. because its already started by JVM at beginning
    *
    *
    * Daemon threads will stop execution after termination of all user threads(non-daemon threads) includes main thread.
    * */
    public static void main(String[] args) {

        System.out.println("Main thread daemon status: "+Thread.currentThread().isDaemon());
        System.out.println("Main thread before calling child thread");
        Thread t= new Thread(new MyThreadDaemon());
//        Thread.currentThread().setDaemon(true);// Throws IllegalThreadStateException
        System.out.println("Child thread daemon status: "+t.isDaemon());
        t.setDaemon(true);// By setting setDaemon we can make a thread as daemon.
        /*
        *If above line is commented then both threads are non- daemon and they will execute until there task complete.
        *If above line is not commented then daemon and non daemon which cause daemon thread execute until non-daemon terminates.
        *
        * */
        System.out.println("Child thread daemon status: "+t.isDaemon());
        t.start();
        System.out.println("Main thread after calling child thread");
        // Once main thread finish its execution tasks of daemon threads will be stopped.


    }


    void learnThread(){
        Thread t = new Thread();
        t.stop();

        /* how to stop a thread:
        * used to stop a thread execution, Immediatly thread entred into dead state.
        * it was deprecated method not recomanded to use.
        *
        * How to suspend/resume of a thread:
        **/
        t.suspend();// thread goes to suspend state
        t.resume();//thread goes to runnable state  from suspend state


        /*
        * yield() gives changes to other waiting threads to run, which are having priority same or high.
        * join() it makes the current thread to wait state until other thread to complete.
        * sleep() running thread goes to sleeping state until time expire or interrupted.
        *
        *
        * wait() thread goes to waiting state until it got notify
        * then it going to wait until it got lock of particular obj
        * then it goes to runnable
        *
        * here sleep, join and wait can also be interrupted by interrupt();
        * sleep and wait can goes to runnable state after time expire.
        *
        * stop() makes the current thread dead
        *
        * suspend() makes the thread goes to suspend state
        *
        * resume() makes the thread goes to runnable from suspend state.
        *
        * */
        t.interrupt();
    }

}
class  MyThreadDaemon implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Child Thread : " + i + " : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);// add some latency to mimics real time..
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
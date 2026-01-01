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
    * */
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().isDaemon());
        Thread t= new Thread();
//        Thread.currentThread().setDaemon(true);// Throws IllegalThreadStateException
        System.out.println(t.isDaemon());
        t.setDaemon(true);
        System.out.println(t.isDaemon());

    }
}

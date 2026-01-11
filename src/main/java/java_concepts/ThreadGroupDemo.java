package main.java.java_concepts;

public class ThreadGroupDemo {
    /*
     * Every thread in java belongs to some group, main thread belongs to Main group
     *
     * Every thread group in java is child group of System group either directly or indirectly
     * System group acts as root for Thread groups in java.
     *
     * System group contains several system level threads eg: garbage collector/finalizer, reference handler, signal dispatcher, attach listener.....etc..
     *
     * Thread Group is a class present in java.lang package and its a direct child class of Object.
     *
     * constructors:
     *
     * ThreadGroup g = new ThreadGroup(name) name is String
     * new ThreadGroup(instance,name) instance of thread group, name is string
     *
     *
     * methods:
     * String getName() returns name of thread group
     * int getMaxPriority() returns max priority of thread group  default maxPriority is 10
     * void setMaxPriority(int p) to set max priority of thread group
     *
     *
     * */
    public static void main(String[] args) {
//        Thread t = new Thread(new childThread());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
//
//        t.start();

        ThreadGroup g = new ThreadGroup("groupName_0");//parentGroup

        System.out.println(g.getParent().getName());
        ThreadGroup h = new ThreadGroup(g,"groupName_1");//child group
        System.out.println(h.getParent().getName());


    }

}
class childThread implements Runnable{

    @Override
    public void run() {
        System.out.println("From Child thread "+Thread.currentThread().getName());
        System.out.println("From Child thread "+Thread.currentThread().getThreadGroup().getName());
        System.out.println("From Child thread "+Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
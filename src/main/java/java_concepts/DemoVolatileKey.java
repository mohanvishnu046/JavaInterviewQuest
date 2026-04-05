package main.java.java_concepts;

public class DemoVolatileKey {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // Withdraw Thread 1
        Thread wThUser1 = new Thread(() -> {
            try {
                account.withdraw(100);
            } catch (InterruptedException e) {}
        }, "User-1");

        // Withdraw Thread 2
        Thread wThUser2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                account.withdraw(100);
            } catch (InterruptedException e) {}
        }, "User-2");

        // Deposit Thread
        Thread depositThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                account.deposit(200);
            } catch (Exception e) {}
        }, "Depositor");

        // Close Bank Thread
        Thread closerThread = new Thread(() -> {
            try {
//                Thread.sleep(500); // wait a bit
                account.closeBank();
            } catch (Exception e) {}
        }, "Closer");

        // Open Bank Thread
        Thread openThread = new Thread(() -> {
            try {
                Thread.sleep(3000); // reopen later
                account.openBank();
            } catch (Exception e) {}
        }, "Opener");

        // Start all threads
        wThUser1.start();
        closerThread.start();
        wThUser2.start();
        openThread.start();
        depositThread.start();
    }
}

class BankAccount {

    private int balance = 0;

    // Volatile flag for visibility across threads
    private volatile boolean isBankOpen = true;

    public synchronized void withdraw(int amount) throws InterruptedException {

        // First check: bank status (uses volatile)
        while (!isBankOpen) {
            System.out.println("Bank is closed. " + Thread.currentThread().getName() + " waiting...");
            wait();
        }

        // Second check: balance (uses synchronized + wait)
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " waiting for balance...");
            wait();
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);

        notifyAll(); // wake up waiting threads
    }

    public synchronized void closeBank() {
        isBankOpen = false;
        System.out.println("Bank is CLOSED");
    }

    public synchronized void openBank() {
        isBankOpen = true;
        System.out.println("Bank is OPEN");

        notifyAll(); // wake threads waiting for bank to open
    }
}
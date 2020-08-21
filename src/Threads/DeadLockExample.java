package Threads;

class FirstResourceUser implements Runnable {
    String s1 = "Soumya";
    String s2 = "Chatterjee";


    public void run() {
        synchronized (s1) {
            System.out.println("Thread 1: Holding on resource 1");

            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
            }

            synchronized (s2) {
                System.out.println("Thread 1: Holding on resourse 2");
            }
        }
    }
}

class SecondResourceUser implements Runnable{
    String s1 = "Soumya";
    String s2 = "Chatterjee";


    public void run() {
        synchronized (s2) {
            System.out.println("Thread 2: Holding on resource 2");
            try {
                Thread.sleep(100);
            }
            catch (Exception e) {
            }

            synchronized (s1) {
                System.out.println("Thread 2: Holding on resourse 1");
            }
        }
    }
}

class DeadLockExample{
    public static void main(String[] args) {
        FirstResourceUser firstResourceUser = new FirstResourceUser();
        SecondResourceUser secondResourceUser = new SecondResourceUser();
        Thread t1 = new Thread(firstResourceUser);
        Thread t2 = new Thread(secondResourceUser);
        t1.start();
        t2.start();
    }
}


package Threads;

class BaseClass {
    //When we use synchronized and NOT static before any function it is object level lock
    //When we use static and synchronized before any function it is class level lock
    public static synchronized void show() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A " + i);
        }
    }
}

class Runner implements Runnable{
    BaseClass base;

    public Runner(BaseClass base){
        this.base = base;
    }

    public void run(){
        try {
            BaseClass.show();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ClassAndObjectLevelLock {
    public static void main(String []args){
        BaseClass base = new BaseClass();
        Runner runnable = new Runner(base);

        Thread t1= new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }
}

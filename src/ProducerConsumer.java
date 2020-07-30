import java.util.function.Consumer;

class Base{
    int data;
    Boolean isSetDone = false;

    public synchronized void set(int data){
        while(isSetDone==true){
            try{
                wait();
            }
            catch (Exception e){}
        }
        this.data = data;
        isSetDone = true;
        notify();
        System.out.println("Set: " + data);
    }

    public synchronized void get(){
        while (isSetDone == false){
            try {
                wait();
            }
            catch (Exception e){}
        }
        System.out.println("Get: " + data);
        isSetDone = false;
        notify();
    }
}

class Producer implements Runnable {

    Base base;

    public Producer(Base base) {
        this.base = base;
    }

    public void run() {
        int i = 0;
        while (true) {
            base.set(i++);
            try {
                Thread.sleep(500);
            } catch (Exception e) { }
        }
    }
}

class Consumer1 implements Runnable{
    Base base;

    public Consumer1(Base base){
        this.base = base;
    }

    public void run(){
        while(true){
            base.get();
            try{
                Thread.sleep(1500);
            }
            catch (Exception e){}
        }
    }
}

public class ProducerConsumer {
    public static void main(String []args) {
        Base base = new Base();
        Producer producer = new Producer(base);
        Consumer1 consumer1 = new Consumer1(base);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer1);
        t1.start();
        t2.start();
    }
}

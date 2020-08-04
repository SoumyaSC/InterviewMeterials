/*

package Interview;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Base{
    int i;

    public void set(int i){
        System.out.println("Set: "+ i);
    }

    public void get(){
        System.out.println("Get: "+ i);
    }
}
class HelperA implements Runnable{
    Base base;

    public HelperA(Base base){
        this.base = base;
    }

    public void run(){
        int i=0;
        while (true){
            base.set(i);
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }
    }
}

class HelperB implements Runnable{
    Base base;

    public HelperB(Base base){
        this.base = base;
    }

    public void run(){
        int i=0;
        while (true){
            base.get();
            try {
                Thread.sleep(500);
            }
            catch (Exception e){}
        }
    }
}


public class Interview {
    public static void main(String [] args) {

        Base base = new Base();
        HelperA helperA = new HelperA(base);
        HelperB helperB = new HelperB(base);

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add();


        Thread t1 = new Thread(hashSet);
        Thread t2 = new Thread(hashSet);
        t1.start();
        t2.start();
    }
}




public class Interview{
    // 1 2 3 4
    // 2 1 3 4
    public Node reverse(Node head){
        Node previous = null;
        Node current = head;
        Node next = null;

        while(current.next!=null){
            next = current.next;
            current.next = prev;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
}



class Base{
    int i;
    Boolean isSetDone = false;

    public synchronized void set(int i){
        while(isSetDone){
            try {
                wait();
            }
            catch (Exception e){}
        }
        this.i = i;
        System.out.println("Set: " + i);
        isSetDone = true;
        notify();
    }

    public synchronized void get(){
        while (!isSetDone){
            try{
                wait();
            }
            catch (Exception e ){}
        }
        System.out.println("Get: " + i);
        isSetDone = false;
        notify();
    }
}

class Producer implements Runnable{
    Base base;

    public Producer(Base base){
        this.base = base;
    }

    public void run(){
        int i=0;
        while(true){
            base.set(i++);
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }
    }

}

class Consumer implements Runnable{
    Base base;

    public Consumer(Base base){
        this.base = base;
    }

    public void run(){
        while (true){
            base.get();
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){}

        }
    }
}

class DriverOddEven{
    public static void main(String []args) {
        Base base = new Base();
        Producer producer = new Producer(base);
        Consumer consumer = new Consumer(base);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start()*//*

*/
/**//*
*/
/*
;
        t2.start();
    }
}






new HashMap<>();

16 segments

 1 2 3 ....16


Soumya  1111 == 996861293649649 == 1
Sagnik  2222 == 275744665858578 == 2
X       3333                    == 2

2 segment

*//*

package Interview;

class Pen{
    int price;
    String brand;

    public Pen()
    {
    }

*/
/*    public Pen(int price, String brand){
        this.price = price;
        this.brand = brand;
    }*//*



    public void getDetailsOfPen(){
        System.out.println(price + " " + brand);
    }
*/
/**//*

}

public class Interview{
    public static void main(String []args){
        Pen pen = new Pen();
        //pen.getDetailsOfPen();
    }
}

*/

package Interview;

class Car{
    String name;
    String color;

    public Car(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void show(){
        System.out.print("Name: " + name + " Color: " + color);
    }
}

class Person{
    Car car;
    String name;

    Person(Car car, String name){
        this.car = car;
        this.name = name;
    }

    public void showName(){
        car.show();
        System.out.println(" Name: " + name);
    }
}

public class Interview{
    public static void main(String []args) {
        Car car1 = new Car("Maruti", "Blue");
        Car car2 = new Car("Hyundai", "Black");

        Person person1 = new Person(car1, "Joe");
        Person person2 = new Person(car2, "Smith");
        person1.showName();
        person2.showName();
    }
}










package Generics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Helper1 implements Runnable{
    Map<String, Integer> map;

    Helper1(Map map){
        this.map = map;
    }

    public void run(){
        map.put("Helper1", 1);
        try{
            System.out.println("Helper1");
            Thread.sleep(500);
        }
        catch (Exception e){}
    }
}

class Helper2 implements Runnable{
    Map<String, Integer> map;

    Helper2(Map map){
        this.map = map;
    }

    public void run(){
        map.put("Helper2", 2);
        try{
            System.out.println("Helper2");
            Thread.sleep(500);
        }
        catch (Exception e){}
    }
}


public class ConcurrentHashMapDemo {
    public static void main(String []args) {

        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Helper1 helper1 = new Helper1(concurrentHashMap);
        Helper2 helper2 = new Helper2(concurrentHashMap);

        Thread t1 = new Thread(helper1);
        Thread t2 = new Thread(helper2);
        t1.start();
        t2.start();
    }
}

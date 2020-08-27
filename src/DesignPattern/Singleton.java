package DesignPattern;

import java.security.Signature;

public class Singleton {

    //step 1: make constructor private
    private Singleton()
    {

    }

    //step2: create static object of the class inside the same class
    public static Singleton singleton = new Singleton();

    //step3: expose static function to return "singlton" object so
    //that other class can access the object of Singleton class
    public static Singleton getInstace(){
        return singleton;
    }

    public void getMyName(){
        System.out.println("Soumya");
    }
}

class SingletonDriver{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstace();
        singleton.getMyName();
    }
}















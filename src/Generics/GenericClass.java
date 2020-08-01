package Generics;

public class GenericClass<E> {
    public void show(E data){
        System.out.println(data);
    }
}

class Driver11{
    public static void main(String []args){
        GenericClass genericClass = new GenericClass();
        genericClass.show(5);
        
    }
}
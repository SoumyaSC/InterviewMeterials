package Generics;

public class GenericMethod {
    public <E> void show(E i){
        System.out.println(i);
    }
}

class Driver10{
    public static void main(String []args){
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.show("5");
        genericMethod.show("Soumya");
    }
}
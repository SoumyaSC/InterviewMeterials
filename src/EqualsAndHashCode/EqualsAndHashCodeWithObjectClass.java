package EqualsAndHashCode;

class Pen{
    int price;
    String name;

    public Pen(int price, String name){
        this.price = price;
        this.name = name;
    }
}

public class EqualsAndHashCodeWithObjectClass {
    public static void main(String []args) {

        Pen pen1 = new Pen(100, "Reynolds");
        Pen pen2 = new Pen(100, "Reynolds");

        System.out.println(pen1.equals(pen2));
    }
}

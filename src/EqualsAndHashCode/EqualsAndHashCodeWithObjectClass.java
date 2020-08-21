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

        //they are not equal, as it is using object's equals impl
        System.out.println(pen1.equals(pen2));

        //different hashcode, as it is using object's hashcode impl
        System.out.println(pen1.hashCode());
        System.out.println(pen2.hashCode());

        //false, as both objects are different
        System.out.println(pen1==pen2);
    }
}

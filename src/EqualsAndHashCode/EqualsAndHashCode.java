package EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

class MyPen{
    int price;
    String name;

    public MyPen(int price, String name){
        this.price = price;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        MyPen pen = (MyPen)obj;
        if((this.price == pen.price) && (this.name.equals(pen.name))){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return price + name.hashCode();
    }
}

public class EqualsAndHashCode {
    public static void main(String []args) {

        MyPen pen1 = new MyPen(100, "Reynolds");
        MyPen pen2 = new MyPen(100, "Reynolds");

        //Required for equals
        System.out.println(pen1.equals(pen2));

        //Required for hashcode
        Set<MyPen> pen = new HashSet<>();
        pen.add(pen1);
        pen.add(pen2);

        System.out.println(pen);
    }
}

package ComparableAndComparator;

import java.util.*;

class Laptop /*implements Comparable<Laptop>*/{
    int price;
    String brand;

    public Laptop(int price, String brand){
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

/*    @Override
    public int compareTo(Laptop laps) {
        if(this.price > laps.price){
            return 1;
        }
        else{
            return -1;
        }
    }*/
}


public class ComprableAndComparator {
    public static void main(String []args) {

        Laptop l1 = new Laptop(1000, "Apple");
        Laptop l2 = new Laptop(1100, "Dell");
        Laptop l3 = new Laptop(900, "HP");

        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(l1);
        laptopList.add(l2);
        laptopList.add(l3);


        //Using comparator
        Comparator<Laptop> com = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop laps1, Laptop laps2) {
                if(laps1.price > laps2.price){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };


        Collections.sort(laptopList,com);

        for(Laptop i : laptopList){
            System.out.println(i.toString());
        }
    }

}

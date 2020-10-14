package Algorithms;

//K, V - Array - Index (Insert, del is constant time)
public class CustomHashMap <E> {
    Object[] keyArray = new Object[10];
    int[] valueArray = new int[10];

    public void customHashMapInsert(E key, int value){
        valueArray[(int) key] = value;
    }

    public int get(int key){
        return valueArray[key];
    }
}


class DriverHM{
    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.customHashMapInsert(2, 5);
        int val = customHashMap.get(2);
        System.out.println(val);
    }
}
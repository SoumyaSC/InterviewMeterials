package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class AraayListWithinAList {
    public void show(List<List<Integer>> list){
        List<Integer> innerList;
        //iterate over outer list
        for(int i=0; i<list.size(); i++){
            //get i'th list
            innerList = list.get(i);
            //every i'th list is a list of int itself, iterate over that
            for(int j=0; j<innerList.size(); j++){
                System.out.println(innerList.get(j));
            }
        }
    }
}

class DriverArrayList{
    public static void main(String[] args) {
        List<Integer> listInner1 = new ArrayList<>();
        listInner1.add(10);
        listInner1.add(20);
        listInner1.add(30);
        listInner1.add(40);

        List<Integer> listInner2 = new ArrayList<>();
        listInner1.add(60);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(listInner1);
        arr.add(listInner1);

        AraayListWithinAList a = new AraayListWithinAList();
        a.show(arr);
    }
}
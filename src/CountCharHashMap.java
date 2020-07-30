import java.util.HashMap;
import java.util.Map;

public class CountCharHashMap {

    //Actual function
    public void count(String data){
        char [] ch = data.toCharArray();

        Map<Character, Integer> hashMap = new HashMap<>();

        for(int i=0; i<ch.length; i++){
            if(hashMap.containsKey(ch[i])){
                hashMap.put(ch[i], hashMap.get(ch[i]) + 1);
            }
            else{
                hashMap.put(ch[i], 1);
            }
        }

        //Print all using Map.Entry interface
        //Map is an interface, Entry is also an interface
        for(Map.Entry mapEntry : hashMap.entrySet()){
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }

    }
}

class Driver9{
    public static void main(String []args){
        CountCharHashMap map = new CountCharHashMap();
        map.count("Soumya");
    }
}

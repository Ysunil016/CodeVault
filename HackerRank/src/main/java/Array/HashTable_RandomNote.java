package Array;

import java.util.HashMap;

public class HashTable_RandomNote {
    public static void main(String[] args) {
       checkMagazine(new String[]{"One Two Three"},new String[]{"One Two Three Four"});
    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String x:magazine){
            if(hashMap.containsKey(x)){
                hashMap.put(x,hashMap.get(x)+1);
            }else{
                hashMap.put(x,1);
            }
        }
        for(String x:note){
            if(!hashMap.containsKey(x)){
                System.out.println("No");
                return;
            }else{
                hashMap.put(x,hashMap.get(x)-1);
                if(hashMap.get(x) == 0){
                    hashMap.remove(x);
                }
            }
        }
        System.out.println("Yes");
    }
}

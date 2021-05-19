package October;

import java.util.HashMap;

public class K_Difference_Array {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{4,6,2,5,7,8},5));
    }

    public static int findPairs(int[] noms, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int x:noms){
            hashMap.put(x, hashMap.getOrDefault(x,0)+1);
        }
        int result = 0;
        for(int key:hashMap.keySet()){
            if((k > 0 && hashMap.containsKey(key+k)) || (k == 0 && hashMap.get(key+k) > 1)){
                result++;
            }
        }
        
        return result;
    }

}

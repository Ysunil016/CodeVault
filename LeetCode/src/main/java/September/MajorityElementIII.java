package September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementIII {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,4,3}));
        System.out.println(majorityElementBruteForce(new int[]{3,4,3}));

    }

    public static List<Integer> majorityElementBruteForce(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int x:nums){
            if(!hashMap.containsKey(x))
                hashMap.put(x,1);
            else
                hashMap.put(x,hashMap.get(x)+1);
        }

        List<Integer> finalList = new ArrayList<>();
        for(int key:hashMap.keySet()){
            if(hashMap.get(key) > Math.floor(nums.length)/3){
                finalList.add(key);
            }
        }
        return finalList;
    }

    public static List < Integer > majorityElement(int[] nums) {

        // 1st pass
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass
        List result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int n: nums) {
            if (n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);

        return result;
    }

}

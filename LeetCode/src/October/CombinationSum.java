package October;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{3,2,5,1},7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        findCombinations(candidates,target,new ArrayList<>(),result);
        return new ArrayList<>(result);
    }

    private static void findCombinations(int[] candidates,int target,List<Integer> list, Set<List<Integer>> result){
        if(target < 0){
            return;
        } else if(target == 0){
            Collections.sort(list);
            result.add(list);
        }
        for(int c:candidates){
            List<Integer> copyList = new ArrayList<>(list);
            copyList.add(c);
            findCombinations(candidates,target-c,copyList,result);
        }
    }

}

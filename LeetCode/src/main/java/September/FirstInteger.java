package September;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstInteger {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{4,3,5,2,6}));
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 1;
        while(set.contains(i)) i++;
        return i;
    }
}

package October;

public class HouseRobII {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }


    public static int rob(int[] nums) {
        if(nums.length==0) return nums[0];
        return Math.max(robState(nums,0,nums.length-1),robState(nums,1, nums.length));
    }

    private static int robState(int[] nums,int start,int end){
        int twoStepBack = 0;
        int oneStepBack = 0;
        int max = 0;

        for(int i=start;i<end;i++){
            max = Math.max(twoStepBack + nums[i],oneStepBack);
            twoStepBack = oneStepBack;
            oneStepBack = max;
        }
    return max;
    }
}

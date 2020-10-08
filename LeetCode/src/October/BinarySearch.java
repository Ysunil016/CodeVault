package October;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,4,5,7,9,20},9));
    }

    public static int search(int[] nums, int target) {
        return findElement(nums,0,nums.length-1,target);
    }

    private static int findElement(int[] nums,int start,int end,int target){
        int middleIndex = start + (end-start)/2;
        if(nums[middleIndex] == target){
            return middleIndex;
        }
        if(start == end){
            return -1;
        }
        if(target < nums[middleIndex]){
            return findElement(nums,start,middleIndex,target);
        }else{
            return findElement(nums,middleIndex+1,end,target);
        }
    }
}

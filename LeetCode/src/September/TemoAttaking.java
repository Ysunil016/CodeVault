package September;

public class TemoAttaking {

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,2},2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int resultDuration = 0;

        int startPoint = 0;
        int endPoint = 0;

        for(int cTime:timeSeries){
            if(cTime >= endPoint){
                resultDuration += duration;
            }else {
                resultDuration += cTime - startPoint;
            }
            startPoint = cTime;
            endPoint = cTime+duration;
        }


        return resultDuration;
    }
}

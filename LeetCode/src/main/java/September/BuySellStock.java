package September;

public class BuySellStock {

    public static void main(String[] args) {
//        System.out.println(getResult(new int[]{7,1,5,3,6,4}));
        System.out.println(getResultOptimized(new int[]{7,1,5,3,6,4}));
    }

//    BruteForce
    private static int getResult(int[] list){
        int finalAnswer = 0;

        // Since, we are allowed to Have only 1 Trans - Buy and Sell
        // Lets Go for BruteForce forNow
        for(int i=0;i<list.length;i++){
            finalAnswer = Math.max(finalAnswer,getMaxProfit(list,i));
        }

        return finalAnswer;
    }

    private static int getMaxProfit(int[] list, int index) {
        int boughtPrice = list[index];

        int maxProfit = 0;
        for(int i=index+1;i<list.length;i++){
            maxProfit = Math.max(maxProfit,list[i]-boughtPrice);
        }
        return maxProfit;
    }

    // Optimized
    private static int getResultOptimized(int[] list){
        if(list.length == 0)return 0;

        int maxProfit = 0;
        int prevMin = list[0];

       for(int x:list){
           if(x > prevMin){
                maxProfit = Math.max(maxProfit,(x - prevMin));
           }else{
               prevMin = x;
           }
       }
        return maxProfit;
    }

}

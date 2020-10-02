package October;

import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCalls {

    static List<Integer> list = new ArrayList<>();
    static int initPointer = 0;
    static int elementCounter = 0;

    public static void main(String[] args) {
        int[] arr = {1,100,200};
        for(int x:arr){
            System.out.println(ping(x));
        }
    }



    public static int ping(int t) {
        int low = t - 3000;
        elementCounter++;
        list.add(t);
        if(low < 0){
            return elementCounter;
        }else{
            while(initPointer < list.size() && list.get(initPointer) < low){
                initPointer++;
            }
            return elementCounter - initPointer;
        }
    }

}

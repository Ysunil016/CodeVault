package September;

public class GasSolution {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2,3,5},new int[]{3,4,5}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0)
            return 0;
        int tank = 0,total = 0,index = 0;
        for(int i=0;i<gas.length;i++){
            int consume = gas[i] - cost[i];
            tank += consume;
            if(tank < 0){
                index = i + 1;
                tank = 0;
            }
            total += consume;
        }
    return (total < 0)?-1:index;
    }

}

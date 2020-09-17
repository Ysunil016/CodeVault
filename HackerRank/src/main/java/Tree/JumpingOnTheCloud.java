package Tree;

public class JumpingOnTheCloud {

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0,0,0,0,1,0}));
    }

    static int jumpingOnClouds(int[] c) {
            int finalResult = 0;
            int x = 0;
            while(x < c.length-1){
                if( x+2 == c.length || c[x+2]==1){
                    x++;
                    finalResult++;
                }else{
                    x+=2;
                    finalResult++;
                }
            }
            return finalResult;
    }


}

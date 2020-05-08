package May.WeekTwo;

public class CheckStraightLine {

	public static void main(String[] args) {
		int[][] arr = {{0,0},{1,1}};
		System.out.println(checkStraightLine(arr));
	}
	public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates==null || coordinates.length==0 || coordinates.length ==1)
            return false;
        
            int X1 = coordinates[0][0];
            int Y1 = coordinates[0][1];
            int X2 = coordinates[1][0];
            int Y2 = coordinates[1][1];
        
            float primarySlope = Float.MAX_VALUE;
            if(X2-X1!=0)
                primarySlope = (float)(Y2-Y1)/(float)(X2-X1);
        
            for(int i=0;i<coordinates.length-1;i++){
                
            X1 = coordinates[i][0];
            Y1 = coordinates[i][1];
            X2 = coordinates[i+1][0];
            Y2 = coordinates[i+1][1];
            
            int X_D = X2-X1;
            int Y_D = Y2-Y1;
                
            if(X_D==0){
                if(primarySlope!=Float.MAX_VALUE)
                    return false;
            }else{
                float slope = (float)Y_D/(float)X_D;
                if(slope!=primarySlope)
                    return false;
            }
                
            }
        
        return true;   
    }
}

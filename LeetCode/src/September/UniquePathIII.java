package September;

public class UniquePathIII {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII(grid));
    }

    static int uniquePathsIII(int[][] grid) {

        // Finding the Coordinate of Start and End
        int sX = 0;
        int sY = 0;

        int zeroCount = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    zeroCount++;
                }else if(grid[i][j]==1){
                    sX = i;
                    sY = j;
                }
            }
        }
        return dfs(grid,sX,sY,zeroCount);
    }

    static int dfs(int[][] grid,int X,int Y,int zCount){
       // Base Case
        if(X < 0 || Y < 0 || X >= grid.length || Y >= grid[0].length || grid[X][Y] == -1){
            return 0;
        }

        // Reached out to Destination
        if(grid[X][Y] == 2)
            return (zCount == -1)?1:0;

        // Making Visited
        grid[X][Y] = -1;

        zCount--;
        int total = dfs(grid,X+1,Y,zCount) + dfs(grid,X,Y+1,zCount)+dfs(grid,X-1,Y,zCount)+dfs(grid,X,Y-1,zCount);
        // Making Back to 0 After Traversal
        grid[X][Y] = 0;

        return  total;
    }
}

package Array;

//
//  Number of Islands
//  Given an m x n 2D binary grid-grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

/*
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
*/

/*
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
*/
public class NumberOfIslands {
    int[][] plane;

    public NumberOfIslands(int[][] plane) {
        this.plane = plane;
    }

    public int play() {
        int totalIsland = 0;
        for (int idx = 0; idx < plane.length; idx++)
            for (int idy = 0; idy < plane[0].length; idy++)
                if (plane[idx][idy] == 1) {
                    findIsland(plane, idx, idy);
                    totalIsland++;
                }
        return totalIsland;
    }

    private void findIsland(int[][] plane, int x, int y) {
        if (x < 0 || y < 0 || x >= plane.length || y >= plane[0].length) return;
        if (plane[x][y] == 1) {
            plane[x][y] = 0;
            findIsland(plane, x + 1, y);
            findIsland(plane, x - 1, y);
            findIsland(plane, x, y - 1);
            findIsland(plane, x, y + 1);
        }
    }


}

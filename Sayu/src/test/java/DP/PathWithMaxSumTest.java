package DP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PathWithMaxSumTest {

    @Test
    public void act(){
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int pathWithMaxSum = new PathWithMaxSum().play(grid);
        assertEquals(24, pathWithMaxSum);
    }

}
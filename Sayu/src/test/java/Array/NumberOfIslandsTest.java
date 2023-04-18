package Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    public void act() {
        int[][] plane = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        int actualIslands = new NumberOfIslands(plane).play();
        int expectedIsland = 3;
        assertEquals(expectedIsland, actualIslands);
    }

}
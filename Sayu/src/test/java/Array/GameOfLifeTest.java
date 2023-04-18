package Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class GameOfLifeTest {

    @Test
    public void act() {
        int[][] board = new int[][]{{1, 1}, {1, 0}};

        new GameOfLife(board).play();

        int[][] expectedResult = new int[][]{{1, 1}, {1, 1}};
        assertArrayEquals(expectedResult, board);
    }

}
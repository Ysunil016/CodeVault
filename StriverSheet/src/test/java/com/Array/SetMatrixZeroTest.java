package com.Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroTest {

    @Test
    void shouldSetMatrixZeroBruteForce() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] actual = new SetMatrixZero().play(matrix, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSetMatrixZeroOptimal() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] actual = new SetMatrixZero().play(matrix, 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSetMatrixZeroBest() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] actual = new SetMatrixZero().play(matrix, 3);
        assertArrayEquals(expected, actual);
    }

}
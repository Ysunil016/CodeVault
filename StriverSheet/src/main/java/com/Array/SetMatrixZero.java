package com.Array;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

    public int[][] play(int[][] matrix, int type) {
        long currentTime = System.nanoTime();

        int[][] result = switch (type) {
            case 1 -> brute(matrix);
            case 2 -> optimal(matrix);
            case 3 -> best(matrix);
            default -> throw new RuntimeException("No Such Implementation");
        };

        System.out.println("Time Taken - " + (System.nanoTime() - currentTime));
        return result;
    }

    private int[][] brute(int[][] matrix) {
        // O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currentElement = matrix[row][col];
                // O(N+M)
                if (currentElement == 0) {
                    for (int rowTraverse = 0; rowTraverse < matrix.length; rowTraverse++)
                        matrix[rowTraverse][col] = -1;
                    for (int colTraverse = 0; colTraverse < matrix[0].length; colTraverse++)
                        matrix[row][colTraverse] = -1;
                }
            }
        }

        // O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currentElement = matrix[row][col];
                if (currentElement == -1) matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    private int[][] optimal(int[][] matrix) {
        // S - O(N + M)
        Set<Integer> zeroCol = new HashSet<>();
        Set<Integer> zeroRow = new HashSet<>();

        // T - O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currentElement = matrix[row][col];
                if (currentElement == 0) {
                    zeroCol.add(col);
                    zeroRow.add(row);
                }
            }
        }

        // T - O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (zeroRow.contains(row)) matrix[row][col] = 0;
                if (zeroCol.contains(col)) matrix[row][col] = 0;
            }
        }

        return matrix;
    }

    private int[][] best(int[][] matrix) {
        // T - O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currentElement = matrix[row][col];
                if (currentElement == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        // T - O(N*M)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }
        return matrix;
    }
}

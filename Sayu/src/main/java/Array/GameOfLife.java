package Array;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    public static void main(String[] args) {
//        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] board = new int[][]{{1, 1}, {1, 0}};

        gameOfLife(board);

        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static private void gameOfLife(int[][] board) {
        List<Coord> listOfChangedCoordinates = new ArrayList<>();
        for (int idx = 0; idx < board.length; idx++) {
            for (int idy = 0; idy < board[idx].length; idy++) {
                listOfChangedCoordinates.addAll(neighbourCoordinates(idx, idy, board));
            }
        }

        for (Coord coord : listOfChangedCoordinates) {
            int x = coord.x;
            int y = coord.y;
            int valueToChange = coord.value;
            board[x][y] = valueToChange;
        }

    }

    private static List<Coord> neighbourCoordinates(int x, int y, int[][] board) {
        int[][] neighbours = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int maxX = board.length - 1;
        int maxY = board[0].length - 1;
        List<Coord> updateCoordinates = new ArrayList<>();

        int currentNodeValue = board[x][y];
        int liveNeighbourCells = 0;
        for (int[] neighbour : neighbours) {
            int nX = x + neighbour[0];
            int nY = y + neighbour[1];
            if (nX >= 0 && nX <= maxX && nY >= 0 && nY <= maxY) {
                int neighbourValue = board[nX][nY];
                liveNeighbourCells += neighbourValue == 1 ? 1 : 0;
            }
        }

        if (currentNodeValue == 1) {
//            Any live cell with fewer than two live neighbors dies as if caused by under-population.
            if (liveNeighbourCells < 2) updateCoordinates.add(new Coord(x, y, 0));
//            Any live cell with more than three live neighbors dies, as if by over-population.
            if (liveNeighbourCells > 3) updateCoordinates.add(new Coord(x, y, 0));
        } else {
//            Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
            if (liveNeighbourCells == 3) updateCoordinates.add(new Coord(x, y, 1));
        }

        return updateCoordinates;
    }

    static class Coord {
        int x, y, value;

        Coord(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

}

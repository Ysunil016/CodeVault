package DP;

class PathWithMaxSum {

    public int play(int[][] grid) {
        int maxSum = 0;

        for (int idx = 0; idx < grid.length; idx++) {
            for (int idy = 0; idy < grid[idx].length; idy++) {
                if (grid[idx][idy] == 0 || grid[idx][idy] == -1) continue;
                maxSum = Math.max(maxSum, findMax(grid, idx, idy));
            }
        }

        return maxSum;
    }

    private int findMax(int[][] grid, int idx, int idy) {
        if (idx < 0 || idx >= grid.length) return 0;
        if (idy < 0 || idy >= grid[0].length) return 0;
        if (grid[idx][idy] == 0 || grid[idx][idy] == -1) return 0;

        int currentValue = grid[idx][idy];

        grid[idx][idy] = -1;

        int leftSum = findMax(grid, idx - 1, idy);
        int rightSum = findMax(grid, idx + 1, idy);
        int topSum = findMax(grid, idx, idy - 1);
        int bottomSum = findMax(grid, idx, idy + 1);

        grid[idx][idy] = currentValue;


        return currentValue +
                Math.max(Math.max(leftSum, rightSum), Math.max(topSum, bottomSum));
    }
}

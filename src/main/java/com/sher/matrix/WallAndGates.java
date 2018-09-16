package com.sher.matrix;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 *   Leetcode : Medium (fb)
 */

public class WallAndGates {
    private static final int INF = 1000;
    public static void main(String arg[]) {
        int [][] matrix = {
                { INF, -1,  0,   INF},
                { INF, INF, INF, -1 },
                { INF, -1,  INF, -1 },
                { 0,   -1,  INF,  INF}
        };
        Matrix.print(matrix);
        wallandgates(matrix);
        Matrix.print(matrix);
    }

    static void wallandgates(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j =0; j < m[0].length; j++) {
                if (m[i][j] == 0) { //gate
                    dfs(m, i,j, 0);
                }
            }
        }
    }

    static void dfs(int m[][], int i, int j, int val) {
        if (i < 0 || i >= m.length ||
                j < 0 || j >= m[0].length
                || m[i][j] < val)
            return;

        m[i][j] = val;
        dfs(m, i -1, j, val + 1);
        dfs(m, i, j -1, val + 1);
        dfs(m, i + 1, j, val + 1);
        dfs(m, i , j + 1 , val + 1);
    }
}

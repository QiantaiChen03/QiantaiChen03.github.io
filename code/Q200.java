package com.leetcode;

public class Q200 {
    //Find Number of Islands
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;

        int[][] visited = new int[grid.length][grid[0].length];

        //正方形O(n^2)
        //因为row与col不一样 -> O(m x n)

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++){
                if (visited[i][j] == 0 && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    result ++;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int[][] visited, int i, int j){
        if(visited[i][j] == 1){
            return;
        }

        visited[i][j] = 1;

        if (grid[i][j] == '1') {
            //right
            if (j < grid[0].length-1){
                dfs(grid, visited, i, j+1);
            }
            //left
            if(j > 0){
                dfs(grid, visited, i, j-1);
            }
            //up
            if(i > 0){
                dfs(grid, visited, i-1, j);
            }
            //down
            if (i < grid.length-1) {
                dfs(grid, visited, i+1, j);
            }

        }
        return;
    }

    public static void main (String[] args) {

    }
}

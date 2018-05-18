import java.util.HashSet;
import java.util.Set;

public class TestCheck {
    public static void main(String[] args) {

        Set<Integer> s = new HashSet<>();

        s.add(10);
        if (!s.add(10))
            System.out.println("duplicate");

        int[][] grid ={{1,1,1,0,1},{1,0,2,0,1},{0,0,1,0,1},{1,0,1,1,0}};

        System.out.println(escape_from_grid(grid));

    }


    static int escape_from_grid(int[][] grid) {
        // Write your code here

        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0, col = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
boolean visit[][]= new boolean[rows][cols];
        return findBound(grid, visit,row, col, rows, cols);
    }

    static int findBound(int[][] grid, boolean[][] visit,int row, int col, int rows, int cols) {

        if (row == rows - 1 || row == 0 || col == 0 || col == cols - 1 ) {
            return 0;
        }

        if (isPlant(grid, row, col))
            return Integer.MAX_VALUE;
        if(visit[row][col])
            return 0;
visit[row][col]=true;
        return 1 + Math.min(Math.min(findBound(grid, visit,row + 1, col, rows, cols), findBound(grid, visit,row , col+1, rows, cols)),
                Math.min(findBound(grid, visit,row-1, col , rows, cols), findBound(grid, visit,row, col - 1, rows, cols)));
    }

    static boolean isPlant(int[][] grid, int row, int col) {

        if (grid[row][col] == 1)
            return true;
        else
            return false;
    }

}
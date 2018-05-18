package Graphs;

public class EscapeFromGrid {
    static int finalMin=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] grid ={{1,1,1,0,1},
                {1,0,0,0,1},
                {1,2,1,0,1},
                {1,1,1,1,0}};
int count=0;
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
        findLen(grid,visit,count,row,col,rows,cols);
        System.out.println("fin  " +
                ""+finalMin);
    }

    static void findLen(int[][] grid,boolean[][] visit,int count,int row,int col,int rows,int cols){

        if (row == rows - 1 || row == 0 || col == 0 || col == cols - 1 ) {

            if(count<finalMin)
                finalMin=count;
            return;
        }

        if(grid[row][col]==1)
            return;
visit[row][col]=true;
        if(grid[row-1][col]==0 && !visit[row-1][col])
             findLen(grid,visit,count+1,row-1,col,rows,cols);
        if(grid[row][col-1]==0 && !visit[row][col-1])
            findLen(grid,visit,count+1,row,col-1,rows,cols);
        if(grid[row][col+1]==0 && !visit[row][col+1])
            findLen(grid,visit,count+1,row,col+1,rows,cols);

        if(grid[row+1][col]==0 && !visit[row+1][col])
            findLen(grid,visit,count+1,row+1,col,rows,cols);



    }
}

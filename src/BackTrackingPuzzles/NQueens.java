package BackTrackingPuzzles;

public class NQueens {
int N=5;
    public  static void main(String[] args){
        NQueens nq= new NQueens();
        int[][] grid = {{0,0,0,0,0},
                { 0, 0, 0, 0,0},
                {0, 0, 0, 0,0},
                {0, 0, 0, 0,0},
                {0,0,0,0,0}};

        if (nq.SolveNQueens(grid,0) == true)
            nq.printSolution(grid);
        else
            System.out.println("No solution exists");
    }

    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }
    boolean SolveNQueens(int[][] grid,int col){


           if(col >=N)
             return true;

             for(int row=0;row<N;row++){

                 if(isSafe(grid,row,col)){

                     grid[row][col]=1;

                     if(SolveNQueens(grid,col+1))
                             return true;
                     grid[row][col] =0;
                 }
             }

        return false;
    }

    boolean isSafe(int[][] grid,int row,int col){
int i,j;
        for (i=0;i<col;i++){
            if(grid[row][i]==1)
                return false;
        }

        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(grid[i][j]==1)
                return false;
        }

        for(i=row,j=col;i<N && j>=0;i++,j--){
            if(grid[i][j]==1)
                return false;
          }

return true;
    }


}

package BackTrackingPuzzles;

import java.util.Arrays;

public class Sudoku {
   static int row=0,col=0;
    public static void main (String args[]){
        Sudoku solve= new Sudoku();
        // 0 means unassigned cells
        int N=9;
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (solve.SolveSudoku(grid) == true)
            solve.printGrid(grid);
        else
            System.out.println("No solution exists");
    }

      boolean SolveSudoku(int[][] grid){


        if (!FindUnassignedLocation(grid)){
            return true;
        }

        for (int num=1;num<=9;num++){

            System.out.println("num  "+num+" row "+row+" col "+col);
            printGrid(grid);
            if(isSafe(grid,row,col,num)){
                System.out.println("Safe    --->num  "+num+" row "+row+" col "+col);
                printGrid(grid);
                grid[row][col] =num;

                if(SolveSudoku(grid)){
                    return true;
                }

                grid[row][col] = 0;
            }

        }
        return false;
    }

    boolean isSafe(int[][] grid,int rowLoc,int colLoc,int num){

        return !safeInRow(grid,rowLoc,colLoc,num) && !safeInCol(grid,rowLoc,colLoc,num) && !safeInGrid(grid,rowLoc,colLoc,num);

    }

    boolean safeInRow(int[][] grid,int rowLoc,int colLoc,int num){

       // System.out.println("grid length "+grid.length);
        for(int j=0;j<grid.length;j++){

            if(grid[rowLoc][j] ==num ){
                     return true;
            }
        }
        return false;
    }

    boolean safeInCol(int[][] grid,int rowLoc,int colLoc,int num){

        for(int i=0;i<grid.length;i++){

            if(grid[i][colLoc] ==num ){
                return true;
            }
        }
        return false;
    }
    boolean safeInGrid(int[][] grid,int rowLoc,int colLoc,int num){
          int startPoint=0,endPoint=0;
          int smallGrid = (int)Math.sqrt(grid.length);
        if(rowLoc <=smallGrid-1 ) {
         startPoint= 0;
        }
        else if( rowLoc<= 2*smallGrid-1){
            startPoint=smallGrid;
        }
        else if(rowLoc <=3*smallGrid-1){
            startPoint=2*smallGrid;
        }
        if(colLoc <=smallGrid-1 ) {
            endPoint= 0;
        }
        else if(colLoc<= 2*smallGrid-1){
            endPoint=smallGrid;
        }
        else if(colLoc <=3*smallGrid-1){
            endPoint=2*smallGrid;
        }
        for (int i=startPoint;i<=startPoint+2;i++) {
            for(int j=endPoint;j<=endPoint+2;j++){
                if (grid[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }

      boolean FindUnassignedLocation(int[][] grid){

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if (grid[i][j]==0){
                    row=i;
                    col=j;
                    return true;
                }
            }
        }
        return false;
     }

      void printGrid(int[][] grid){
          for(int i=0;i<grid.length;i++){
              for(int j=0;j<grid.length;j++){

                  System.out.print(grid[i][j] +"  ");
              }
              System.out.println();
          }

     }






}

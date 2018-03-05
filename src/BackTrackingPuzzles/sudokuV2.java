package BackTrackingPuzzles;

public class sudokuV2 {
    int row=0,col=0;
    public static void main (String args[]){
        sudokuV2 solve= new sudokuV2();
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


        if (!FindUnassignedLocation(grid,row,col)){
            return true;
        }

        for (int num=1;num<=9;num++){

            if(isSafe(grid,row,col,num)){
                grid[row][col] =num;

                if(SolveSudoku(grid)){
                    return true;
                }

                grid[row][col] = 0;
            }

        }
        return false;
    }

    boolean isSafe(int[][] grid,int row,int col,int num){

        return safeInRow(grid,row,col,num) && safeInCol(grid,row,col,num) && safeInGrid(grid,row,col,num);

    }

    boolean safeInRow(int[][] grid,int row,int col,int num){

        for(int j=0;j<=grid.length;j++){

            if(grid[row][j] !=0 ){
                if(grid[row][j]!=num){
                    if(j!=col)
                        return true;
                }
            }
        }
        return false;
    }

    boolean safeInCol(int[][] grid,int row,int col,int num){

        for(int i=0;i<=grid.length;i++){

            if(grid[i][col] !=0 ){
                if(grid[i][col]!=num){
                    if(i!=row)
                        return true;
                }
            }
        }
        return false;
    }
    boolean safeInGrid(int[][] grid,int row,int col,int num){
        int startPoint=0,endPoint=0;
        int smallGrid = (int)Math.sqrt(grid.length);
        if(row <=smallGrid-1 ) {
            startPoint= 0;
        }
        else if( row<= 2*smallGrid-1){
            startPoint=smallGrid;
        }
        else if(row <=3*smallGrid-1){
            startPoint=2*smallGrid;
        }
        if(col <=smallGrid-1 ) {
            endPoint= 0;
        }
        else if( row<= 2*smallGrid-1){
            endPoint=smallGrid;
        }
        else if(row <=3*smallGrid-1){
            endPoint=2*smallGrid;
        }
        for (int i=startPoint;i<=startPoint+2;i++) {
            for(int j=endPoint;j<=endPoint+2;j++){
                if (grid[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    boolean FindUnassignedLocation(int[][] grid,int row,int col){

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

        System.out.println(grid.toString());
    }






}

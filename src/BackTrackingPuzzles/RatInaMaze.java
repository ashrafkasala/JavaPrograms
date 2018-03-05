package BackTrackingPuzzles;

public class RatInaMaze {
int N=4;
    public static void main (String args[]){
        RatInaMaze solve= new RatInaMaze();
        // 0 means unassigned cells
        int maze[][] = {{1, 1, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if ( solve.solveMaze(maze,0,0,sol) == true)
            solve.printSolution(sol);
        else
            System.out.println("No solution exists");
    }
    boolean solveMaze(int[][] maze,int hor,int ver,int[][] sol){

        if(hor==N-1 && ver==N-1){
            sol[N-1][N-1]=1;
            return  true;
        }

        if(isSafe(maze,hor,ver)){

            sol[hor][ver]=1;

            if(solveMaze(maze,hor+1,ver,sol))
                return  true;

            if(solveMaze(maze,hor,ver+1,sol))
                return true;

            sol[hor][ver]=0;
            return false;

        }

        return false;
    }

    boolean  isSafe(int[][] maze,int hor,int ver){

        return  (hor>=0 && hor<=N-1 && ver>=0 && ver<=N-1 && maze[hor][ver]==1);
    }
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
}

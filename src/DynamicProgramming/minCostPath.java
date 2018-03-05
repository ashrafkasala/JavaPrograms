package DynamicProgramming;


import java.util.Arrays;

public class minCostPath {
    int M=3;
    int N=3;
    public static void main(String args[])
    {
        minCostPath mc= new minCostPath();
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                mc.minCost(cost,2,1));


    }

    int minCost(int[][] cost,int m,int n){

        int lookUp[][] =new int[M][N];
        lookUp[0][0]=cost[0][0];
        for (int row=1;row<M;row++)
            lookUp[row][0]=lookUp[row-1][0]+cost[row][0];

        for(int col=1;col<N;col++){
            lookUp[0][col]=lookUp[0][col-1]+cost[0][col];
        }

        for(int row=1;row<M;row++){
            for (int col=1;col<N;col++){
                lookUp[row][col]=cost[row][col]+min(lookUp[row-1][col-1],lookUp[row-1][col],lookUp[row][col-1]);
            }
        }
        System.out.println("look up table"+ lookUp);

        for (int row = 0; row < lookUp.length; row++) {
            for (int col = 0; col < lookUp[row].length; col++) {
               System.out.print("   "+lookUp[row][col]);
            }
            System.out.println();

        }


        return lookUp[m][n];
    }

    int min(int x,int y,int z){

        if(x<y)
            return x<z?x:z;
        else
            return y<z?y:z;

    }

}

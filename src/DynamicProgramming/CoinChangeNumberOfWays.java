package DynamicProgramming;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class CoinChangeNumberOfWays {

    public static void main(String[] args) {
        ConcurrentHashMap map;
        int[] coins ={0,1,2,3};
        int m=coins.length;
        int n=5;
        //solution 1

        int[] table1 = new int[n+1];
        table1[0]=1;
        for(int i=0;i<m;i++){
            for(int j=coins[i];j<=n;j++){
                table1[j]+=table1[j-coins[i]];
            }
        }

        System.out.println("table "+ Arrays.toString(table1));

        //approach 2
        //

        int[][] table2=new int[m+1][n+1];

        for(int i=0;i<m;i++){
            table2[i][0]=1;
        }

        for(int i=1;i<m;i++){

            for(int j=1;j<=n;j++){

                if(j>=coins[i]){

                    table2[i][j]=table2[i-1][j]+table2[i][j-coins[i]];
                }
                else
                    table2[i][j]=table2[i-1][j];
            }
        }

        for(int i=0;i<m+1;i++)
        System.out.println(Arrays.toString(table2[i]));

    }
}

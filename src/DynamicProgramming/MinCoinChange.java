package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCoinChange {
    public static void main (String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, m, V));
    }

    static int minCoins(int[] coins,int m,int V){

        int lookup[]= new int[V+1];

        lookup[0]=0;

for(int i=1;i<=V;i++)
    lookup[i]=Integer.MAX_VALUE;


        for(int i=1;i<=V;i++){

            for(int j=0;j<m;j++){

                if(coins[j]<=i){

                    int subres=lookup[i-coins[j]];

                    if(subres+1 < lookup[i] && subres!=Integer.MAX_VALUE){
                        lookup[i]=subres+1;
                    }

                }
            }

        }
        System.out.println("lookup = " + Arrays.toString(lookup));
return lookup[V];
    }
}

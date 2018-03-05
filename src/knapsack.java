import java.util.Arrays;

/**
 * Created by kaas0616 on 2018-02-05.
 */
public class knapsack {

    public static void main(String[] args){
        int val[] = new int[]{60, 100, 120,};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSack(int W , int[] wt,int[] val,int n){
        int[][] LookUp= new int[n+1][W+1];


        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0)
                    LookUp[i][w]=0;
                else if(wt[i-1]<=w)
                    LookUp[i][w]=Math.max(val[i-1]+LookUp[i-1][W-w],LookUp[i-1][W]);
                else
                    LookUp[i][w]=LookUp[i-1][w];
            }
        }
for(int i=0;i<=n;i++)
System.out.println(Arrays.toString(LookUp[i]));
        return LookUp[n][W];
    }
}

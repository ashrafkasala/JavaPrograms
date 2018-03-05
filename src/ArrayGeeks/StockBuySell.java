package ArrayGeeks;

public class StockBuySell {

    public static void main (String[] args){
        StockBuySell buySell=new StockBuySell();

        int[] arr = {100,180,260,310,40,535,695};
        int[] arr2 = {1000,120};
        int x=1;int y=10;
        int maxProfit=buySell.findMaxProfit(arr2);
        System.out.println("StockBuySell   " +maxProfit);
    }

    int findMaxProfit(int[] arr){
        int maxProfit=0;

int j;
        for(int i=0;i<arr.length-1;i++){
           int prev=0;
            boolean flagIncrese=false;
            for (j=i+1;j<arr.length;j++){
                if (arr[j]>arr[i] && arr[j]>prev){
                    flagIncrese = true;
                    prev=arr[j];
                    continue;
                }
                else
                    break;
            }

            if(flagIncrese){
                maxProfit=maxProfit+Math.abs(arr[i]-arr[j-1]);
            }
            i=j-1;

        }

        return maxProfit;
    }
}

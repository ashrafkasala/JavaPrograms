package ArrayGeeks;

public class MinimumDistBetwTwoNumbersV2 {

    public static void main (String[] args){
        MinimumDistBetwTwoNumbersV2 minD=new MinimumDistBetwTwoNumbersV2();

        int[] arr = {1,2,7,1,3,2,10};
        int x=7;int y=1;
        int minDist=minD.findMin(arr,x,y);
        System.out.println("mindistance  " +minDist);
    }

    int findMin(int[] arr,int x,int y){
        int minDist=Integer.MAX_VALUE;
        int prev=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]== x || arr[i]==y){
                prev=i;
                break;
            }
        }

        for(int i=prev+1;i<arr.length;i++){

            if(arr[i]==x || arr[i]==y){

                if(arr[i] != arr[prev] && minDist > Math.abs(i-prev))
                {
                    minDist=Math.abs(i-prev);
                }
                prev=i;
            }
        }
        return minDist;
    }
}

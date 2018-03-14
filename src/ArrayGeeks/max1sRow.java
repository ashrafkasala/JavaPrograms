package ArrayGeeks;

/**
 * Created by kaas0616 on 2018-03-07.
 */
public class max1sRow {
    public static void main(String... args){
        int[][] a={{0,0,0,1,1},{0,0,1,1,1},{0,1,1,1,1},{0,0,1,1,1}};
        int max=Integer.MIN_VALUE;
        int rowNo=0,R;
        for( R=0;R< a.length;R++){

            int index=findFirstOcuurenceOfOne(a[R],0,a[0].length-1);

            if(index-a[0].length > max ){
                rowNo=R;
                max=index-a[0].length;
            }
        }
        System.out.println("Max 1s at "+R+" with sum "+max);

    }

    static int findFirstOcuurenceOfOne(int[] a,int low,int high){

        if(low >high)
            return -1;
        int mid=low +(high-low)/2;

      //  if(a[mid]==1 && a[mid-1]==0)
return 1;
    }

}

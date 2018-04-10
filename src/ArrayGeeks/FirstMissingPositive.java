package ArrayGeeks;

/**
 * Created by kaas0616 on 4/10/2018.
 */

/**
 *
 * n2 -brute force search all elemnets from 1 to n
 * n logn +n -- sort and linear scan
 * n time n space--> hashing to store positive elements and linear scan
 *
 * n time 1 spacee---> mark all  visited elemnts as -ve
 *
 * ------------------> first positive vvalue at index is the missing one first
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] a= {-2,3,4,5,-1,0,2,3,1,8,6,7};

        //segregate positive at first and negative next
        int j=segregate(a);
        //find first missing one
        for(int i=0;i<j;i++){

            if(Math.abs(a[i])-1 <j && a[Math.abs(a[i])-1] >0){

                a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
            }
        }

        for(int i=0;i<j;i++){

            if(a[i]>0){
                int res=i+1;
                System.out.print("First Msiing one  "+res);
            }
        }
    }

    static int segregate(int[] a){
        int j=0;

        for(int i=0;i<a.length;i++){

            if(a[i]>0){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }
        }
        return j;
    }
}

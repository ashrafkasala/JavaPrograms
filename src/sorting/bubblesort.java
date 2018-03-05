package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class bubblesort {

    public static  void main (String args[]){
        bubblesort sort = new bubblesort();

        Scanner scan = new Scanner(System.in);
        System.out.println("enter array  size");
        int n = scan.nextInt();
        int[] a = new int[n];

        for (int i=0;i<n;i++) {
            a[i]=scan.nextInt();
        }
        sort.Bubblesort(a);

    }
    void Bubblesort(int[] a){
int flag =0;
        for (int i=1;i<a.length;i++){

            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int temp= a[j];
                    a[j]=a[j+1];
                    a[j+1]= temp;
                    flag=1;
                }
            }
if(flag ==0){break;}
        }

        System.out.println("Sorted Array "+ Arrays.toString(a));
    }
}

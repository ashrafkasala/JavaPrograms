package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class selectionsort {

    public static  void main (String args[]){
        selectionsort sort = new selectionsort();

        Scanner scan = new Scanner(System.in);
        System.out.println("enter array  size");
        int n = scan.nextInt();
        int[] a = new int[n];

        for (int i=0;i<n;i++) {
            a[i]=scan.nextInt();
        }
        sort.Selsort(a);

    }
    void Selsort(int[] a){

        for (int i=0;i<a.length;i++){
            int min=i;

            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    min=j;
                }
            }
            int temp= a[min];
            a[min]=a[i];
            a[i]= temp;

        }

        System.out.println("Sorted Array "+ Arrays.toString(a));
    }
}

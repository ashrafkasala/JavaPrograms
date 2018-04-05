package Trees;

import java.util.Arrays;

public class HeapifyingTheArray {
static int size=4;
    public static void main(String... args){
      //  MaxHeapArray mh=new MaxHeapArray();
        int a[]={2,3,1,4};
        int n=a.length;
        for(int i=(n-1)/2;i>=0;i--){

            percolateDown(i,a);
            System.out.println("afor ="+ Arrays.toString(a));
        }

        System.out.println("a main="+ Arrays.toString(a));
    }
  static  void percolateDown(int index,int[] a){
        int l=getLeftChild(index);
        int r=getRightChild(index);
        int max;
        while(l!=-1 || r!=-1 ){

            if(l!=-1 && a[l]>a[index])
                max=l;
            else
                max=index;

            if(r!=-1 && a[r]>a[max])
                max=r;

            if(max!=index){
                int temp=a[max];
                a[max]=a[index];
                a[index]=temp;
                l=getLeftChild(max);
                r=getRightChild(max);
            }
            else{
                l=-1;
                r=-1;
            }
        }

      System.out.println("a percolatedown="+ Arrays.toString(a));
    }
   static int getLeftChild(int index){

        if(2*index+1 <size)
            return 2*index+1;
        else
            return -1;
    }

   static int getRightChild(int index){

        if(2*index+2 <size)
            return 2*index+2;
        else
            return -1;
    }
}

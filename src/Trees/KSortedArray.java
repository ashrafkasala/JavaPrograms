package Trees;

import java.util.Arrays;

/**
 * Created by kaas0616 on 4/5/2018.
 */
public class KSortedArray {
    public static void main(String... args){
        KSortedArray ks=new KSortedArray();
        int[] ar={1,2,0,4,5,3,7,6,8};
        int k=2;
        int j=0;
        int[] heapArray=new int[k+1];

        for(int i=0;i<=k;i++){
            heapArray[i]=ar[i];
        }

        //heapify the array
        ks.MinheapifyArray(heapArray);

        for(int i=k+1;i<ar.length;i++){
            ar[j]=heapArray[0];
            j++;
            heapArray[0]=ar[i];
            ks.percolatedown(0,heapArray);
        }
        System.out.println("ar = " + Arrays.toString(ar));

        System.out.println("heapArray= " + Arrays.toString(heapArray));


        //heapsort the heaparray
        int n=heapArray.length;
      ks.MaxHeapifyArray(heapArray);

      for(int i=n-1;i>=0;i--){

          int temp=heapArray[0];
          heapArray[0]=heapArray[i];
          heapArray[i]=temp;
          //max heapify with specified index
          ks.Maxheapify(heapArray,0,i);
      }


        System.out.println("ar = " + Arrays.toString(ar));

        System.out.println("heapArray= " + Arrays.toString(heapArray));
    }

    void Maxheapify(int[] heapArray,int index,int n){

        int leftChild=2*index+1;
        int rightChild=2*index+2;
        int max=0;
        if(leftChild>=n && rightChild>=n)
            return;
        else{
            if(leftChild<n && heapArray[leftChild] > heapArray[index])
                max=leftChild;
            else
                max=index;
            if(rightChild<n && heapArray[rightChild]>heapArray[max])
                max=rightChild;

            if(max!=index){

                int temp=heapArray[max];
                heapArray[max]=heapArray[index];
                heapArray[index]=temp;
                percolatedown(max,heapArray);
            }
        }

    }

    void MaxHeapifyArray(int[] heapArray){

        for(int i=(heapArray.length-1)/2;i>=0;i--){
            percolatedownMaxHeap(i,heapArray);
        }

    }

    void percolatedownMaxHeap(int i,int[] heapArray){
        int leftChild=getLeftChild(i,heapArray);
        int rightChild=getRightChild(i,heapArray);
        int max=0;
        if(leftChild==-1 && rightChild==-1)
            return;
        else{
            if(leftChild!=-1 && heapArray[leftChild] > heapArray[i])
                max=leftChild;
            else
                max=i;
            if(rightChild!=-1 && heapArray[rightChild]>heapArray[max])
                max=rightChild;

            if(max!=i){

                int temp=heapArray[max];
                heapArray[max]=heapArray[i];
                heapArray[i]=temp;
                percolatedown(max,heapArray);
            }
        }
    }

    void MinheapifyArray(int[] heapArray){
int n=heapArray.length;
        for(int i=(n-1)/2;i>=0;i--)
            percolatedown(i,heapArray);

    }

    void percolatedown(int i,int[] heapArray){

        int leftChild=getLeftChild(i,heapArray);
        int rightChild=getRightChild(i,heapArray);
        int min=0;
        if(leftChild==-1 && rightChild==-1)
            return;
        else{
            if(leftChild!=-1 && heapArray[leftChild] < heapArray[i])
                min=leftChild;
            else
                min=i;
            if(rightChild!=-1 && heapArray[rightChild]<heapArray[min])
                min=rightChild;

            if(min!=i){

                int temp=heapArray[min];
                heapArray[min]=heapArray[i];
                heapArray[i]=temp;
                percolatedown(min,heapArray);
            }
        }
    }

    int getLeftChild(int i,int[] heapArray){
        int n=heapArray.length;
        if(2*i+1 >= n)
            return -1;
        else
            return 2*i+1;

    }
    int getRightChild(int i,int[] heapArray){
        int n=heapArray.length;
        if(2*i+2 >= n)
            return -1;
        else
            return 2*i+2;

    }
}

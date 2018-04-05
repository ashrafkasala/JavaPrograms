package Trees;

import java.util.Arrays;
import java.util.Scanner;

public class MaxHeapArray {
static int size=0,capacity=1;
    public static void main(String... args){
        MaxHeapArray maxH=new MaxHeapArray();
        int a[]= new int[1];

        System.out.println("a = " + Arrays.toString(a));
        Scanner scan = new Scanner(System.in);
        while(true){

            System.out.println("enter 1,insert 2,delete ");
            int n=scan.nextInt();
            if(n==1) {

                int x=scan.nextInt();
                a=maxH.insert(x,a);
            }
            else if(n==2) {
//                int del = scan.nextInt();
//                if (del == 1) {
//                    System.out.println("1,delete by index");
//                    int index = scan.nextInt();
//                    maxH.deletebyIndex(index,a);
//                } else if(del == 2){
//                    int value = scan.nextInt();
//                    System.out.println("2,delete by value");
//                  //  maxH.deletebyValue(value);
//                } else {
                    System.out.println("3,delete at end");
              //  int index = scan.nextInt();
                    maxH.delete(a);
               // }
            }

            System.out.println("a mian = " + Arrays.toString(a));
        }
    }

    int[] insert(int value,int[] a){

        if(isFull(a))
           a= Resize(a);
        System.out.println("a = " + Arrays.toString(a));
        int indexLast=getSize(a);
        a[indexLast]=value;
        percolateUp(indexLast,a);
        size++;
        return a;
    }

    void percolateDown(int index,int[] a){
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
    }

    void delete(int[] a){

        if(size==0)
            return;
        int temp=a[getSize(a)-1];
        a[0]=temp;
        size--;
        percolateDown(0,a);

    }

    int getLeftChild(int index){

        if(2*index+1 <size)
            return 2*index+1;
        else
            return -1;
    }

    int getRightChild(int index){

        if(2*index+2 <size)
            return 2*index+2;
        else
            return -1;
    }
    int[] Resize(int[] a){

         capacity=2*a.length;
        a= Arrays.copyOf(a,capacity);
        // System.arraycopy(a,0,);
return a;
    }



    boolean isFull(int[] a){
        int i=getSize(a);
        if(i >= capacity)
            return true;
        else
            return false;
    }

    int getSize(int[] a){

        return size;
    }


    void percolateUp(int index,int[] a){


        for(int i=(index-1)/2;i>=0;i=(i-1)/2){

            if(a[index] > a[i]){
                //swap
                int temp=a[index];
                a[index]=a[i];
                a[i]=temp;
                index=i;
            }
            else
                break;

        }
    }
}

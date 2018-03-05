package ArrayGeeks;

import java.util.*;

public class MinimumDistBetwTwoNumbers {

    public static void main (String[] args){
        MinimumDistBetwTwoNumbers minD=new MinimumDistBetwTwoNumbers();

        int[] arr = {1,2,7,1,3,2,10};
        int x=1;int y=10;
        int minDist=minD.findMin(arr,x,y);
        System.out.println("mindistance" +minDist);
    }

    int findMin(int[] arr,int x,int y){
int minDist=Integer.MAX_VALUE;
        List<Integer> indexX=new ArrayList<Integer>();
        List<Integer> indexY = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if (arr[i]==x){
                indexX.add(i);
            }
            else if(arr[i]==y){
                indexY.add(i);
            }
        }
        int xSize=0,ySize=0;
        System.out.println("indexX"+indexX.toString());
        System.out.println("indexY"+indexY.toString());
        while(xSize<indexX.size() && ySize < indexY.size()) {
            int diff =Math.abs(indexX.get(xSize) - indexY.get(ySize));

            if (indexX.get(xSize) > indexY.get(ySize)){
                ySize++;
            }
            else
                xSize++;
            if(minDist > diff)
                minDist=diff;
        }

//        Iterator itX=indexX.listIterator();
//        Iterator itY=indexY.listIterator();
//        while(itX.hasNext() &&  itY.hasNext()){
//            int x1=Integer.parseInt(itX.toString());
//            int y1=Integer.parseInt(itY.toString());
//            int Diff =Math.abs(x1-y1);
//            if(x1>y1)
//                itY.next();
//            else
//                itX.next();
//            if(minDist < Diff)
//            minDist=Diff;
//        }
       return minDist;
  }


}

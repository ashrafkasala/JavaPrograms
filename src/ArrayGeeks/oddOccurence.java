package ArrayGeeks;

public class oddOccurence {

    public static void main (String[] args){
        oddOccurence odd=new oddOccurence();

        int[] arr = {3,3,1,2,7,7,3,2,3,1,3,2,2,3,7};
        int x=7;int y=1;
        int oddOccu=odd.getOddOccurence(arr);
        System.out.println("oddOccurence  " +oddOccu);
    }

    int getOddOccurence(int[] arr){
        int res=0;
        for (int i=0;i<arr.length;i++){
            res=res ^ arr[i];
            System.out.println("res  "+res);
        }
        return res;
    }
}

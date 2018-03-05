package ArrayGeeks;

public class peakElement {

    public static void main (String[] args){
        peakElement peakEle=new peakElement();

        int[] arr = {1,2,7,1,3,2,10,78,3,2,32};
        int x=7;int y=1;
        peakEle.findpeakElement(arr);
        System.out.println("peak elements  ");
    }

    void findpeakElement(int[] arr){

        int n=arr.length;
        if(arr[0]>= arr[1]){
            System.out.println(arr[0]);
        }

        for(int i=1;i<=n-2;i++){

            if (arr[i]> arr[i-1] && arr[i]> arr[i+1]){
                System.out.println(arr[i]);
            }
        }
        if (arr[n-1]>= arr[n-2]){
            System.out.println(arr[n-1]);
        }
    }
}

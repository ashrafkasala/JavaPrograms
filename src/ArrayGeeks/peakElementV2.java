package ArrayGeeks;

public class peakElementV2 {

    public static void main (String[] args){
        peakElementV2 peakV2=new peakElementV2();

        int[] arr = {1,5,2,7,1,3,2,10,5};
        System.out.println("peak elements  " +peakV2.findPeak(arr));
    }

    int findPeak(int[] arr) {
        int n= arr.length;
        return findPeakRec(arr,0,n-1,n);
    }

    int findPeakRec(int[] arr,int low,int high,int n){

        int mid= low +(high-low)/2;

        if(mid==0 || (arr[mid]>= arr[mid-1] && arr[mid] >= arr[mid+1]) || mid==n-1) {
            System.out.println("mid peak elements  "+arr[mid]);
            return arr[mid];
        }
        if(mid > 0 && arr[mid] < arr[mid-1])
            return findPeakRec(arr,low,mid-1,n);
        else
            return findPeakRec(arr,mid+1,high,n);

    }

}

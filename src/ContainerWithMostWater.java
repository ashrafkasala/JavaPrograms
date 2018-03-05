/**
 * Created by kaas0616 on 2018-02-08.
 */
public class ContainerWithMostWater {

    public static void main(String[] args){
        int[] arr = {3,1,2,4,5};
        int n=arr.length;
        int max_area=Integer.MIN_VALUE,max_so_far;
        int left=0;
        int right =n-1;
        for(int i=0;i<n;i++) {
            if (left < right) {
                max_so_far = (right - left) * (Math.min(arr[left], arr[right]));

                if (max_area < max_so_far)
                    max_area = max_so_far;

                if (arr[left] < arr[right])
                    left++;
                else
                    right--;


            }
        }

        System.out.print("max sum=  "+max_area);

    }
}

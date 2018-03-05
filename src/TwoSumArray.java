import java.util.HashMap;

/**
 * Created by kaas0616 on 2018-02-08.
 */
public class TwoSumArray {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        int n = arr.length;
        int targetSum=9;
        HashMap<Integer,Integer> hash = new HashMap();
        for(int i=0;i<n;i++){



            if(null==hash.get(targetSum-arr[i])){
                hash.put(arr[i],i);
            }

            else
                System.out.print("indexes are "+i +"   "+hash.get(targetSum-arr[i]));

        }
    }
}

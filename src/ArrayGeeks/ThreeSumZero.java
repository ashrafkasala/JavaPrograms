package ArrayGeeks;

import java.util.*;

public class ThreeSumZero {

static List<Integer> list = new ArrayList<>();
    public  static void main(String... args){

        int[] arr= {-1,0,1,2,-1,-4};

        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;i++){

            checkTwoSum(-arr[i],arr,i);
        }

    }

    static void checkTwoSum(int target,int[] arr,int index) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (i != index && !list.contains(target)) {
                if (map.get(target - arr[i]) == null) {
                    map.put(arr[i], i);
                } else {
                    int temp = -target;
                    int temp2 = target - arr[i];
                    System.out.println("Triplet " + arr[i] + "  " + temp + " " + temp2);
                }


            }

        }
        list.add(target);
        map.clear();
    }
}

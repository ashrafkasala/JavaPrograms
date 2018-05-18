package ArrayGeeks;


import java.util.HashMap;
import java.util.HashSet;

/**
 * a= 1 4 2 10 8 3 5
 * 0/p -5 (1 2 3 4 5)
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a={3,3,1,2,2,10,4,8,8,5,4};

        /*
        approahc 1

        add all elements to hash map,

        check if elemnt is starting one in the sequence

        if yes ,find next elements and update length
        * */
        System.out.println(approach1(a));

        //approach 2
        /*
        * for each n  element check for n-1 and n+1
        *
        * if found update left and right extremes of the sequence with total length
        *
        * */

        System.out.println(approach2(a));
    }

    static int approach1(int[] a){

        HashSet<Integer> set = new HashSet<>();
        int res=0;
        for(int i=0;i<a.length;i++)
            set.add(a[i]);

        for(int i=2;i<=Integer.MAX_VALUE;i=i+2){

            for(int j=i;j<=Integer.MAX_VALUE;j=j+2)
            {

                if(i+j==i*j)
                    System.out.println("j = " + j+"  i=  "+i);
            }
        }

        for(int i=0;i<a.length;i++){

            if(!set.contains(a[i]-1)){

                int j=a[i];
int count=0;
                while(set.contains(j)) {
                    j++;
                    count++;
                }
                if(count>res)
                    res=count;
            }
        }
        return res;
    }

    static int approach2(int[] a){
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){

            if(!map.containsKey(a[i])){
                int left=map.containsKey(a[i]-1)?map.get(a[i]-1):0;
                int right=map.containsKey(a[i]+1)?map.get(a[i]+1):0;

                int sum =left+right+1;
                map.put(a[i],sum);
                res=Math.max(res,sum);
                map.put(a[i]-left,sum);
                map.put(a[i]+right,sum);
            }
        }
        return res;
    }
}

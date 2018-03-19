package ArrayGeeks;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by kaas0616 on 2018-03-15.
 */
public class MaxSumOfNoAdjacent {
    public static void main(String... args){

        int[] a= {3,2,5,10,1};

        int incl=0,excl=0;
        int prevIncl=0,PrevExcl=0;

        for(int i=0;i<a.length;i++){

            incl=PrevExcl+a[i];
            excl=Math.max(PrevExcl,prevIncl);

            PrevExcl=excl;
            prevIncl=incl;

        }

        System.out.println("excl  "+excl+"  incl  "+incl);

    }
}

package Greedy;

import java.util.*;

/**
 * Created by kaas0616 on 5/17/2018.
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {

        System.out.println("enter Intervals");

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        ArrayList<Intervals> list=new ArrayList<>();
        while(n>0){
            System.out.println("enter start");
            int start=scan.nextInt();
            System.out.println("enter end");
            int end=scan.nextInt();
            list.add(new Intervals(start,end));
            n--;
        }


        Collections.sort(list,new IntervalComparator());

        int end2=list.get(0).end;

        int count=1;

        for(int i=1;i<list.size();i++){

            if(list.get(i).start >= end2)
            {
                end2=list.get(i).end;
                count++;
            }
        }

        System.out.println("Maximum Non overlapping intervals "+count);

    }
}

class IntervalComparator implements Comparator<Intervals>{

    @Override
    public int compare(Intervals t1, Intervals t2) {
        return t1.end-t2.end;
    }
}
class Intervals{

    int start,end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
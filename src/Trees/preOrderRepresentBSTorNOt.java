package Trees;

/**
 * Created by kaas0616 on 2018-03-07.
 */
public class preOrderRepresentBSTorNOt {

    public static void main(String... args){

       //int a[]={2,4,3,1};
        int a[]={6,4,1,5,8,7,12};
        int start= 0;
        int end=a.length-1;
        if(check(a,start,end))
            System.out.println("YEs");
        else
            System.out.println("NO");
    }

    static boolean check(int[]  a,int start,int end){

        if(start>=end)
            return true;

         int i,i2,parti=-1;boolean foundGreat=false;
        int currentNode=a[start];
        for( i=start+1;i<=end;i++){
            if(a[i] > currentNode) {
                parti=i;
                foundGreat=true;
                break;
            }
        }
if(foundGreat) {
    for (i2 = parti+1; i2 <= end; i2++) {
        if (a[i2] < currentNode)

            return false;
    }
    check(a, start + 1, parti - 1);
    check(a, parti+1,end);
}
else
    check(a,start+1,end);

        return true;
    }
}

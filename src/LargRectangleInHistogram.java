/**
 * Created by kaas0616 on 2018-02-19.
 */
public class LargRectangleInHistogram {

    public static void main(String... aa){
        int[] a={357,300,5,6,5,2,355,1,1,2,2,3,3,4,4,5,4,3,5,4,3,4,4,5,5};
        int base=1;
        int maxArea=Integer.MIN_VALUE;
        int maxSoFar=0;
        for(int i=0;i<a.length;i++){
            base=1;
            boolean first =true;
            int currentmin=a[i];
            for(int j=i;j<a.length;j++){
                if(first){
                    maxSoFar =base*a[j];
                    first=false;
                }
                else
                maxSoFar=base*Math.min(a[j],currentmin);

                if(a[j]<currentmin)
                    currentmin=a[j];

                if(maxArea <maxSoFar )
                    maxArea=maxSoFar;
                base++;

            }
        }

        System.out.print("Max Area "+maxArea);

    }
}

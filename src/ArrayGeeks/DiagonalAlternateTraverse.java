package ArrayGeeks;


/*
*  1 2 3
*  4 5 6
*  7 8 9
*
*  o/p 1 2 4 7 5 3 6 8 9
*
* */
public class DiagonalAlternateTraverse {
    public static void main(String... args){
        int a[][]={{1,2,3,10},
                {4,5,6,11},
                {7,8,9 ,12},
                {13,14,15,16}};

        int n=a.length;
        //up direction -1,+1
        //down direction 1 -1
        int r=0,c=0;

        while(r!=a.length-1 || c!=a.length-1 ){

            //go up

            while(r>=0 && c<n){

                System.out.print(a[r][c]+"  ");

                r=r-1;
                c=c+1;
            }

            r=r+1;
            c=c-1;

            //if right there go right else go down
            if(c+1<n){
                c=c+1;
            }
            else{
                r=r+1;
            }

            //go down



            while(c>=0 && r<n){

                System.out.print(a[r][c]+"  ");

                r=r+1;
                c=c-1;
            }

            r=r-1;
            c=c+1;

            //if down there go down else go right
            if(r+1<n){
                r=r+1;
            }
            else{
                c=c+1;
            }
        }

        System.out.print(a[n-1][n-1]);

    }
}

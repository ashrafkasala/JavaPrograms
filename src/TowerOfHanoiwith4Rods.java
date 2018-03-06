/**
 * Created by kaas0616 on 2018-03-05.
 */
/*
*  T(N) =

          T(N/2)  // Moving top N/2 from Source to Aux1

          + T(N/2)  // Moving the remaining N/2 from Source to Destination using Aux2.

           + T(N/2)  // Moving N/2 from Aux1 to Destination.

                T(N) = 3*T(N/2)
                =O( 3 power log N base 2 )
                = O( N power log 3 base 2 )  // less than quadartic.*/
public class TowerOfHanoiwith4Rods {
    public static void main(String... args){

        int n=3;

        solve(n,'A','D','B','C');
    }

    static void solve(int n,char from_rod,char to_rod,char aux_rod1,char aux_rod2){

        if(n==0)
            return;
        if(n==1){
            System.out.println("Move disk " + n  + " " + from_rod + " " + to_rod);
            return;
        }
        solve(n-2,from_rod,aux_rod1,aux_rod2,to_rod);

        System.out.println("Move disk " + (n - 1) + " " + from_rod + " " + aux_rod2);
        System.out.println("Move disk " + n  + " " + from_rod + " " + to_rod);
        System.out.println("Move disk " + (n - 1) + " " + aux_rod2 + " " + to_rod);
        solve(n-2,aux_rod1,to_rod,from_rod,aux_rod2);


    }
}

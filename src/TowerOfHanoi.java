/**
 * Created by kaas0616 on 2018-03-05.
 */

/*
* T(N)= T(N-1) // Moving N-1 disks from Source to Auxilary
    + 1      // Moving Nth disk from Source to Destination
    + T(N-1) // Moving N-1 disks from Auxilary to Destination

     T(N) = 2*T(N-1) + 1

            = O(2 power N )   // exponential.*/
public class TowerOfHanoi {
    public static void main(String... args){

        int n=3;

        solve(n,'A','C','B');


    }

    static void solve(int n,char from_rod,char to_rod,char aux_rod){

        if(n==1){
            System.out.println("Move disk 1 from "+from_rod+" to "+to_rod);
            return;
        }

        solve(n-1,from_rod,aux_rod,to_rod);

        System.out.println("Move disk "+n+" from "+from_rod+" to "+to_rod);

        solve(n-1,aux_rod,to_rod,from_rod);
    }
}

package ArrayGeeks;

import java.util.Arrays;

public class secondLargest {
    public static void main(String... args) throws Exception{
        int a2[]= new int[10];
        a2[0]=1;
        System.out.println("a = " + Arrays.toString(a2));
        int a[] = {111, 2, 4,45, -7, 11};
        //int a1[]={1};
        int len = a.length;
        int Max1, Max2;

        if (len <= 1)
        {
            System.out.println("Only One element is present");
            throw new Exception();
        }

        //updating elements in Max1 and Max2

        if(a[1]>a[0]) {
            Max1 = a[1];
            Max2=a[0];
        }
        else{
            Max1 = a[0];
            Max2=a[1];
        }

        //Max1 will have first largest
        //Max2 will have second largest
        for (int i = 2; i < len ; i++)
        {
//if current is greatet Max1...then update both
            if (a[i] > Max1)
            {
                Max2 = Max1;
                Max1 = a[i];
            }
            //if element reapets that is highest dont consider to update for 2nd largest and if current is greater than max2 and not equals first max then update Max2
            else if (a[i] > Max2 ){
                if(a[i] != Max1)
                    Max2 = a[i];
            }
        }
        System.out.println("Max2 = " + Max2);

    }
}


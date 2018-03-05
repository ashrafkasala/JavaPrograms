package ArrayGeeks;


import java.util.Arrays;

/**
 * Created by kaas0616 on 2018-02-28.
 */
public class sprintsToandfro {

    public static void main(String... args){
        int n=5;
        int[] ip={1,3,4,2};

        int[] freq=new int[n+1];

        for(int i=0;i<freq.length;i++){
            freq[i]=0;
        }

        for(int i=0;i<ip.length-1;i++){


            int j2=ip[i+1];
            int i2=ip[i];
            if(j2>=i2) {
                while (j2 >= i2) {

                    freq[j2]++;
                    j2--;
                }
            }
            else{
//                int j2=ip[i+1];
//                int i2=i;
//                while(i2<=n){
//                    freq[ip[i2]]++;
//                    i2++;
//                }


                while(j2<=i2){
                    freq[j2]++;
                    j2++;
                }

            }


        }
        int max=Integer.MIN_VALUE;
        int maxIndex=0;
        for(int i=0;i<freq.length;i++){

            if(freq[i]>max){
                max=freq[i];
                maxIndex=i;
            }
        }

        System.out.println("max frequency "+max+"  index "+maxIndex);
        System.out.println(Arrays.toString(freq));

    }

}
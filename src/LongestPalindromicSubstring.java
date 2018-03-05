/**
 * Created by kaas0616 on 2018-03-01.
 */
public class LongestPalindromicSubstring {

    public static void main(String... args){
        String s="abccccdcaaaay";


        int start=0;
        int low=0,high=s.length()-1;
int maxlength=0;
        for(int i=1;i<s.length();i++){
            low=i-1;
            high = i+1;

            while(low>=0 && high <=s.length()-1 && s.charAt(low)==s.charAt(high)){

                if( high-low+1 >maxlength){
                    start=low;
                    maxlength=high-low+1;
                }

                low--;
                high++;
            }

            low=i-1;
            high =i;

            while(low>=0 && high <=s.length()-1 && s.charAt(low)==s.charAt(high) ){

                if(  high-low+1 >maxlength){
                    start=low;
                    maxlength=high-low+1;
                }

                low--;
                high++;
            }


        }

        System.out.println(start+"   "+maxlength);

        System.out.println(s.substring(start,start+maxlength));


    }
}

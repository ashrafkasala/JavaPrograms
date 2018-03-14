package ArrayGeeks;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaas0616 on 2018-03-13.
 */
public class DistinctPalindromicSubstrings {

    public static void main(String... args){

        String s="aabaa";
        Set<String> set = new HashSet<>();
        int start=0,end=0;
        int n=s.length();
        for(int i=0;i<s.length();i++){
            int oddLeft=i-1;
            int oddRight=i+1;
            //System.out.println(s.substring(i,1));
            set.add(String.valueOf(s.charAt(i)));
             while(oddLeft>=0 && oddRight<n){

                 if(s.charAt(oddLeft)==s.charAt(oddRight)){
                     System.out.println(s.substring(oddLeft,oddRight+1));
                     set.add(s.substring(oddLeft,oddRight+1));
                 }
                 else
                     break;
oddLeft--;
                 oddRight++;

             }

             int evenLeft=i;
             int evenright=i+1;

             while(evenLeft>=0 && evenright<n){

                 if(s.charAt(evenLeft)==s.charAt(evenright)){
                     System.out.println(s.substring(evenLeft,evenright+1));
                     set.add(s.substring(evenLeft,evenright+1));
                 }
                 else
                     break;
                 evenLeft--;
                 evenright++;

             }

             }

             System.out.println(set);

        }
    }


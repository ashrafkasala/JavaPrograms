package Strings;

import java.util.HashMap;

public class LongestNonRepeatedSubstring {
    public static void main(String... args){

        String s="geeksforgeeks";
        int maxL=Integer.MIN_VALUE,curL=1;
        int prevIndex;
        int[] visited= new int[256];


        visited[s.charAt(0)]=0;
        //visted array to store last repeated index
        for(int i=0;i<255;i++)
            visited[i]=-1;

        for(int i=1;i<s.length();i++){

            prevIndex=visited[s.charAt(i)];

            if(prevIndex==-1 || i-curL>prevIndex)
                curL++;
            else{

                if(curL>maxL)
                    maxL=curL;

                curL=i-prevIndex;


            }
            visited[s.charAt(i)]=i;

        }

        System.out.println(Math.max(curL,maxL));






        //approach 2:

        HashMap<Character,Integer> map=new HashMap<>();
        int j=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){

            if(map.containsKey(s.charAt(i)))
                j=Math.max(j,map.get(s.charAt(i))+1);

            map.put(s.charAt(i),i);
            max=Math.max(max,i-j+1);
        }

        System.out.println("max = " + max);



    }


}

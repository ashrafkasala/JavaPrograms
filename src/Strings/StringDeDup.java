package Strings;

import java.util.*;

public class StringDeDup {
    public static void main(String... args){

        String s="aaabbbaaacccdddccc";
       int chunkSize=3;
       List<String> chunks = new ArrayList<>();
        HashMap<String,LinkedList<Integer>> indexs= new HashMap();
       int count=0;
       for(int i=0;i<s.length();i=i+chunkSize){
 String chunk=s.substring(i,i+chunkSize);
           if(!indexs.containsKey(chunk)){

               LinkedList valueList = new LinkedList();
               valueList.add(0, count);
               indexs.put(chunk,valueList);
           }
           else{

               indexs.get(chunk).add(count);
           }
           count++;


       }


       System.out.println(indexs);

StringBuilder res = new StringBuilder();
        for (Map.Entry<String,LinkedList<Integer>> entry : indexs.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        res.append(entry.getKey());

            for(int i=0;i<entry.getValue().size();i++){
                res.append("#");

                res.append(entry.getValue().get(i));
            }
            res.append("-");
    }

    System.out.println(res);

String str= new String(res);
        String str1[]=str.split("-");
        HashMap<Integer,String> res2= new HashMap<>();
        for(int i=0;i<str1.length;i++){

            String str2[]=str1[i].split("#");


            for(int j=1;j<str2.length;j++){

                res2.put(Integer.parseInt(str2[j]),str2[0]);
            }

        }

        System.out.println(res2);
List<Integer> finalList = new ArrayList<>(res2.keySet());
        StringBuilder resFinal= new StringBuilder();
//        for (Map.Entry<Integer,String> entry : res2.entrySet()){
//
//            resFinal.append()
//        }


        Collections.sort(finalList);
        System.out.println(finalList);
        for(int i=0;i<finalList.size();i++){

            resFinal.append(res2.get(finalList.get(i)));
        }

        System.out.println(resFinal);

    }
}

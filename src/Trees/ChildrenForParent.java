package Trees;

import java.util.*;

public class ChildrenForParent {

    public static void main(String... args) {
        String s1 = "a manages b";
        String s2 = "a manages c";
        String s3 = "a manages d";
        String s4 = "b manages e";
        String s5 = "b manages f";
        String s6 = "c manages g";
        String s7=  "g manages h";

        //findLeaf()
        String[] data = {s1, s2, s3, s4, s5, s6,s7};
        List<String> Parentlist = new ArrayList<>();
        List<String> childList = new ArrayList<>();
        Hashtable<String, String> map = new Hashtable<>();
        ArrayList<String> adj[] = new ArrayList[data.length];

        Hashtable<String, Integer> res = new Hashtable<>();

//        for (Map.Entry<String, String> entry : map.entrySet())
//            res.put(entry.getKey(), -1);
        for (int i = 0; i < data.length; i++) {

            String str[] = data[i].split(" manages ");

            Parentlist.add(str[0]);
            childList.add(str[1]);
            if(!res.contains(str[0]))
            res.put(str[0],0);
            if(!res.contains(str[1]))
            res.put(str[1],0);

        }

        System.out.println(res);
        //find leaf nodes
//        List<String> leafList= new ArrayList<>();
//        for(int i=0;i<childList.size();i++){
//
//            if(!Parentlist.contains(childList.get(i))){
//                leafList.add(childList.get(i));
//            }
//        }

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//
//            if (!map.containsKey(entry.getValue())) {
//
//                //find Parent and increment count
//                res.put(entry.getKey(), res.get(entry.getKey()) + 1);
//                res.put(entry.getValue(), 0);
//                map.remove(entry.getKey());
//
//            }
//        }
List<Integer> removeIndices = new ArrayList<>();
System.out.println("childList "+childList);
        System.out.println("ParentList "+Parentlist);
        for(int i=0;i<childList.size();i++){

            if(!Parentlist.contains(childList.get(i))){

                res.put(Parentlist.get(i),res.get(Parentlist.get(i))+1);
                res.put(childList.get(i),-1);

//                childList.remove(i);
//                Parentlist.remove(i);
                removeIndices.add(i);

            }
        }

        System.out.println(removeIndices);

        for(int i=0;i<removeIndices.size();i++){
int rem=removeIndices.get(i)-i;
            childList.remove(rem);
                Parentlist.remove(rem);
        }
//        while (map.size() != 0) {
//
//
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                System.out.println("Parent Key = " + entry.getKey() +
//                        ", Value = " + entry.getValue());
//
//                if (res.get(entry.getKey()) != -1) {
//
//                    //find Parent and increment count
//                    res.put(entry.getKey(), res.get(entry.getKey()) + 1);
//                    map.remove(entry.getKey());
//
//                }
//
//
//            }
//
//        }

        System.out.println(res);
        System.out.println("childList "+childList);
        System.out.println("ParentList "+Parentlist);
        List<String> removeIndices2 = new ArrayList<>();
        removeIndices.clear();
        while(childList.size()!=0){

            for(int i=0;i<childList.size();i++){

                if(res.get(childList.get(i))!=-1 && res.get(childList.get(i))!=0){

                    res.put(Parentlist.get(i),res.get(Parentlist.get(i))+res.get(childList.get(i))+1);

                   removeIndices.add(i);
             // childList.remove(i);
               //   Parentlist.remove(i);


                }
            }

            for(int i=0;i<removeIndices.size();i++){
                int rem=removeIndices.get(i)-i;
                childList.remove(rem);
                Parentlist.remove(rem);
            }
            removeIndices.clear();

        }
        System.out.println("final result "+res);
        System.out.println(childList);
        System.out.println(Parentlist);
    }
}

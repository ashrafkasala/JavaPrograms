package Trees;

import java.util.*;

public class ChildrenForParent2 {

    public static void main(String... args) {
        String s1 = "a manages b";
        String s2 = "a manages c";
        String s3 = "a manages d";
        String s4 = "b manages e";
        String s5 = "b manages f";
        String s6 = "c manages g";

        //findLeaf()
        String[] data = {s1, s2, s3, s4, s5, s6};
        List<String> Parentlist = new ArrayList<>();
        List<String> childList = new ArrayList<>();
        Hashtable<String, String> map = new Hashtable<>();
        ArrayList<String> adj[] = new ArrayList[6];

        Hashtable<String, Integer> res = new Hashtable<>();

//        for (Map.Entry<String, String> entry : map.entrySet())
//            res.put(entry.getKey(), -1);
        for (int i = 0; i < data.length; i++) {

            String str[] = data[i].split("manages");

            map.put(str[0],str[1]);


        }

        System.out.println(map);
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


        for(int i=0;i<childList.size();i++){

            if(!Parentlist.contains(childList.get(i))){

                res.put(Parentlist.get(i),res.get(Parentlist.get(i)+2));
                res.put(childList.get(i),0);

                childList.remove(i);
                Parentlist.remove(i);

            }
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

        while(Parentlist.size()!=0){

            for(int i=0;i<Parentlist.size();i++){

                if(res.get(Parentlist.get(i))!=-1){

                    res.put(Parentlist.get(i),res.get(Parentlist.get(i)+1));
                    childList.remove(i);
                    Parentlist.remove(i);

                }
            }
        }
        System.out.println(res);
        System.out.println(childList);
        System.out.println(Parentlist);
    }
}

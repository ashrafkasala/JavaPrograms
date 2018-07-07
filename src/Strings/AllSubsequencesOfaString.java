package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllSubsequencesOfaString {
    public static void main(String[] args) {

        String s="abcd";
         findFitsAndAttractives();
        //findSubseq(s);
    }

    static void findSubseq(String s){
        ArrayList<String>  list = new ArrayList<>();

    }

    static void findFitsAndAttractives(){
        Scanner sc = new Scanner(System.in);

        int numOfNuts = sc.nextInt();
        int numOfBolts = sc.nextInt();

        int[] nutSizeArray = new int[numOfNuts];
        int[] nutTypeArray = new int[numOfNuts];

        int[] boltSizeArray = new int[numOfBolts];
        int[] boltTypeArray = new int[numOfBolts];
        HashMap<Integer,Integer> nutMap = new HashMap<>();
        HashMap<Integer,Integer> boltMap = new HashMap<>();


        for(int i=0;i<2*numOfNuts;i++){
            if(i%2==0){
                nutTypeArray[i/2]=sc.nextInt();
            }
            if(i%2 == 1){
                nutSizeArray[i/2]=sc.nextInt();
                nutMap.put(nutSizeArray[i/2],i/2);
            }


        }


        for(int i=0;i<2*numOfBolts;i++){
            if(i%2==0){
                boltTypeArray[i/2]=sc.nextInt();
            }
            if(i%2 == 1){
                boltSizeArray[i/2]=sc.nextInt();
                boltMap.put(boltSizeArray[i/2],i/2);
            }


        }

       int fitCount=0,attractiveCount=0;
        for(Map.Entry<Integer,Integer> entry:nutMap.entrySet()){

            if(boltMap.containsKey(entry.getKey())){
                fitCount++;
                if(boltTypeArray[entry.getValue()]==nutTypeArray[entry.getValue()])
                    attractiveCount++;
            }
        }


        System.out.println(fitCount +" "+attractiveCount);



    }
}

package Graphs;

import java.util.*;

public class NumberOfIslands {
    public static void main(String... args){
        int G[][]=  new int[][]
                {{1, 1, 0, 0, 0},
                 {0, 1, 0, 0, 1},
                 {1, 0, 0, 1, 1},
                 {0, 1, 0, 0, 0},
                 {1, 0, 1, 0, 1}
        };
        int size=0;
        int[][] visited=new int[G.length][G[0].length];
        for(int row=0;row<G.length;row++){
            for(int col=0;col<G[row].length;col++){

                visited[row][col]=0;

            }
        }

        for(int row=0;row<G.length;row++){
            for(int col=0;col<G[row].length;col++){

                if(G[row][col]==1 && visited[row][col]==0){

                    markConnectedOnes(G,visited,row,col);
                    size++;
                }

            }
        }

        System.out.println("no of islands  "+size);
    }


   static void markConnectedOnes(int[][] G,int[][] visited,int row,int col){

      Queue<String> Que=new ArrayDeque<>();

       visited[row][col]=1;

System.out.println(row+ " row  col  "+col);
       Que.add(findString(row,col));

       while(!Que.isEmpty()){
           System.out.println("Que peek "+Que.peek());
           String[] rowsCols=Que.peek().split(",");

           int row1= Integer.parseInt(rowsCols[0]);
           int col1=Integer.parseInt(rowsCols[1]);

           if(row1+1<G.length && G[row1+1][col1]==1) {
               Que.add(findString(row1+1,col1));
               visited[row1+1][col1]=1;
           }
           if(col1+1<G[0].length && G[row1][col1+1]==1){
               Que.add(findString(row1,col1+1));
               visited[row1][col1+1]=1;
           }
           if(row1+1<G.length && col1-1>=0 && G[row1+1][col1-1]==1 ){

               Que.add(findString(row1+1,col1-1));
               visited[row1+1][col1-1]=1;
           }

           if(row1+1<G.length && col1+1<G[0].length && G[row1+1][col1+1]==1 ){
               Que.add(findString(row1+1,col1+1));
               visited[row1+1][col1+1]=1;
           }
           Que.remove();

       }

    }

    static String findString(int row,int col){

        return String.valueOf(row)+","+String.valueOf(col);
    }
}

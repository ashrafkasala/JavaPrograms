/**
 * Created by kaas0616 on 2018-01-31.
 */
public class Dijkstras {
    static int V =9;
    boolean[] sptSet= new boolean[V];
   static int[] dist=new int[V];
    public static void main(String[] args){
        Dijkstras dj= new Dijkstras();
        int[][] graph={{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dj.shortest(graph,0);
        System.out.println("distance from sorce");
        for(int i=0;i<V;i++) {
            System.out.println("vertex   " +i+"  distance "+dist[i]);
        }
    }

    void shortest(int[][] graph,int src){



        for(int i=0;i<V;i++){
            sptSet[i]=false;
            dist[i]=Integer.MAX_VALUE;
        }


        dist[src]=0;
        for(int count=0;count<V;count++){

            int u =minDistanceVertex(dist,sptSet);
            sptSet[u]=true;
            for(int v=0;v<V;v++){

                if(!sptSet[v] && graph[u][v]!=0 && dist[u]+graph[u][v] < dist[v] && dist[u]!=Integer.MAX_VALUE ){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }
    }

    int minDistanceVertex(int[] dist,boolean[] sptSet){
        int min=Integer.MAX_VALUE;
        int minIndex=-1;

        for(int v=0;v<V;v++){
            if(sptSet[v]==false && dist[v]<min){
                min=dist[v];
                minIndex=v;
            }
        }
        return minIndex;
    }
}

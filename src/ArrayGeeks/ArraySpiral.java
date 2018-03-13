package ArrayGeeks;

public class ArraySpiral {
    static int count=0;
     static int[] rowD={0,1,0,-1};
     static int[] colD={1,0,-1,0};
    public static void main(String... args){
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        int rowEnding=a.length-1;
        int colEnding=a[0].length-1;

        int rowStart=0;
        int colStart=0;
        boolean first=true;
        while(rowStart<=rowEnding+1 && colStart<=colEnding+1){

           int[] dir= getDirection();
int r,c;

           for( r=rowStart, c=colStart;r<=rowEnding && c<=colEnding ;r=r+dir[0],c=c+dir[1]){

               System.out.print(a[r][c]+"  ");
           }
            System.out.println();

           if(first){
               if(count!=3){
                   colStart=c-1+colD[count];
                   rowStart=rowStart+rowD[count];
               }
               else {
                   rowStart=rowStart+rowD[0];
                   colStart = c - 1 + colD[0];
               }
               colEnding=colEnding-1;
               first=false;
           }
           else {

               if(count!=3){
                   colStart=colStart+colD[count];
                   rowStart=r-1+rowD[count];
               }
               else {
                   rowStart=r-1+rowD[0];
                   colStart = colStart + colD[0];
               }
               rowEnding--;
               first=true;
           }

        }

    }

    static int[] getDirection(){

        if(count==0){
            int dir[]={0,1};
            count++;
            return dir;
        }
        if(count==1){
            int dir[]={1,0};
            count++;
            return dir;
        }
        if(count==2){
            int dir[]={0,-1};
            count++;
            return dir;
        }
        if(count==3){
            int dir[]={-1,0};
            count=0;
            return dir;
        }

        return null;
    }
}

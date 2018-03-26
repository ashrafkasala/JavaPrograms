package ArrayGeeks;

public class SearchInROWColSorted {
    // driver program to test above function
    public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50} };

        search(mat, 48);
    }

    static void search(int[][] mat,int x){

        int col=mat[0].length-1;
        int row=0;
        while(col<mat.length && col>=0 &&row>=0 && row<mat.length){

            if(mat[row][col]==x)
            {
                System.out.println("found at "+row +"  "+col);
                break;
            }

            else if(mat[row][col]<x){

                row++;
            }
            else{
                col--;
            }


        }


    }
}

package ArrayGeeks;

public class MaximumSumRectangle {
public  static void main(String[] args) {
    int[][] rect=new int[][]{
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}};
    System.out.println("max sum"+findMaxRect(rect));

}

static  int findMaxRect(int[][] rect){
    int maxLeft,maxRight,maxUp,maxDown;
    int[] currRect;
    int maxSum=0;
    int kadaneSum;
    for(int L=0;L<rect[0].length;L++){
        currRect=new int[rect.length];
        for(int R=L;R<rect[0].length;R++){

            for(int i=0;i<rect.length;i++){
                currRect[i]+=rect[i][R];
            }
            kadaneSum = kadaneSum(currRect);
            if(kadaneSum>maxSum){
                maxSum=kadaneSum;
                maxLeft=L;
                maxRight=R;
            }

        }
    }
return maxSum;
}

static int kadaneSum(int[] currRect){
    int maxSum=Integer.MIN_VALUE;
    int max_so_far=Integer.MIN_VALUE;
    int max_ending_here=0;

    for(int i=0;i<currRect.length;i++){

        max_ending_here+=currRect[i];
        if(max_ending_here>max_so_far)
            max_so_far=max_ending_here;
        if(max_ending_here<0)
            max_ending_here=0;
    }
    return max_so_far;
}
}


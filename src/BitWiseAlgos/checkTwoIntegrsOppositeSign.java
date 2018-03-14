package BitWiseAlgos;

/**
 * Created by kaas0616 on 2018-03-13.
 */
public class checkTwoIntegrsOppositeSign {

    static boolean oppositeSigns(int x, int y)
    {
        return ((x ^ y) < 0);
    }

    public static void main(String[] args)
    {
        int x = -1100, y = -100;
        if (oppositeSigns(x, y) == true)
            System.out.println("Signs are opposite");
        else
            System.out.println("Signs are not opposite");
    }
}

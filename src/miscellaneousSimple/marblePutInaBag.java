package miscellaneousSimple;

public class marblePutInaBag {

    public  static void main(String args[]){
        String res="sdsa";
        res=insert(res,"aaa",1);

        System.out.println(res);
    }

    // put the marble in the bag
    public static String insert(String bag, String marble, int index) {
        String bagBegin = bag.substring(0,index);
        String bagEnd = bag.substring(index);
        return bagBegin + marble + bagEnd;
    }
}

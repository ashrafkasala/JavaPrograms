import java.util.HashSet;
import java.util.Set;

public class Test {
static  int i=1;
    public static void main(String[] args){
        String s1= new String("dos");
        String s2= new String("dos");
        Set<String> map = new HashSet();
        map.add(s1);
        map.add(s2);
        System.out.println(map.size());
        System.out.println("i = " + i);

    }
}

import java.util.HashMap;

/**
 * Created by kaas0616 on 2018-02-05.
 */

class key{
    String key;
    public key(String key){
        this.key=key;
    }

    @Override
    public int hashCode(){
        int hashcode = (int)key.charAt(0);
        System.out.println("hashCode for key: "
                + key +" = "+ hashcode);
        return hashcode;
    }

    @Override
    public boolean equals(Object obj){

        return key.equals(((key)obj).key);
    }
}

public class HashMapImple {

    public static void  main(String[] args){

        HashMap map=new HashMap();

        map.put(new key("Ashraf"),"143");

        System.out.println("value "+map.get(new key("Ashraf")));

                    }


}


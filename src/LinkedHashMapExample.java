import java.util.LinkedHashMap;
import java.util.Iterator;


public class LinkedHashMapExample
{


    public static void main(String[] args)
    {
        LinkedHashMap<String,String> premiumPhone = new LinkedHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            premiumPhone.put("Sony", "Xperia Z");
            System.out.println(premiumPhone.get(iterator.next()));

        }

    }

}
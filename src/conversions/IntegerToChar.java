package conversions;

public class IntegerToChar {

    public static void main (String args[]){
        int i = 1234;
        char[] chars = ("" + i).toCharArray();

        char[] chars2=String.valueOf(i).toCharArray();
        System.out.println(chars);
        System.out.println(chars2);

        int i2= Integer.parseInt(String.valueOf(chars));

        System.out.println(i2);

    }
}

package conversions;

public class StringToCharJava {

    public static void main(String[] args) {
        String str = "ashraf ashif";

        //string to char array
        char[] chars = str.toCharArray();
        System.out.println(chars.length);

        System.out.println(chars);

        //char at specific index
        char c = str.charAt(2);
        System.out.println(c);

        //Copy string characters to char array
        char[] chars1 = new char[7];
        str.getChars(0, 3, chars1, 0);
        System.out.println(chars1);


        //char array to String

        String text=String.valueOf(chars);
        System.out.println(text);

    }

}

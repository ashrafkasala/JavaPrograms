import java.util.List;

public class EncodingClass {


    public static void main(String[] args){
     doit("9 0123456789 oF8");
    }
    static void doit(String input){
        String[] words = input.split(" ");
        System.out.println(words.length);
        for(String word:words){
            System.out.println(word);
        }
    }
}

package Strings;

/**
 * Created by kaas0616 on 4/16/2018.
 */

/*
* convert(ashbrosashif,nrows=3)
*
* a     r   s
* s  b  o a h  f
* h     s   i
*
* o/p==arssboahfhsi
* */

public class ZigZagConversion {

    public static void main(String[] args) {
        String s="ashbrosashif";

        int len =s.length();
        int i=0;
        int rows=2;
        StringBuilder[] sb=new StringBuilder[rows];

        for(int index=0;index<rows;index++){
            sb[index]= new StringBuilder();
        }
        while(i<len){

            for(int index=0;index<rows;index++){

                sb[index].append(s.charAt(i));
                i++;
            }

            for(int index=rows-2;index>0;index--){
                sb[index].append(s.charAt(i));
                i++;
            }
        }

        for(int index=1;index<rows;index++){
            sb[0].append(sb[index]);
        }

        System.out.println("sb = " + sb[0].toString());
    }
}

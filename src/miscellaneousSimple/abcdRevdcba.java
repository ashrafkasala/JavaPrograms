package miscellaneousSimple;

public class abcdRevdcba {

    public static void main(String args[]){

        int flag=0;
        for(int a=0;a<=9;a++){
            for(int b=0;b<=9;b++){
                for(int c=0;c<=9;c++){
                    for(int d=0;d<=9;d++){

                        if(390*b+3999*a==996*d+60*c){

                            System.out.println(a+"  "+b+"  "+c+"  "+d );
                            flag++;

                        }
                    }
                    if(flag==2)
                        break;
                }
            }
            if(flag==2)
                break;
        }
    }
}

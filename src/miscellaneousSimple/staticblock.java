package miscellaneousSimple;



public class staticblock extends block2{
    static {
        System.out.println(" blockmain static ");
    }

    staticblock(){
        System.out.println(" blockmainconstrcutor ");
    }
    public static void main(String[] args) {

        staticblock bc = new staticblock();

    }
}

 class block2{
static int i=10;
    static {
        System.out.println(" block2 static "+i);
    }

    block2(){
        System.out.println(" block2  constructor ");
    }

}
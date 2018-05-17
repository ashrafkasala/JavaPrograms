package exam;

/**
 * Created by kaas0616 on 4/26/2018.
 */
public class Inheritance {

    public static void main(String[] args) {
        C c= new C();
        A a=(A) c;
        a.method();
        A a1= new C();
        a1.method2();
    }
}


class A{

    static void method(){
        System.out.println("In A static method");
    }
     void method2(){
        System.out.println("In A static method2");
    }
    public A(int a) {
        System.out.println("In A constructor");
    }
    public A(){}
}

class B extends A{
    public B(int b) {
        super(10);
        System.out.println("In B constructor");
    }
    public B(){

    }
    static void method(){
        System.out.println("In B static method");
    }
    void method2(){
        System.out.println("In B static method2");
    }

}

class  C extends B{

    public C() {

        System.out.println("In C constructor");
    }
    static void method(){
        System.out.println("In C static method");
    }
    void method2(){
        System.out.println("In C static method2");
    }
}
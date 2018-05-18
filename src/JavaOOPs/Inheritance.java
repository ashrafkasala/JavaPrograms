package JavaOOPs;

public class Inheritance {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.methodA1());
        A a = new C();
        System.out.println(a.methodA1());
        B b = new C();
        System.out.println(b.methodA1());

    }
}

class A{
A(int a){}
    String methodA1(){
        return "methodA1InA";
    }
    A(){}




}

class B extends A{
//B(int a){
//    super(1);
//}
    String methodA1(){
        return "methodA1InB";
    }
  //  B(){}
}

class C extends B{
    String methodA1(){
        return "methodA1InC";
    }

    String method2(){
        return "method2InC";
    }
}
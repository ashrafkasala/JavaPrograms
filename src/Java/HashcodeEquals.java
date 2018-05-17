package Java;

/**
 * Created by kaas0616 on 5/3/2018.
 */
public class HashcodeEquals {
    public static void main(String[] args) {
     Employee e1= new Employee(1);
     Employee e2 = new Employee(1);

        System.out.println(e1.equals(e2));
        System.out.println();
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
String s1=new String("ash");
        String s2=new String("ash");

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

class Employee{
    int id;
    Employee(int id){
        this.id=id;
    }
}
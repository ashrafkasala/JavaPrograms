/**
 * Created by kaas0616 on 2018-02-07.
 */


    class Parent
    {
        public void display()
        {
            System.out.println("parent");
        }
    }

    class Child extends Parent//Class Child extends Parent(in case of Java Lang.)
    {
        public void display()
        {
            System.out.println("Child");
        }

    }

    class ParentChildRefrences
    {
        public static void main(String[] args)
        {
            Child aChild = new Child();
            Parent aParent = new Parent();
            Parent p2= new Child();
            p2.display();
            //Child c2=new Parent();
            aParent = aChild;// its valid.
            //aChild = aParent;// its not valid. Why?
        }
    }



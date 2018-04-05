package Trees;

/**
 * Created by kaas0616 on 4/5/2018.
 */
public class LCAPostorder {

    static Node root;
    static boolean f1=false,f2=false;
    public static void main(String[] args)
    {
        LCAPostorder tree = new LCAPostorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
    //    System.out.println(findLCAPostOrder(root,2,3).data);
       // System.out.println(findLCAPostOrder(root,2,6).data);
        //System.out.println(findLCAPostOrder(root,2,4).data);
        Node res=findLCAPostOrder(root,7,1);
if(f1==true && f2==true)
       System.out.println(res.data);
else
    System.out.println("not found");
    }

   static Node findLCAPostOrder(Node node,int a,int b){

        if(node==null)
        return null;



        Node left= findLCAPostOrder(node.left,a,b);
        Node right=findLCAPostOrder(node.right,a,b);

       if(node.data==a){
           f1=true;
           return node;
       }else if(node.data==b)
       {
           f2=true;
           return node;
       }
       else if(left!=null && right!=null)
        {
            System.out.println("root = LCA" + node.data);
            return node;
        }
        else if(left ==null && right==null)
            return null;

       else if(left!=null)
           return left;
       else if(right!=null)
           return right;

       return null;
   }
}

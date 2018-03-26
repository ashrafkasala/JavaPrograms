package Trees;

public class IsSymmetricTree {
    static Node root;
    public static void main(String[] args)
    {
        IsSymmetricTree tree = new IsSymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);


        System.out.println(IsSymmetricTree(root.left,root.right));
    }

    static boolean IsSymmetricTree(Node n1,Node n2){

        if (n1==null && n2==null)
            return true;
        if(n1==null || n2== null)
            return false;


        return n1.data==n2.data && IsSymmetricTree(n1.left,n2.right) && IsSymmetricTree(n1.right,n2.left);
    }
}

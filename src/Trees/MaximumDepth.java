package Trees;

/**
 * Created by kaas0616 on 3/28/2018.
 */
public class MaximumDepth {
    static Node root;
    static int max=0;
    public static void main(String[] args)
    {
        MaximumDepth tree = new MaximumDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(73);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);


        System.out.println(findMaximumDepth(root,0));
        System.out.println("max = " + max);
    }
    static  int findMaximumDepth(Node node,int d){
        if(node==null){
            return 0;
        }

        if(d>max)
            max=d;
      findMaximumDepth(node.left,d+1);
       findMaximumDepth(node.right,d+1);

        return max;
    }

}

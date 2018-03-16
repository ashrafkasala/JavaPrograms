package Trees;

public class HeightOfatree {
    static Node root;
    public static void main(String[] args)
    {
        HeightOfatree tree = new HeightOfatree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);


        System.out.println(findHeight(root.right));
    }
    static  int findHeight(Node node){
        if(node==null){
            return 0;
        }

        int lHeight=findHeight(node.left);
        int rheight=findHeight(node.right);

        return Math.max(lHeight,rheight)+1;
    }

}

package Trees;

public class LongestPathIntree {
    static Node root;
    static int maxvalue=0;
    public static void main(String[] args)
    {
        LongestPathIntree tree = new LongestPathIntree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.left.left = new Node(5);
        tree.root.right.left.left.left = new Node(5);
        tree.root.right.right = new Node(4);


        System.out.println(findLength(root));
        System.out.println("maxvalue = " + maxvalue);
    }
    static int findLength(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return 1;
        }


        int leftHeight=findLength(root.left);
        int rightHeight=findLength(root.right);
if(leftHeight+rightHeight+1 >maxvalue)
        maxvalue=leftHeight+rightHeight+1;

        return Math.max(leftHeight,rightHeight)+1;
    }
}

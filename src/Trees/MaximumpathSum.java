package Trees;

public class MaximumpathSum {
    static Node root;
    static int maxValue=Integer.MIN_VALUE;
    public static void main(String[] args)
    {
        MaximumpathSum tree = new MaximumpathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(10);


        System.out.println(findMaximumPathSum(root));
        System.out.println("maxValue = " + maxValue);
    }
    static int findMaximumPathSum(Node root){
        if(root==null)
            return 0;

        int leftsum=findMaximumPathSum(root.left);
        int rightsum=findMaximumPathSum(root.right);

        maxValue=Math.max(maxValue,leftsum+rightsum+root.data);

        return Math.max(leftsum,rightsum)+root.data;

    }
}

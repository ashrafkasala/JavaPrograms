package Trees;

import java.util.ArrayList;

public class LeafPathSumEqualsGivenSum {
    static Node root;
    static int givenSum=17;
    static ArrayList<String> res= new ArrayList<>();
    //static int sum=Integer.MIN_VALUE;
    public static void main(String[] args)
    {
        LeafPathSumEqualsGivenSum tree = new LeafPathSumEqualsGivenSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(10);


        if(findPathSum(root,0,"")==111)
            System.out.println(" possible");
        else
            System.out.println("Not possible");

        // leaf paths
       System.out.println("all possible leaf paths = " + res);
    }
    static int findPathSum(Node root,int sum,String path){
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
        {
            if(sum+root.data==givenSum) {
                path+="->"+String.valueOf(root.data);
                res.add(path);
                System.out.println("found at" + root.data);
            }

        }
else {
             findPathSum(root.left, sum + root.data,path+"->"+String.valueOf(root.data));
             findPathSum(root.right, sum + root.data,path+"->"+String.valueOf(root.data));

        }
        return   111;

    }
}

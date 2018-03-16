package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSum {
    static Node root;
    public static void main(String[] args)
    {
        MaximumLevelSum tree = new MaximumLevelSum();
        tree.root = new Node(1);
        tree.root.left = new Node(42);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);


        System.out.println(findMaximumLevel(root));
    }

    static int findMaximumLevel(Node node){

        Queue<Node> q1=new ArrayDeque(),q2=new ArrayDeque();
        int maxsumsoFar=0;
        int max=Integer.MIN_VALUE;

        q1.add(node);

        while(!q1.isEmpty() || !q2.isEmpty()){
            maxsumsoFar=0;

            while(!q2.isEmpty()){
                Node tempNode= q2.peek();
                q2.remove();

                if(tempNode.left!=null)
                    q1.add(tempNode.left);
                if(tempNode.right!=null){
                    q1.add(tempNode.right);
                }

                maxsumsoFar+=tempNode.data;

            }
            if(maxsumsoFar>max)
                max=maxsumsoFar;

maxsumsoFar=0;
            while(!q1.isEmpty()){
                Node tempNode= q1.peek();
                q1.remove();

                if(tempNode.left!=null)
                    q2.add(tempNode.left);
                if(tempNode.right!=null){
                    q2.add(tempNode.right);
                }

                maxsumsoFar+=tempNode.data;

            }


            System.out.println(maxsumsoFar);
            if(maxsumsoFar>max)
                max=maxsumsoFar;

        }
        return max;
    }

}

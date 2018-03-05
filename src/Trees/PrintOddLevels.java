package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintOddLevels {
static Node root;
    public static void main(String... args){
        PrintOddLevels tree=new PrintOddLevels();
  tree.root=new Node(1);
  tree.root.left=new Node(2);
  tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);

        printInOddLevels(root);


    }

   static void printInOddLevels(Node root){

        if(root==null)
            return;

       Queue<Node> q = new ArrayDeque<Node>();
       boolean odd= true;
       q.add(root);
       while(true){

           int nodeCount=q.size();

           if(nodeCount==0){
               break;
           }

           while (nodeCount >0){

               int data=q.peek().data;

               if(odd)
                   System.out.println(data);
               if(q.peek().left !=null)
                   q.add(q.peek().left);
               if(q.peek().right!=null)
                   q.add(q.peek().right);

               q.remove(q.peek());

               nodeCount--;
           }

           odd =!odd;


       }




    }
}

//class Node{
//    int data;
//    Node left,right;
//
//    Node(int item){
//        data=item;
//        left=right=null;
//    }
//
//
//}

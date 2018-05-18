package Trees;

import java.util.ArrayList;
import java.util.List;


/**
 * ALgo :  1,find path of n1 and n2
 *        2, traverse and find last common element in both paths...thats the ancestor
 *        3,
 *        Bonus problem
 *
 *        DISTANCE BETWEEN TWO NODES : --> height of n1+ height of n2 - 2 * height of ancestor
 */
public class LCA {
    static Node root;
    static int LCA=Integer.MAX_VALUE;
    static List<Integer> path1 = new ArrayList<>();
    static List<Integer> path2 = new ArrayList<>();
    public static void main(String[] args)
    {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);


        System.out.println(findLCA(root,6,2));

        findLCA2(root,6,2);
        System.out.println("LCA = " + LCA);
    }

    static int findLCA(Node node,int n1,int n2){

        if(!findPath(node,n1,path1) || !findPath(node,n2,path2)) {
            System.out.println(path1+"-----------   "+path2);
            System.out.println("elements are missing..............");
            return -1;
        }
        System.out.println(path1+"-----------   "+path2);
        int i;
        for( i=0;i<path1.size() && i<path2.size();i++){

            if(!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    static boolean findPath(Node node,int n,List<Integer> path){

        if(node==null)
        return false;
        path.add(node.data);
        if(node.data==n)
            return true;

        if(node.left!=null && findPath(node.left,n,path))
            return true;
        if(node.right!=null && findPath(node.right,n,path))
            return true;

        path.remove(path.size()-1);
        return false;
    }

    static boolean findLCA2(Node root,int n1,int n2){

        if(root==null)
            return false;


        boolean leftR=findLCA2(root.left,n1,n2);
        boolean rightR=findLCA2(root.right,n1,n2);
        if(root.data==n1 || root.data ==n2)
            return true;
        if( leftR && (root.data==n1 || root.data==n2)) {
            if(LCA==Integer.MAX_VALUE)
            LCA = root.data;
        }
       else if( rightR && (root.data==n1 || root.data==n2))
        {
            if(LCA==Integer.MAX_VALUE)
                LCA = root.data;
        }
       else if(leftR &&  rightR) {
            if(LCA==Integer.MAX_VALUE)
                LCA = root.data;
        }

        return leftR || rightR;

    }
    
}

package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kaas0616 on 2018-03-26.
 */
public class PrintAllLeafPaths {
    static Node root;
    static int count=0;
    static ArrayList<String> res= new ArrayList<>();
    public static void main(String[] args)
    {
       // String[] res={};
        String path="";
        PrintAllLeafPaths tree = new PrintAllLeafPaths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

//StringBuilder resB= new StringBuilder();
        //System.out.println(findPaths(root,res,path));
        findPaths(root,path);
        System.out.println(res);
    }

   static void findPaths(Node root,String path){

        if(root==null)
            return;
        if(root.left==null && root.right==null){


            res.add(path+"->"+root.data);
return;
        }

            System.out.println(root.data);
            findPaths(root.left, path + "->" + String.valueOf(root.data) );
            findPaths(root.right, path + "->" + String.valueOf(root.data));

            System.out.println(res);

   }
}

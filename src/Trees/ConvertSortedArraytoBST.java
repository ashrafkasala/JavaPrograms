package Trees;

import java.util.HashMap;
import java.util.Hashtable;

public class ConvertSortedArraytoBST {

    public static void main(String[] args) {
Integer check ;
        Hashtable k;
        HashMap k2;
        int[] a={1,2,3,4,5,6,7};

       Node node= convertBST(a,0,a.length-1);

       DoInorder(node);
    }

    static Node convertBST(int[] a,int low,int high){

        Node node=null;

        if(low<high){

            int mid=(low+high)/2;

            node=new Node(a[mid]);

            node.left=convertBST(a,low,mid);
            node.right=convertBST(a,mid+1,high);
        }
        return node;
    }

    static void DoInorder(Node node){

        if(node==null)
            return;

        DoInorder(node.left);
        System.out.println(node.data);
        DoInorder(node.right);
    }
}

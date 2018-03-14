package Trees;

/**
 * Created by kaas0616 on 2018-03-08.
 */
public class InorderSuccesor {

    public static void main(String... args){
        NodeBST  root =null;
        root =insert(root,2);
        insert(root,5);
        insert(root,1);
        insert(root,10);
        insert(root,-19);
        NodeBST temp2=insert(root,6);
       // System.out.println("Inrder successor of "+temp2.data );
        NodeBST node =InorderSuccesorOf(temp2);
      //  System.out.println("Inrder successor of " +node.data);
        System.out.println("Inrder successor of "+temp2.data +"  is  "+node.data);

    }

    static NodeBST InorderSuccesorOf(NodeBST node){


        if(node.right!= null)
            return findMin(node.right);
        NodeBST par=node.parent;
        while(par !=null && par.right==node){
            node=par;
            par=par.parent;
        }

        return par;
    }

    static NodeBST findMin(NodeBST node){

        while(node.left!=null)
            node=node.left;

        return node;
    }
    static NodeBST insert(NodeBST node,int data){


        if(node==null)
            return new NodeBST(data);

        else {
            if (data <= node.data) {
                NodeBST  temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
               // return temp;
            } else {

                NodeBST temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
               // return temp;
            }
        }
        return node;
    }

}

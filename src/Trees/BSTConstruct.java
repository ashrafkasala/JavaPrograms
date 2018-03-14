package Trees;

/**
 * Created by kaas0616 on 2018-03-08.
 */
public class BSTConstruct {
static NodeBST root1;
    public static void main(String... args){
        NodeBST  root =null;
         root =insert(root,2);
          insert(root,5);
        insert(root,1);
        insert(root,10);
        insert(root,-19);
        insert(root,6);
        InorderTraversal(root);

    }


    static NodeBST insert(NodeBST node,int data){


        if(node==null)
            return new NodeBST(data);

else {
            if (data <= node.data) {
                NodeBST temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {

                NodeBST temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
        }
        return node;
    }

    static void InorderTraversal(NodeBST root){

        if(root==null)
            return ;

        InorderTraversal(root.left);
        System.out.print("  "+root.data+"  ");
        InorderTraversal(root.right);

    }
}



class NodeBST{
    NodeBST left,right,parent;
    int data;
    NodeBST(int data){
        this.data=data;
        left=right=parent=null;
    }

}

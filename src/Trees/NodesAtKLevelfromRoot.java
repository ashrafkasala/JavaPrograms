package Trees;

/**
 * Created by kaas0616 on 2018-03-26.
 */
public class NodesAtKLevelfromRoot {
    static Node root;
    public static void main(String[] args) {
        NodesAtKLevelfromRoot tree = new NodesAtKLevelfromRoot();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
         tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
int k=1;
        findNodesAtLevel(root,k,0);
    }

    static void findNodesAtLevel(Node root,int k,int level){

        if(root==null)
            return;
        if(level==k)
            System.out.println(root.data);

        findNodesAtLevel(root.left,k,level+1);
        findNodesAtLevel(root.right,k,level+1);
    }


}

package Trees;

/**
 * Created by kaas0616 on 4/5/2018.
 */
public class LCAByDistanceDFS {
    static Node root;
    static boolean f1=false,f2=false;
    static int dis=0;
    public static void main(String[] args) {
        LCAByDistanceDFS tree = new LCAByDistanceDFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.parent=tree.root;
        tree.root.right = new Node(3);
        tree.root.right.parent=tree.root;
        tree.root.left.left = new Node(4);
        tree.root.left.left.parent=tree.root.left;
        tree.root.left.right = new Node(5);
        tree.root.left.right.parent=tree.root.left;
        tree.root.right.left = new Node(6);
        tree.root.right.left.parent=  tree.root.right;
        tree.root.right.right = new Node(7);
        tree.root.right.right.parent= tree.root.right;

        //    System.out.println(findLCAPostOrder(root,2,3).data);
        // System.out.println(findLCAPostOrder(root,2,6).data);
        //System.out.println(findLCAPostOrder(root,2,4).data);
        Node res = findLCAByDistance(root, tree.root.left, tree.root.right.right);
    }

    static Node findLCAByDistance(Node root,Node node1,Node node2){
dis=0;
        getDistance(root,node1,0);
        int d1=dis;
        getDistance(root,node2,0);
        int d2=dis;
        System.out.println("d2 = " + d2);
        System.out.println("d1 = " + d1);
        findLCAByDistanceUtil(node1,node2,d1,d2);
        return null;
    }

    static void  findLCAByDistanceUtil(Node node1,Node node2,int d1,int d2){
        if(d1==d2){
            if(node1==node2){
                System.out.println("LCA 1= " + node1.data);
            }else if(node1.parent==node2.parent){
                System.out.println("LCA 2= " + node1.parent.data);
            }
        }
        else if(d1>d2){
            findLCAByDistanceUtil(node1.parent,node2,d1-1,d2);
        }
        else{
            findLCAByDistanceUtil(node1,node2.parent,d1,d2-1);
        }
    }
    static int getDistance(Node root,Node node,int d){
        if(root==null)
            return 0;

        if(root==node){
            dis=d;
            return d;
        }
        getDistance(root.left,node,d+1);
        getDistance(root.right,node,d+1);

        return d;
    }
}

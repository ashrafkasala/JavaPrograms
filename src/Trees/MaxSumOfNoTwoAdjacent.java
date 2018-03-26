package Trees;

import java.util.HashMap;

/**
 * Created by kaas0616 on 2018-03-15.
 */
public class MaxSumOfNoTwoAdjacent {
    static Node root;
    public static void main(String[] args) {
        MaxSumOfNoTwoAdjacent tree = new MaxSumOfNoTwoAdjacent();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(1);
       // tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

        findMaxSum(root);
        System.out.println(findMaxSum(root).getSum1()+"   "+findMaxSum(root).getSum2());
    }


    static MyPair findMaxSum(Node node){

        if(node==null){

            MyPair pair =new MyPair(0,0);
            return pair;

        }

        MyPair sum1=findMaxSum(node.left);
        MyPair sum2=findMaxSum(node.right);

        MyPair sum = new MyPair(0,0);

        sum.setSum1(sum1.getSum2()+sum2.getSum2()+node.data);
        sum.setSum2(Math.max(sum1.getSum1(),sum1.getSum2())+Math.max(sum2.getSum1(),sum2.getSum2()));

return sum;
    }
}

 class MyPair
{
   int sum1;
   int sum2;


    public MyPair(int sum1, int sum2) {
        this.sum1 = sum1;
        this.sum2 = sum2;
    }

    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }
}

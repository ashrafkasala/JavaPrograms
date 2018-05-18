package ArrayGeeks;



public class AlternateKillingPuzzle {
    static LinkedListNode head;
    static LinkedListNode last;
    public static void main(String[] args) {
        int N=100;

        AlternateKillingPuzzle cir= new AlternateKillingPuzzle();
        //solution 1
        // j(2n)=2 j(n)-1----> for even
        // j(2n+1)=2j(n)+1-----> for odd
        //n= total number of assasins
        // j(n+2^(k))=2n+1-->N=n+2^(k)

        //solution 1
        System.out.println(findByFormula(N));


        //solution 2
        //create circular linked list and initate data to 1
        head=null;
        for(int i=N;i>=1;i--) {


            LinkedListNode temp= new LinkedListNode(i);
            if(i==N)
                last=temp;
            temp.next=head;
            head= temp;
        }

        last.next=head;

        System.out.println( findLastSaved(head));

    }

    static int findByFormula(int N){
        int power;
        int n=1;
        for(int i=0;i<N;i++){
            power=(int)Math.pow(2,i);

            if(power>N){
                power=(int)Math.pow(2,i-1);
                 n=N-power;
                break;
            }
        }
         return 2*n+1;
    }

    static int findLastSaved(LinkedListNode node){
        LinkedListNode nextnode;
        while(true){
            nextnode=findNextAlive(node);
           if( nextnode==null) {
               break;
           }
           nextnode.data=0;
           node=findNextAlive(nextnode);
        }
         return node.data;
    }

   static  LinkedListNode findNextAlive(LinkedListNode node){
        LinkedListNode temp=node;
        boolean flag=false;
        while(true){
            node=node.next;
            if(node==temp) {
                flag = false;
                break;
            }
            if(node.data!=0){
                flag = true;
                break;
            }
        }

        if(flag)
            return node;
        else
            return null;
   }
}

class LinkedListNode{
    int data;
    LinkedListNode next;
    public LinkedListNode(int data) {
        next=null;
        this.data=data;
    }
}
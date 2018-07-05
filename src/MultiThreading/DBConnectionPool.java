package MultiThreading;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by kaas0616 on 5/23/2018.
 */
public class DBConnectionPool {
    public static void main(String[] args) {
        TreeMap map;
        DBConnections db = new DBConnections();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                        db.createConnection();
                    db.closeConnection();

                }
                catch(Exception e){}
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    db.createConnection();
                    db.closeConnection();

                }
                catch(Exception e){}
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    db.createConnection();
                    db.closeConnection();

                }
                catch(Exception e){}
            }
        });
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    db.createConnection();
                    db.closeConnection();

                }
                catch(Exception e){}
            }
        });

        Thread t5=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    db.createConnection();
                    db.closeConnection();

                }
                catch(Exception e){}
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class DBConnections{
    ArrayList<Integer> list = new ArrayList<>();
    int k=5;
    int i=0;
     void createConnection(){

         synchronized (this) {
             if (list.size() < k) {
                 list.add(i);
                 i++;
                 System.out.println("i in create = " + i);
                 notify();
             } else {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
    }

     void closeConnection() {

         synchronized (this) {
             if (list.size() > 0) {
                 list.remove(i);
                 i--;
                 System.out.println("i in close = " + i);
                 notify();
             } else {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}
//import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by uvangapa on 11/3/2017.
 */



class Ratings {
    String driverName;
    int driverRating;
    String customerName;
    int customerRating;

    Ratings(String driverName, int dirverRating, String customerName,  int customerRating) {

        if(dirverRating > 5 || dirverRating < 1 )
            throw new IllegalArgumentException("invalid rating given for driver");

        if(customerRating > 5 || customerRating < 1 )
            throw new IllegalArgumentException("invalid rating given for customer");

        this.driverName=driverName;
        this.customerName=customerName;
        this.driverRating=dirverRating;
        this.customerRating=customerRating;
    }

}

class DriverSort implements Comparator<Ratings> {

    public int compare(Ratings r1, Ratings r2) {
        return r1.driverName.compareTo(r2.driverName);
    }
}


class CustomerSort implements Comparator<Ratings> {

    public int compare(Ratings r1, Ratings r2) {
        return r1.customerName.compareTo(r2.customerName);
    }
}


class Customer {
    String customerName;
    float customerAvgRating;

    Customer (String cName, float cAvgRagting) {
        this.customerName=cName;
        this.customerAvgRating=cAvgRagting;
    }
}

class Driver {
    String driverName;
    float driverAvgRating;
    boolean online;

    Driver (String dName, float dAvgRating, boolean online) {
        this.driverName=dName;
        this.driverAvgRating=dAvgRating;
        this.online=online;
    }


}




public class DriverCustomerRating {

    float avgCustomerRating(String cName, ArrayList<Customer> cList) {

        float acr=-1;
        for( Customer c : cList) {
            if(c.customerName.equals(cName))
                acr = c.customerAvgRating;
            //System.out.println( c.customerName+ " " + c.customerAvgRating);
        }
        return acr;
    }

    void setDriveroffline(String dName, ArrayList<Driver> dList) {
        for(Driver d : dList) {
            if(d.driverName.equals(dName))
                d.online=false;
        }
    }


    void setDriveronline(String dName, ArrayList<Driver> dList) {
        for(Driver d : dList) {
            if(d.driverName.equals(dName))
                d.online=true;
        }
    }

    boolean checkElegibility(String cName,String dName, ArrayList<Ratings> pList ) {

        boolean flag=false;
        for(Ratings r3 : pList) {
            if(cName==r3.customerName && dName == r3.driverName && r3.driverRating!=1 && r3.customerRating!=1 )
                flag = true;
        }
        return flag;
    }

    void eligibleDriverNames(String cName, ArrayList<Customer> cList,
                             ArrayList<Driver> dList, ArrayList<Ratings> pList) {

        float acr = 0;
        int count = 0;
        acr = avgCustomerRating(cName, cList);

        for (Driver d : dList) {
            if (acr < d.driverAvgRating) {
                if (checkElegibility(cName, d.driverName, pList) && d.online) {
                    System.out.println(d.driverName + " " + d.driverAvgRating);
                    count++;
                }
            }
        }

       /* if (count == 0) {
            for (Ratings r4 : pList) {
                if (r4.customerName == cName && checkElegibility(cName, r4.driverName, pList) && )
                    System.out.println(r4.driverName);

            }
        } */
    }
    public static void main(String args[]) {

        ArrayList<Ratings> personList = new ArrayList<Ratings>();

        ArrayList<Driver> driverList = new ArrayList<Driver>();

        ArrayList<Customer> customerList = new ArrayList<Customer>();



        Ratings r = new Ratings("d1",4,"c1",5);
        personList.add(r);
        r = new Ratings("d1",5,"c2",4);
        personList.add(r);
        r = new Ratings("d1",1,"c3",2);
        personList.add(r);
        r = new Ratings("d2",5,"c1",1);
        personList.add(r);
        r = new Ratings("d2",5,"c2",5);
        personList.add(r);
        r = new Ratings("d2",4,"c3",5);
        personList.add(r);
        r = new Ratings("d3",3,"c1",2);
        personList.add(r);
        r = new Ratings("d3",4,"c2",5);
        personList.add(r);
        r = new Ratings("d3",3,"c3",3);
        personList.add(r);

        DriverSort dSort = new DriverSort();
        Collections.sort(personList, dSort);

        int count =0;
        int size =personList.size();
        while( count < size) {
            float avgDriverRating=0;
            int driverRidesCount=0;
            String tempName= personList.get(count).driverName;
            while (count < size && personList.get(count).driverName == tempName ) {
                avgDriverRating = avgDriverRating + personList.get(count).driverRating;
                count ++;
                driverRidesCount++;
            }
            avgDriverRating=avgDriverRating/driverRidesCount;

            Driver d = new Driver(tempName,avgDriverRating,true);
            driverList.add(d);
        }

        CustomerSort cSort = new CustomerSort();
        Collections.sort(personList, cSort);

       /* for( Ratings r1 : personList) {
            System.out.println(r1.customerName + " " + r1.customerRating + " " + r1.driverName + " " + r1.driverRating);
        }*/

        count =0;
        while(count < size ) {
            float avgCustomerRating=0;
            int customerRidesCount=0;
            String tempName= personList.get(count).customerName;
            while ( count < size && personList.get(count).customerName == tempName ) {
                avgCustomerRating = avgCustomerRating + personList.get(count).customerRating;
                count ++;
                customerRidesCount++;
            }
            avgCustomerRating=avgCustomerRating/customerRidesCount;
            Customer c = new Customer(tempName,avgCustomerRating);
            customerList.add(c);
        }

       /* for( Driver d : driverList) {
            System.out.println(d.driverName + " " + d.driverAvgRating);
        }*/

        //System.out.println("Agerage Rating of a customer is");
       /* for( Customer c : customerList) {
            System.out.println( c.customerName+ " " + c.customerAvgRating);
        } */

        DriverCustomerRating uVan = new DriverCustomerRating();

        System.out.println(uVan.avgCustomerRating("c1",customerList));

        //uVan.setDriveroffline("d1",driverList);
        //uVan.setDriveroffline("d3",driverList);



        uVan.eligibleDriverNames("c1" +
                "",customerList,driverList,personList);



    }
}

package compression.Huffman;

//import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

import java.util.Scanner;




/**
 6
 * Demonstrates how to generate MD5 hash using Java
 7
 * @author JJ
8
 */

public class MD5HashGenerator {



    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        System.out.print("Please enter data for which MD5 is required:");

        String data = sn.nextLine();



        MD5HashGenerator sj = new MD5HashGenerator();

    //    String hash = sj.getMD5Hash(data);

       // System.out.println("The MD5 (hexadecimal encoded) hash is:"+hash);

    }



        /**
         22
         * Returns a hexadecimal encoded MD5 hash for the input String.
         23
         * @param data
        24
         * @return
        25
         */

    private String getMD5Hash(String data) {

        String result = null;

        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");

            byte[] hash = digest.digest(data.getBytes("UTF-8"));

            return bytesToHex(hash); // make it printable

        }catch(Exception ex) {

            ex.printStackTrace();

        }

        return result;

    }

        /**
         39
         * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
         40
         * to a hexadecimal string. Note that this generates hexadecimal in upper case.
         41
         * @param hash
        42
         * @return
        43
         */

    private String  bytesToHex(byte[] hash) {
return null;

        //return DatatypeConverter.printHexBinary(hash);

    }
}


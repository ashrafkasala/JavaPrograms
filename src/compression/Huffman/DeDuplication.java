package compression.Huffman;


import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.zip.Checksum;

public class DeDuplication {
    public Hashtable<String, String> indexTable = new Hashtable<String,String>();
    //public Checksum sum;
   // public FileList list;
   // public int count;
    private FileInputStream fis;
    private  FileOutputStream fos;

    public static void main (String args[]){
        DeDuplication dd = new DeDuplication();
        File file=new File("C:\\Users\\ashru\\Desktop\\huffman.txt");
        dd.encode(file);
    }

    public void encode(File file) {
        // Read each file and perform fixed-size chunking
        byte[] chunk = new byte[10];

        byte[] bfile = readBytesFromFile("C:\\Users\\ashru\\Desktop\\huffman.txt");
System.out.println("bfile"+bfile.length);
            if (file.isFile() && !file.isHidden()) {
                // Read file into a byte array and use SHA-1 hash the chunk
                try {
                    fis = new FileInputStream(file.getAbsolutePath());
                    while (fis.read(chunk) != -1) {
                        // perform the hash on the chunk
                        String hashvalue = getMD5(chunk.toString());

                        System.out.println("hashvalue   "+hashvalue);
                        // If not exist then save
                        if (!indexTable.containsKey(hashvalue)) {
                            indexTable.put(hashvalue, file.getName());
                        } else {
                            System.out.println(
                                     " duplicate contents found in: "
                                    + file.getName());
                        }
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println(indexTable.toString());
        }

    public static String getMD5(String input) {
        try {
            System.out.println("input   "+input);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

    }


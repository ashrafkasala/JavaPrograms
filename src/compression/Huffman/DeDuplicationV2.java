package compression.Huffman;


import javafx.beans.binding.IntegerBinding;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class DeDuplicationV2 {

    //public Checksum sum;
    // public FileList list;
    // public int count;
    private FileInputStream fis;
    private FileOutputStream fos;

    public static void main(String args[]) {
        DeDuplicationV2 dd = new DeDuplicationV2();
        File file = new File("C:\\Users\\ashru\\Desktop\\huffman.txt");
        dd.encode(file);
        dd.decode();
    }

    public void encode(File file) {
         Hashtable<String, String> indexTable = new Hashtable<String, String>();
         Hashtable<String, LinkedList<Integer>> indexTable2 = new Hashtable<String, LinkedList<Integer>>();
         Hashtable<String, String> HashChunkTable = new Hashtable<String,String>();
        // Read each file and perform fixed-size chunking
        byte[] bfile = readBytesFromFile("C:\\Users\\ashru\\Desktop\\huffman.txt");
        System.out.println("bfile" + bfile.length);
//        for(int i=0){
//
//        }

        int offset = 0;
        int fileCounter = 0;
        int count = 0;
        int chunksize = 43;
        int chunkCount=0;
        HashChunkTable.put("chunkSize",String.valueOf(chunksize));

        while (offset < bfile.length - chunksize) {
            chunkCount++;
            byte[] outputBytes;

//            if(bfile.length - offset < 500 ) {
//                outputBytes = new byte[bfile.length - offset];
//                System.arraycopy(bfile, offset, outputBytes, 0, bfile.length - offset);
//                //saveFile(outputBytes , fileCounter++);
//                break;
//            }

            outputBytes = new byte[chunksize];
            System.arraycopy(bfile, offset, outputBytes, 0, chunksize);
            String hashvalue = getMD5(new String(outputBytes));
            //System.out.println("outputBytes.toString()   " + new String(outputBytes));
            //    System.out.println("hashvalue   "+hashvalue);
            // If not exist then save
            count++;
            if (!indexTable2.containsKey(hashvalue)) {

                LinkedList valueList = new LinkedList();
                valueList.add(0, count);
                indexTable2.put(hashvalue, valueList);
                HashChunkTable.put(hashvalue, new String(outputBytes));
            } else {

                indexTable2.get(hashvalue).add(indexTable2.get(hashvalue).size(), count);
//                LinkedList tempValueList=indexTable2.get(hashvalue);
//                tempValueList.add(tempValueList.size(),count);
//                indexTable2.put(hashvalue,tempValueList);
            }
            offset += chunksize;
            // saveFile(outputBytes , fileCounter++);
            //Thread.sleep(3000);
            System.out.println("offset  " + offset);
        }

        HashChunkTable.put("chunkCount",String.valueOf(chunkCount));
        System.out.println("indexTable2   " + indexTable2.toString());
        System.out.println("HashChunkTable   " + HashChunkTable.toString());

        try {
//            RandomAccessFile raf = new RandomAccessFile("c:/test.txt", "rw");
//            fos = new FileOutputStream(indexTable2);
//            out = new ObjectOutputStream(fos);
//            out.writeObject(sspsrpData);

            ArrayList<Hashtable> woi=new ArrayList<>();
            //serialize
                FileOutputStream fop=new FileOutputStream("e://object1.txt");
                ObjectOutputStream oos=new ObjectOutputStream(fop);
                woi.add(indexTable2);
                woi.add(HashChunkTable);
                oos.writeObject(woi);
             //desrialize




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public static String getMD5(String input) {
        try {
            //    System.out.println("input   "+input);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
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


    void decode (){

        Hashtable<String, LinkedList<Integer>> indexTable2 = new Hashtable<String, LinkedList<Integer>>();
        Hashtable<String, String> HashChunkTable = new Hashtable<String, String>();

        //desrialize
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("e://object1.txt");

            ObjectInputStream ois = null;

            ois = new ObjectInputStream(fis);

            Hashtable wo = null;
            Hashtable[] woj = new Hashtable[5];

            ArrayList<Hashtable> woi2 = new ArrayList<>();
            woi2 = (ArrayList<Hashtable>) ois.readObject();

//            for (int i = 0; i < woi2.size(); i++) {
//
//                System.out.println("desrialize " + woi2.get(i).toString());
//            }
            indexTable2 = woi2.get(0);
            HashChunkTable = woi2.get(1);
            System.out.println("index table  "+indexTable2);
            System.out.println("HashChunkTable  "+HashChunkTable);
            int chunkSize= Integer.parseInt(HashChunkTable.get("chunkSize"));
            int chunkCount=Integer.parseInt(HashChunkTable.get("chunkCount"));
            String[] res = new String[chunkCount];

            Set<String> keys = indexTable2.keySet();
            for(String key: keys){
                System.out.println("Value of "+key+" is: "+indexTable2.get(key));
                LinkedList<Integer> indexsOfChunk = indexTable2.get(key);


                for (int i = 0; i < indexsOfChunk.size(); i++) {
                    System.out.println(indexsOfChunk.get(i));

                    int IndexToPutChunk=indexsOfChunk.get(i);

                    res[IndexToPutChunk-1]=HashChunkTable.get(key);

                }

            }

            System.out.println("result  "+Arrays.toString(res));

            // Create our BufferedWriter.
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "e:\\decoded.txt"));

            // Loop over the elements in the string array and write each line.
            for (String line : res) {
                writer.write(line);
                // writer.newLine();
            }
            writer.close();
//            FileOutputStream buf = new FileOutputStream(new File ("E:\\decoded.txt"));
//            ObjectOutputStream oos = new ObjectOutputStream(buf);
//
//            oos.writeObject(res);  // Write the String array to a file
//            oos.close();

        }
         catch(FileNotFoundException e){
                e.printStackTrace();
            }
             catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}


package compression.Huffman;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * DECODE CLASS
 * This class takes a Huffman Encoded file, decodes it into text, and creates a new file from the decoded text.
 * @author Rob Whitaker
 * @version 0.0.2
 */
public class Decode {

    /**
     * main - decodes a .huf file and writes the output to a new file
     * @param args the file to read and the file to write, respectively
     */
    public static void main(String[] args) {
//        String inputFile = null;
//        String outputFile = null;
//        if(args.length > 1) {
//            inputFile = args[0];
//            outputFile = args[1];
//        } else return;

        FileInputStream fin = null;

        try {
            byte[] fileContent;

            //read in the file
            File inFile = new File("C:\\Users\\ashru\\Desktop\\huffmanencoded.txt");
            fin = new FileInputStream(inFile);
            fileContent = new byte[(int)inFile.length()];
            fin.read(fileContent);
            fin.close();

            //decode the file into text
            HuffmanNode huffmanTree = generateHuffmanTree(fileContent);
            String result = decodeHuffmanFile(fileContent, huffmanTree);

            //write the decoded file
            File outFile = new File("C:\\Users\\ashru\\Desktop\\huffmandecoded.txt");
            FileOutputStream fop = new FileOutputStream(outFile);
            fop.write(result.getBytes());
        } catch (Exception e) {
            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    /**
     * Given a huffman tree and an array of bytes, decodes the bytes into text
     * @param fileContent the array of bytes to decode
     * @param huffmanTree the huffman tree needed to decode the bytes
     * @return the decoded string
     */
    private static String decodeHuffmanFile(byte[] fileContent, HuffmanNode huffmanTree) {
        int k = fileContent[0] & 0xFF;
        int index = 1 + k*2;
        StringBuilder str = new StringBuilder();

        HuffmanNode currentNode = huffmanTree;
        Character lastChar = 'x';
        int bitIndex = 0;
        while(lastChar != '\u0000' && index < fileContent.length) {
            int currentBit = fileContent[index] >> (7 - bitIndex) & 1;
            currentNode = (currentBit == 1) ? currentNode.getOne() : currentNode.getZero();

            if(currentNode.isLeafNode()) {
                lastChar = currentNode.getValue();
                if(lastChar != '\u0000') {
                    str.append(currentNode.getValue());
                    currentNode = huffmanTree;
                }
            }

            bitIndex++;
            if(bitIndex >= 8) {
                index++;
                bitIndex = 0;
            }
        }

        return str.toString();
    }

    /**
     * Generates a huffman tree from a byte array (read from file)
     * @param byteArray the byte array to generate the tree from
     * @return the root node of the generated huffman tree
     */
    public static HuffmanNode generateHuffmanTree(byte[] byteArray) {
        int k = byteArray[0] & 0xFF; //number k characters in alphabet
        int maxDepth = byteArray[2] & 0xFF;
        for(int i=1; i<=k*2; i+=2)
            if((byteArray[i+1] & 0xFF) > maxDepth) maxDepth = (byteArray[i+1] & 0xFF);

        class CharList extends ArrayList<Character> {}
        CharList[] charsAtDepth = new CharList[maxDepth+1];

        for(int i=1; i<=k*2; i+=2) {
            int depth = byteArray[i + 1] & 0xFF;
            if(charsAtDepth[depth] == null) charsAtDepth[depth] = new CharList();
            charsAtDepth[depth].add((char) (byteArray[i] & 0xFF));
        }

        for(CharList list : charsAtDepth)
            if(list != null) Collections.sort(list);

        int depth = 1;
        HuffmanNode huffmanTree = new HuffmanNode();
        HuffmanNode[] lastNodes = {huffmanTree};
        while(depth <= maxDepth) {
            ArrayList chars = charsAtDepth[depth++];
            HuffmanNode[] currentNodes = new HuffmanNode[lastNodes.length*2];

            for(int i=currentNodes.length-1; i>=0; i--) {
                if(chars != null && chars.size() > 0)
                    currentNodes[i] = new HuffmanNode((Character) chars.remove(chars.size()-1), null, null);
                else
                    currentNodes[i] = new HuffmanNode();
            }

            int cNodeIndex = currentNodes.length-1;
            for(int i=lastNodes.length-1; i>=0; i--) {
                if(lastNodes[i] != null && lastNodes[i].getValue() == null) {
                    lastNodes[i].setZero(currentNodes[cNodeIndex-1]);
                    lastNodes[i].setOne(currentNodes[cNodeIndex]);
                    cNodeIndex -= 2;
                }
            }

            ArrayList<HuffmanNode> prunedCurrentNodes = new ArrayList<HuffmanNode>();
            for(HuffmanNode node : currentNodes)
                if(node != null) prunedCurrentNodes.add(node);
            lastNodes = prunedCurrentNodes.toArray(new HuffmanNode[prunedCurrentNodes.size()]);
        }

        return huffmanTree;
    }
}

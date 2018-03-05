package compression.Huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 * ENCODE CLASS
 * This class takes a text file and encodes it into a Huffman Encoded file.
 * @author Rob Whitaker
 * @version 0.0.1
 */
public class Encode {
    public static void main(String[] args) {
//        //read terminal args
//        String inputFile = null;
//        String outputFile = null;
//        if (args.length > 1) {
//            inputFile = args[0];
//            outputFile = args[1];
//        } else return;

        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\ashru\\Desktop\\huffman.txt");

            ArrayList<Character> charArr = new ArrayList<Character>();
            HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
            int maxCharCount = -1;
            int totalCharFreq = 0;

            //read file and count freq of each char in a hashmap
            int c;
            while ((c = fin.read()) != -1) {
                totalCharFreq++;
                char ch = (char) c;
                charArr.add(ch);
                if (charCounts.get(ch) != null)
                    charCounts.put(ch, charCounts.get(ch) + 1);
                else
                    charCounts.put(ch, 1);

                if (charCounts.get(ch) > maxCharCount) maxCharCount = charCounts.get(ch);
            }
            charArr.add('\u0000');
            charCounts.put('\u0000', 1);
            totalCharFreq++;

            class NodeList extends ArrayList<HuffmanNode> {}
            NodeList[] orderedChars = new NodeList[totalCharFreq + 1];
            for(Map.Entry<Character,Integer> item : charCounts.entrySet()) {
                if (orderedChars[item.getValue()] == null)
                    orderedChars[item.getValue()] = new NodeList();

                orderedChars[item.getValue()].add(new HuffmanNode(item.getKey(), null, null));
            }

            HuffmanNode carryOverNode = null;
            int carryOverFreq = -1;
            for(int i=0; i<=totalCharFreq; i++) {
                if(orderedChars[i] == null) continue;
                NodeList nodeList = orderedChars[i];

                while(nodeList.size() > 0) {
                    if (carryOverNode != null) {
                        HuffmanNode snd = nodeList.remove(0);
                        if(orderedChars[i+carryOverFreq] == null) orderedChars[i+carryOverFreq] = new NodeList();
                        orderedChars[i + carryOverFreq].add(new HuffmanNode(null, carryOverNode, snd));
                        carryOverFreq = -1;
                        carryOverNode = null;
                    } else if (nodeList.size() == 1) {
                        carryOverNode = nodeList.remove(0);
                        carryOverFreq = i;
                    } else {
                        HuffmanNode first = nodeList.remove(0);
                        HuffmanNode snd = nodeList.remove(0);
                        if(orderedChars[i*2] == null) orderedChars[i*2] = new NodeList();
                        orderedChars[i * 2].add(new HuffmanNode(null, first, snd));
                    }
                }
            }

            byte[] treeAsByteArray = new byte[charCounts.size() * 2 + 1];
            treeAsByteArray[0] = (byte) charCounts.size();

            Stack<HuffmanNode> currentStack = new Stack<HuffmanNode>();
            currentStack.push(carryOverNode);
            Stack<HuffmanNode> nextStack = new Stack<HuffmanNode>();

            int depth = 0;
            int byteArrIndex = 1;
            while(!currentStack.empty()) {
                HuffmanNode cNode = currentStack.pop();
                if(cNode.isLeafNode()) {
                    treeAsByteArray[byteArrIndex] = (byte) ((char) cNode.getValue());
                    treeAsByteArray[byteArrIndex+1] = (byte) depth;
                    byteArrIndex += 2;
                } else {
                    if(cNode.getZero() != null)
                        nextStack.push(cNode.getZero());
                    if(cNode.getOne() != null)
                        nextStack.push(cNode.getOne());
                }

                if(currentStack.empty()) {
                    depth++;
                    currentStack = nextStack;
                    nextStack = new Stack<HuffmanNode>();
                }
            }

            HuffmanNode canonicalTree = Decode.generateHuffmanTree(treeAsByteArray);
            HashMap<Character,String> pathMap = new HashMap<Character, String>();
            getCharPaths(canonicalTree, pathMap, "");

            int bitCount = 0;
            ArrayList<Byte> outputByteArray = new ArrayList<Byte>();
            for(Character ch : charArr) {
                char[] chArr = pathMap.get(ch).toCharArray();
                for(char cNum : chArr) {
                    if(outputByteArray.isEmpty() || bitCount / 8 >= outputByteArray.size()) outputByteArray.add((byte) 0);
                    int num = Integer.parseInt(cNum + "");
                    byte valAtIndex = outputByteArray.get(bitCount / 8);
                    outputByteArray.set(bitCount / 8, (byte) ((valAtIndex << 1) + num));
                    bitCount++;
                }
            }

            outputByteArray.set(bitCount / 8, (byte) (outputByteArray.get(bitCount / 8) << (bitCount % 8)));

            for(int i=0; i<treeAsByteArray.length; i++)
                outputByteArray.add(i,treeAsByteArray[i]);

            byte[] result = new byte[outputByteArray.size()];
            for(int i=0; i<outputByteArray.size(); i++) result[i] = outputByteArray.get(i);

            //write the decoded file
            File outFile = new File("C:\\Users\\ashru\\Desktop\\huffmanencoded.txt");
            FileOutputStream fop = new FileOutputStream(outFile);
            fop.write(result);
        } catch(Exception e) {
            System.out.println("err");
            e.printStackTrace();
        }
    }

    /**
     * Get binary path to char based on a Huffman Tree
     * @param node the root node of the source Huffman Tree
     * @param map the HashMap to write the Character-Path pairs into
     * @param path the current path
     */
    private static void getCharPaths(HuffmanNode node, HashMap<Character,String> map, String path) {
        if(node == null) return;
        if(node.isLeafNode())
            map.put(node.getValue(), path);
        else {
            getCharPaths(node.getZero(), map, path+"0");
            getCharPaths(node.getOne(), map, path+"1");
        }
    }
}
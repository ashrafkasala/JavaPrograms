package compression.Huffman;

/**
 * HUFFMAN NODE CLASS
 * A simple binary tree class to represent a node in a Huffman Tree
 */
public class HuffmanNode {
    private Character value = null;
    private HuffmanNode zero = null, one = null;

    /**
     * Default contructor
     */
    public HuffmanNode() {}

    /**
     * Parameterized constructor
     * @param value character stored in node
     * @param zero left branch node
     * @param one right branch node
     */
    public HuffmanNode(Character value, HuffmanNode zero, HuffmanNode one) {
        this.value = value;
        this.zero = zero;
        this.one = one;
    }

    /**
     * Checks whether or not the node is a leaf node
     * @return true if it is a leaf node, false otherwise
     */
    public boolean isLeafNode() {
        return value != null && zero == null && one == null;
    }

    /**
     * value field getter
     * @return Character value
     */
    public Character getValue() {
        return value;
    }

    /**
     * value field setter
     * @param value Character value
     */
    public void setValue(Character value) {
        this.value = value;
    }

    /**
     * zero field getter
     * @return HuffmanNode of zero branch
     */
    public HuffmanNode getZero() {
        return zero;
    }

    /**
     * zero field setter
     * @param zero HuffmanNode for zero branch
     */
    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    /**
     * one field getter
     * @return HuffmanNode of one branch
     */
    public HuffmanNode getOne() {
        return one;
    }

    /**
     * one field setter
     * @param one HuffmanNode for one branch
     */
    public void setOne(HuffmanNode one) {
        this.one = one;
    }
}

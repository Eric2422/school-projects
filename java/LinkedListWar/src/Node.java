public class Node {
    // data stored in this node
    private E data;

    // the previous node
    private Node previousNode;

    // the next node
    private Node nextNode;


    /*
     * no argument constructor or doubly linked node
     * nextNode, and data are all set to null
     */
    public Node() {
        previousNode = null;
        nextNode = null;
        data = null;
    }

    /*
     * constructor for a doubly-linked node
     * accepts an Object, a node, and another node
     * as a data value, previous, and next respectively
     */
    public Node(E data, Node previousNode, Node nextNode) {
        this.data = data;

        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node node) {
        this.previousNode = node;
    }
}
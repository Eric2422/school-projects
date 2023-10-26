public class Node<E> {
    // data stored in this node
    private E data;

    // the next node
    private Node<E> nextNode;

    /*
     * no argument constructor or doubly linked node
     * nextNode, and data are all set to null
     */
    public Node() {
        nextNode = null;
        data = null;
    }

    /*
     * constructor for a doubly-linked node
     * accepts an Object, a node, and another node
     * as a data value, previous, and next respectively
     */
    public Node(E data, Node nextNode) {
        this.data = data;

        this.nextNode = nextNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> node) {
        this.nextNode = node;
    }
}
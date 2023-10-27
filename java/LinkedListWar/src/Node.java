public class Node<E> {
    // data stored in this node
    private E data;

    // the previous node
    private Node<E> previousNode;

    // the next node
    private Node<E> nextNode;


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
    public Node(E data, Node<E> previousNode, Node<E> nextNode) {
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

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> node) {
        this.nextNode = node;
    }

    public Node<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<E> node) {
        this.previousNode = node;
    }
}
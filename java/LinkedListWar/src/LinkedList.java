import java.util.List;

public class LinkedList<E> implements List<E> {
    // first node in the LinkedList
    private Node<E> headNode;
    // last node in linkedList
    private Node<E> tailNode;
    private int listSize;

    // inner node class
    class Node<E> {
        // data stored in this node
        private E data;

        private Node<E> previousNode;
        private Node<E> nextNode;
        
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

        /*
         * no argument constructor or doubly linked node
         * previousNode, nextNode, and data are all set to null
         */
        public Node() {
            previousNode = null;
            nextNode = null;
            data = null;
        }
    }

    public LinkedList() {
        headNode = new Node<E>();
        tailNode = headNode;
        listSize = 0;
    }

    /**
     * Adds the object x to the end of the list.
     * 
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(E x) {
        // create a newNode that is attached after tailNode
        Node<E> newNode = new Node<>(x, tailNode, null);
        // set it as the new tailNode
        tailNode = newNode;
        // increase listSize
        listSize++;

        return true;
    }

    /**
     * Adds the object x at the specified position
     * 
     * @param index the position to add the element
     * @param x     the element to be added to the list
     * @return true if the operation succeeded, false otherwise
     * @throws IllegalArgumentException if index is invalid
     */
    public boolean add(int index, E x) {
        if (index < listSize) {
            Node<E> temp = headNode;

            for (int i=0; i<index-1; i++) {
                temp = temp.nextNode;
                return true;
            } 
        }
        throw IllegalArgumentException("Invalid index");

        return false;
    }

    /**
     * Returns the number of elements in this list
     * 
     * @return the number of elements in this list
     */
    public int size() {
        return listSize;
    }

    /**
     * Returns the element with the specified position in this list
     * 
     * @param index the position of the element
     * @return the element at the specified position in this list
     * @throws IllegalArgumentException if index is invalid
     */
    public E get(int index) {
        return null; // TODO: replace with working code
    }

    /**
     * Replaces the object at the specified position
     * 
     * @param index the position to replace
     * @param x     the element to be stored
     * @return the previous value of the element at index
     * @throws IllegalArgumentException if index is invalid
     */
    public E set(int index, E x) {
        return null; // TODO: replace with working code
    }

    /**
     * Removes the object at the specified position
     * 
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArgumentException if index is invalid
     */
    public E remove(int index) {
        return null; // TODO: replace with working code
    }

    /**
     * Tests if this list has no elements.
     * 
     * @return <tt>true</tt> if this list has no elements;
     *         <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
        return listSize == 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this List is to be tested.
     * @return <code>true</code> if the specified element is present;
     *         <code>false</code> otherwise.
     */
    public boolean contains(Object element) {
        Node<E> temp = headNode;

        while (temp.nextNode != null) {
            if (temp == element) {
                return true;
            }

            temp = temp.nextNode;
        }

        return false;
    }

    /**
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, or -1 if it is not contained
     *         within the list
     */
    public int indexOf(Object element) {
        return 0; // TODO: replace with working code

    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this;
    }

    @Override
    public 
}
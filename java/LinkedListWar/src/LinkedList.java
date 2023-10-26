public class LinkedList<E> implements List<E> {
    // first node in the LinkedList
    private Node<E> headNode;

    // last node in LinkedList
    private Node<E> tailNode;

    // number of elements in this LinkedList
    private int listSize;

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
        Node<E> newNode = new Node<>(x, null);

        // set it as the new tailNode
        tailNode.setNextNode(newNode);

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
        // if the index is valid,
        // add the element
        if (index < listSize) {
            // start at the headNode
            Node<E> temp = headNode;

            // traverse to one before the node at the index
            for (int i=0; i<index-1; i++) {
                temp = temp.getNextNode();
            }
            
            // create a new node that stores x
            // insert it between temp and the next node
            Node<E> newNode = new Node<>(x, temp.getNextNode());

            // set temp's nextNode to newNode
            temp.setNextNode(newNode);

            return true;
        }

        // else throw an Exception
        throw new IllegalArgumentException("Invalid index");
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
        // start at the headNode
        Node<E> temp = headNode;
        
        // traverse through the LinkedList nodes
        for (int i=0; i<index; i++) {
            temp = temp.getNextNode();
        }

        return temp.getData();
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
        // start at the headNode
        Node<E> temp = headNode;
        
        // traverse through the LinkedList nodes
        for (int i=0; i<index; i++) {
            temp = temp.getNextNode();
        }

        // replace the data with x
        E replacedData = temp.getData();
        temp.setData(x);

        // return the old data
        return replacedData;
    }

    /**
     * Removes the object at the specified position
     * 
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArgumentException if index is invalid
     */
    public E remove(int index) {
        // if the index is valid,
        // remove the element
        if (index < listSize) {
            // start at the headNode
            Node<E> temp = headNode;

            // traverse to one before the node at the index
            for (int i=0; i<index-1; i++) {
                temp = temp.getNextNode();
            }

            // set temp.nextNode to the node two after
            temp.setNextNode(temp.getNextNode().getNextNode());
        }

        // else throw an Exception
        throw new IllegalArgumentException("Invalid index");
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
    public boolean contains(E element) {
        // start at the head
        Node<E> temp = headNode;

        // loop through the entire LinkedList
        while (temp.getNextNode() != null) {
            // if the data in the LinkedList == element
            if (temp.getData() == element) {
                return true;
            }

            // else go to the nextNode
            temp = temp.getNextNode();
        }

        // if the loop has finished without finding element,
        // return false
        return false;
    }

    /**
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, or -1 if it is not contained
     *         within the list
     */
    public int indexOf(E element) {
        // count the index
        int index = 0;

        // start at the head
        Node<E> temp = headNode;

        // loop through the entire LinkedList
        while (temp.getNextNode() != null) {
            // if the data in the LinkedList == element
            if (temp.getData() == element) {
                return index;
            }

            // else go to the nextNode
            temp = temp.getNextNode();
            index++;
        }

        // if the loop has finished without finding element,
        // return -1
        return -1;
    }
}
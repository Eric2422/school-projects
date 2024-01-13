public class LinkedList implements List {
    // first node in the LinkedList
    private Node headNode;

    // last node in LinkedList
    private Node tailNode;

    // number of elements in this LinkedList
    private int listSize;

    public LinkedList() {
        headNode = new Node();
        tailNode = headNode;
        listSize = 0;
    }

    /**
     * Adds the object x to the end of the list.
     * 
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(Card x) {
        // create a newNode that is attached after tailNode
        Node newNode = new Node(x, tailNode, null);

        if (tailNode != null) {
            tailNode.setNextNode(newNode);
        } 

        // if the list is empty
        // set it as the headNode
        if (listSize == 0) {
            headNode = newNode;
        }

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
    public boolean add(int index, Card x) {
        // if it is valid 
        if (index < listSize) { 
            // start at the headNode
            Node temp = headNode;

            // traverse to one before the node at the index
            for (int i=0; i<index-1; i++) {
                temp = temp.getNextNode();
            }
            
            // create a new node that stores x
            // insert it between temp and the next node
            Node newNode = new Node(x, temp, temp.getNextNode());

            // set temp's nextNode to newNode
            temp.setNextNode(newNode);

            // increment listsize
            listSize++;

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
    public Card get(int index) {
        // start at the headNode
        Node temp = headNode;

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
    public Card set(int index, Card x) {
        // start at the headNode
        Node temp = headNode;
        
        // traverse through the LinkedList nodes
        for (int i=0; i<index; i++) {
            temp = temp.getNextNode();
        }

        // replace the data with x
        Card replacedData = temp.getData();
        temp.setData(x);

        // return the old data
        return replacedData;
    }

    /*
     * Remove the first node in the list
     * Return its data
     */
    private Card removeFirst() {
        Card removedData = headNode.getData();

        // set the second node as head node
        headNode = headNode.getNextNode();

        listSize--;

        // if the list contains one or no nodes
        if (listSize <= 1) {
            tailNode = headNode;
        }

        return removedData;
    }

    /*
     * Remove the last node
     * Return its data
     */
    private Card removeLast() {
        // get data of last node
        Card removedData = tailNode.getData();

        // set tailNode to the second-to-last node
        tailNode = tailNode.getPreviousNode();

        // set tailNode.nextNode to null
        tailNode.setNextNode(null);

        // reduce listSize
        listSize --;

        // return data from removedData
        return removedData;
    }

    /**
     * Removes the object at the specified position
     * 
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArgumentException if index is invalid
     */
    public Card remove(int index) {
        // if index is 0
        if (index == 0) {
            // remove and return first node
            return removeFirst();

        } else if (index == listSize - 1) { // if index is the last
            return removeLast();

        } else if (index < listSize) { // if the index is valid but not the end node
            // start at the headNode
            Node temp = headNode;

            // traverse to one before the node at the index
            for (int i=0; i<index-1; i++) {
                temp = temp.getNextNode();
            }

            // store the data to be removed
            Card removedData = temp.getNextNode().getData();

            // set the previousNode of the node two after to temp
            temp.getNextNode().getNextNode().setPreviousNode(temp);

            // set temp.nextNode to the node two after
            temp.setNextNode(temp.getNextNode().getNextNode());

            // if temp is the last(i.e. it points to null)
            // set it as tailNode
            if (temp.getNextNode() == null) {
                tailNode = temp;
            }

            // decrement listSize
            listSize--;

            // return the removedData
            return removedData;
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
    public boolean contains(Card element) {
        // start at the head
        Node temp = headNode;

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
    public int indexOf(Card element) {
        // count the index
        int index = 0;

        // start at the head
        Node temp = headNode;

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

    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.add(new Card(Card.ACE, Card.SPADES));
        l.add(new Card(2, Card.DIAMONDS));
        l.add(new Card(3, Card.HEARTS));
        l.add(new Card(4, Card.CLUBS));

        for (int i = 3; i >= 0; i--) {
            System.out.println(l.get(i));
        }
    }
}
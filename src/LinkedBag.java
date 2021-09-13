/** An implementation of the ADT bag using a linked chain */

public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;     // Reference to first node
    private int numEntries;     // number of nodes in linked chain

    // Default constructor
    public LinkedBag() {
        firstNode = null;
        numEntries = 0;   
    }

    
    /** Gets the number of entries in the bag.
     * @return int The integer number of entries in the bag.
     */ 
    @Override
    public int getCurrentSize() {

        return numEntries;
    }

    
    /** Determines whether this bag is empty.
     * @return boolean True if the bag is empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        
        return numEntries == 0;
    }

    
    /** Adds new entry to the linked chain.
     * @param newEntry The object being added as a new entry.
     * @return boolean True if add was successful.
     */
    @Override
    public boolean add(T newEntry) {

        Node newNode = new Node(newEntry);  // New entry created
        newNode.next = firstNode;           // New Node referrences chain
        
        firstNode = newNode;                // New Node is the first Node
        numEntries++;                       // Increment number of entries

        return true;
    }

    
    /** Removes the first Node in the chain, if possible.
     * @return T Either the removed entry, if the removal was
     *           sucessful, or null.
     */
    @Override
    public T remove() {
        if (firstNode != null) {

            Node removedNode = firstNode;
            firstNode = removedNode.next;

        }
        return null;
    }

    
    /** 
     * @param anEntry
     * @return boolean
     */
    @Override
    public boolean remove(T anEntry) {
        
        return false;
    }

    @Override
    public void clear() {
        
        
    }

    
    /** 
     * @param anEntry
     * @return int
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        
        return 0;
    }

    
    /** 
     * @param anEntry
     * @return boolean
     */
    @Override
    public boolean contains(T anEntry) {
        
        return false;
    }

    
    /** Gets all the entries that are in this bag.
     * @return T[] A new array that contains all the entries of this bag.
     */
    @Override
    public T[] toArray() {

        @SuppressWarnings("unchecked")   
        T[] bagArray = (T[])new Object[numEntries];

        int index = 0;
        Node currentNode = firstNode;
        while((index < numEntries) && (currentNode != null )) {
            bagArray[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        
        return bagArray;
    }

    
    /** 
     * @param bagUnion
     * @return T
     */
    @Override
    public T union(T bagUnion) {
        
        return null;
    }

    
    /** 
     * @param bagIntersection
     * @return T
     */
    @Override
    public T intersection(T bagIntersection) {
        
        return null;
    }

    
    /** 
     * @param bagDifference
     * @return T
     */
    @Override
    public T difference(T bagDifference) {
        
        return null;
    }

    
    // Member inner class Node for linked data
    private class Node {
        
        private T data;             // Data of the node
        private Node next;          // Reference to the next Node in chain

        // Default constructor
        private Node(T nodeData) {
            this(nodeData, null);   // Passes params to full contructor 
        }

        // More complete constructor that sets Node data
        private Node(T nodeData, Node nextNode) {
            data = nodeData;
            next = nextNode;
        }

    }
    
}

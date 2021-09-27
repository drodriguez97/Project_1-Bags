/* An implementation of the ADT bag using a linked chain */

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
     *           sucessful, or null if it was not.
     */
    @Override
    public T remove() {
        if (firstNode != null) {

            Node removedNode = firstNode;
            firstNode = removedNode.next;
            numEntries--;
        }
        return null;
    }

    
    /** Removes one occurence of a given entry from this bag.
     * @param anEntry The entry to be removed.
     * @return boolean True if entry was removed, or false otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        Node nodePrevious = null;
        Node currentNode = firstNode;
        Node tempNode = null;

        int index = 0;

        while((index < numEntries) && (currentNode != null)) {
            if (currentNode.data == anEntry) {
                if (nodePrevious == null) {
                    firstNode = currentNode.next;
                    numEntries--;
                    return true;

                } else {
                    tempNode = currentNode;
                    nodePrevious.next = tempNode.next;
                    numEntries--;
                     return true;
                }
                
            } else {
                nodePrevious = currentNode;
                currentNode = currentNode.next;
                index++;
            }

        }
        return true;
    }

    /**
     * Removes all entries from bag.
     */
    @Override
    public void clear() {
        
        while (!isEmpty()) {
            remove();
        }
        
    }

    
    /** Counts the number of times the given entry appears in bag.
     * @param anEntry The entry that will be counted.
     * @return int The number of time given entry is present in bag.
     */
    @Override
    public int getFrequencyOf(T anEntry) {

        int frequency = 0;
        int index = 0;
        Node currentNode = firstNode;

        while ((index < numEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }

            index++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    
    /** Checks whether bag contains an instance of given entry.
     * @param anEntry The given entry that will be checked for.
     * @return boolean True if the given entry is found, or false otherwise.
     */
    @Override
    public boolean contains(T anEntry) {
        
        if (this.getFrequencyOf(anEntry) > 0) {
            return true;
        } else {
            return false;
        }
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


    
    
    
    /** Creates a new bag with the combined contents of both bags into a new bag.
     * @param otherBag The bag that will be combined with the bag that called the method.
     * @return BagInterface<T> A new bag that is the union of both bags.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> otherBag) {
      
       // create the union bag //
       BagInterface<T> result = new LinkedBag<>() ;    
       
        // declare the two bags which will union//
        int count ;                                                    
        T[] bagTs = this.toArray();
        T[] bagOther = otherBag.toArray();
        
        // move first "bagTs" bag to union bag //
        for(count = 0 ; count < numEntries ; count++)                     
             result.add(bagTs[count]) ;
        
        // move second bag "bagOther" to union bag //
        for(count = 0 ; count < otherBag.getCurrentSize() ; count++)
            result.add(bagOther[count]) ;
    
        return result;
        
    }
    
    
    
    /** Creates a new bag that contains the intersection of both bags.
     * @param otherBag The bag that will be checked for intersecting elements.
     * @return BagInterface<T> A new bag that is the intersection of both bags.
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> otherBag) {

        BagInterface<T> result = new LinkedBag<T>();

        if (this.getCurrentSize() == 0 || otherBag.getCurrentSize() == 0) {
            return null;
        }

        T[] leftLinked = this.toArray();
        T[] rightLinked = otherBag.toArray();
        
        T element;

        for(int i = 0; i < leftLinked.length; i++) {
            element = leftLinked[i];
            for (int j = 0; j < rightLinked.length; j++) {
                if (element == rightLinked[j]) {
                    result.add(element);
                    rightLinked[j] = null;
                    break;
                }
            }
        }
        
        return result;
    }

    
    
    
    /** Creates a new bag that contains the difference of both bags.
     * @param otherBag The bag that will be compared for differences.
     * @return BagInterface<T> A new bag that is the difference of both bags.
     */
    @Override
    public BagInterface < T > difference(BagInterface < T > otherBag) {
    BagInterface < T > result = new LinkedBag < >();
        T[] mine = this.toArray();
        for (T element : mine) {
            result.add(element);
        }
        T[] others = otherBag.toArray();
        for (T element : others) {
        if(result.contains(element)){
            result.remove(element);
        }
    }
        return result;
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

/*
    Client program meant to test the three methods 
    (union, intersection,and difference) for the 
    class ResizeableArrayBag
 */

import java.util.*;

public class ResizeableArrayBag<T> implements BagInterface<T> {
    private T[] itemArray;
    private int numberOfItems;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private int myCapacity;
   

    public ResizeableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayBag(int capacity) {
        myCapacity = capacity;
        numberOfItems = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        itemArray = tempBag;
        integrityOK = true;

    }

    public ResizeableArrayBag(ResizeableArrayBag<T> anotherBag) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[anotherBag.getCapacity()];
        myCapacity = anotherBag.getCapacity();
        itemArray = tempBag;

        numberOfItems = anotherBag.numberOfItems;
        for (int index = 0; index < anotherBag.numberOfItems; ++index) {
            @SuppressWarnings("unchecked")
            T movingItem = (T) anotherBag.itemArray[index];
            itemArray[index] = movingItem;
        }

    }

    
    /** Gets the number of entries in this bag.
     * @return int The integer number of entries in this bag.
     */
    public int getCurrentSize() {
        return numberOfItems;
    }

    
    /** Gets the current capacity of this bag.
     * @return int The interger number of this bag's capacity.
     */
    public int getCapacity() {
        return myCapacity;

    }

    
    /** Changes the size of this given bag, to the given size.
     * @param newCapacity The size to which this bag's size will be changed to.
     */
    public void resize(int newCapacity) {
        if (myCapacity > newCapacity) {
            return;
        } else {
            itemArray = Arrays.copyOf(itemArray, newCapacity);
            myCapacity = newCapacity;
        }
    }

    
    /** Sees whether this bag is empty.
     * @return boolean True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    
    /** Sees whether this bag is full.
     * @return boolean True if the bag is full, false if not.
     */
    public boolean isFull() {
        if (myCapacity == numberOfItems) {
            return true;
        }
        return false;
    }

    
    /** Adds a new entry to this bag.
     * @param newItem The object to be added as a new entry.
     * @return boolean True if the addition is successful, or false if not.
     */
    public boolean add(T newItem) {
        if (isFull()) {
            resize(2 * myCapacity);
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            return true;
        } else {
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            if (isFull()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        for (int index = 0; index < numberOfItems; index++)
            itemArray[index] = null;
        numberOfItems = 0;
    }
  
    
    /** Removes one unspecified entry from this bag, if possible.
     * @return T Either the removed entry, if the removal was successful, or null.
     */
    @Override
    public T remove() {
        checkIntegrity();
        T result = null;

        if (!isEmpty()) {
            result = itemArray[numberOfItems - 1];
            itemArray[numberOfItems - 1] = null;
            numberOfItems--;

        }

        return result;
        
    }

    
    /** Removes one occurrence of a given entry from this bag.
     * @param anEntry The entry to be removed.
     * @return boolean True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        int k = 0;
        while (k < numberOfItems) {
            if (itemArray[k].equals(anEntry)) {
                if (k < numberOfItems) {
                    itemArray[k] = itemArray[numberOfItems - 1];
                    itemArray[numberOfItems - 1] = null;
                    numberOfItems--;
                    return true;
                }
            }
            k++;
        }
        return false;
    }

    
    /** Tests whether this bag contains a given entry.
     * @param anEntry The entry to locate.
     * @return boolean True if this bag contains entry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        if (isEmpty())
            return false;
        else {
            int k = 0;
            while (k < numberOfItems) {
                if (itemArray[k] == anEntry)
                    return true;
                k++;
            }
        }
        return false;
    }

    
    /** Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return int The number of times entry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int index = 0; index < numberOfItems; index++) {
            if (itemArray[index].equals(anEntry)) {
                counter++;
            }
        }
        return counter;
    }

    
    /** Retrieves all entries that are in this bag.
     * @return T[] A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfItems];
        for (int index = 0; index < numberOfItems; index++)
            result[index] = itemArray[index];
        return result;
    }
    
    
    /** Creates a new bag with the combined contents of both bags into a new bag.
     * @param otherBag The bag that will be combined with the bag that called the method.
     * @return BagInterface<T> A new bag that is the union of both bags.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> otherBag) {
        // create union bag //
        BagInterface<T> result = new ResizeableArrayBag<>() ;

       // declare the two bags that will union //
        int count ; 
        T[] bagTs = this.toArray();
        T[] bagOther = otherBag.toArray();

        // union of first bag "bagTs"
        for(count = 0 ; count < numberOfItems ; count++)
            result.add(bagTs[count]) ;
        //union of second bag "otherBag" //
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
        BagInterface<T> result = new ResizeableArrayBag<>();

        if (this.getCurrentSize() == 0 && otherBag.getCurrentSize() == 0) {
            return null;
        } else if (this.getCurrentSize() == 0) {
            return otherBag;
        } else if (otherBag.getCurrentSize() == 0) {
            return this;
        }
        

        T[] leftArray = this.toArray();
        T[] rightArray = otherBag.toArray();
        
        T element;
        //boolean found = false;

        for(int i = 0; i < leftArray.length; i++) {
            element = leftArray[i];
            for (int j = 0; j < rightArray.length; j++) {
                if (element == rightArray[j]) {
                    result.add(element);
                    rightArray[j] = null;
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
    public BagInterface<T> difference(BagInterface<T> otherBag) {
        BagInterface<T> result = new ResizeableArrayBag<>();
        T[] mine = this.toArray();
        for (T element : mine) {
            result.add(element);
        }
        T[] others = otherBag.toArray();
        for (T element : others) {
            if (result.contains(element)) {
                result.remove(element);
            }
        }
        return result;
    }

    // Throws and exception if this object is not initialized
    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ArrayBag object if corrupt");
        }
    }

}

import java.util.*;

public class ResizeableArrayBag<T> implements BagInterface<T> {
    private T[] itemArray;

    private static final int DEFAULT_CAPACITY = 25;
    private int myCapacity;
    private int numberOfItems;

    public ResizeableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayBag(int capacity) {
        myCapacity = capacity;
        numberOfItems = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];

        itemArray = tempBag;

    }

    public ResizeableArrayBag(ResizeableArrayBag anotherBag) {
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

    public int getCurrentSize() {
        return numberOfItems;
    }

    public int getCapacity() {
        return myCapacity;

    }

    public void resize(int newCapacity) {
        if (myCapacity > newCapacity) {
            return;
        } else {
            itemArray = Arrays.copyOf(itemArray, newCapacity);
            myCapacity = newCapacity;
        }
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        if (myCapacity == numberOfItems) {
            return true;
        }
        return false;
    }

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

    public void clear() {
        for (int index = 0; index < numberOfItems; index++)
            itemArray[index] = null;
        numberOfItems = 0;
    }
  
    // To-do:
    @Override
    public T remove() {
        return null;
    }

    public boolean remove(T anItem) {
        int k = 0;
        while (k < numberOfItems) {
            if (itemArray[k].equals(anItem)) {
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

    public boolean contains(T anItem) {
        if (isEmpty())
            return false;
        else {
            int k = 0;
            while (k < numberOfItems) {
                if (itemArray[k] == anItem)
                    return true;
                k++;
            }
        }
        return false;
    }

    public int getFrequencyOf(T anItem) {
        int counter = 0;
        for (int index = 0; index < numberOfItems; index++) {
            if (itemArray[index].equals(anItem)) {
                counter++;
            }
        }
        return counter;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfItems];
        for (int index = 0; index < numberOfItems; index++)
            result[index] = itemArray[index];
        return result;
    }
    
    
    /**
     * union method: Priscilla
     */
    // Needs fixing, many syntax errors 
    @Override
    public BagInterface<T> union(BagInterface<T> bagUnion) {

        BagInterface T bagUnion = new ResizeableArrayBag () ;
        ResizeableArrayBag T otherbag = (ResizeableArrayBag T) otherbag ;

        int count ; 
        for(count = 0 ; count < numberOfEnteries ; count++)
            bagUnion.add(bag[count]) ;
        
        for(count  = 0 ; index < otherBag.getCurrentSize() ; index++)
            bagUnion.add(otherBag[index]) ;

        return bagUnion;
    }

    /**
     * intersection method: John
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> otherBag) {
        BagInterface<T> result = new ResizeableArrayBag<>();

        if (this.getCurrentSize() == 0 || otherBag.getCurrentSize() == 0) {
            return null;
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
    
    
    /**
     * difference method: Daniel
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> otherBag) {
        BagInterface<T> result = new ResizeableArrayBag<>();
        T[] mine = this.toArray();
        for (T elem : mine) {
            result.add(elem);
        }
        T[] others = otherBag.toArray();
        for (T elem : others) {
            if (result.contains(elem)) {
                result.remove(elem);
            }
        }
        return result;
    }


}

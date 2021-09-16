/** An implementation of the ADT bag using a resizable array */

public class ResizeableArrayBag<T> implements BagInterface<T> {

    
    public ResizeableArrayBag() {
        
    }


    @Override
    public int getCurrentSize() {
        

        return 0;
    }

    @Override
    public boolean isEmpty() {
        

        return false;
    }

    @Override
    public boolean add(T newEntry) {
        

        return false;
    }

    @Override
    public T remove() {
        
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        

        return false;
    }

    @Override
    public void clear() {
        
        
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        
        return false;
    }

    @Override
    public T[] toArray() {

        return null;
    }

    @Override
    public T union(T bagUnion) {
        BagInterface T bagUnion = new ResizeableArrayBag () ;
        ResizeableArrayBag T otherbag = (ResizeableArrayBag T) otherbag ;

        int count ; 
        for(count = 0 ; count < numberOfEnteries ; count++)
            bagUnion.add(bag[count]) ;
        
        for(count  = 0 ; index < otherBag.getCurrentSize() ; index++)
            bagUnion.add(otherBag[index]) ;

        return bagUnion ;
        return null;
    }

    @Override
    public T intersection(T bagIntersection) {
        
        return null;
    }

    @Override
    public T difference(T bagDifference) {
        
        return null;
    }
    
}

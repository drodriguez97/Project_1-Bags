/*
    Client program meant to test the three methods 
    (union, intersection,and difference) for the 
    class LinkedBag
 */
 

public class LinkedBagTest { // Question: LinkedBagTest will implement BagInterface ? //

    public static void main(String[] args) {

        // Testing union method : Priscilla
       
       // creat two bags //
        BagInterface bag1 = new LinkedBagTest(a);
        BagInterface bag2 = new LinkedBagTest(b);
        
       // add items to bag 
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
    // union of bag 1 and bag 2 and display union bag //
    BagInterface<String> everything = bag1.union(bag2) ;
    displayBag(everything);

        // Testing intersection method : John

        BagInterface<String> interBag1 = new LinkedBag<>();
        BagInterface<String> interBag2 = new LinkedBag<>();

        interBag1.add("a");
        interBag1.add("b");
        interBag1.add("c");
        interBag1.add("b");

        interBag2.add("b");
        interBag2.add("b");
        interBag2.add("d");
        interBag2.add("e");

        displayBag(interBag1);
        displayBag(interBag2);

        BagInterface<String> commonItems = interBag1.intersection(interBag2);

        displayBag(interBag1);
        displayBag(interBag2);
        
        displayBag(commonItems);

        // Testing difference method : Daniel
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        
        bag1.add("d");
        bag1.add("f");
        bag1.add("g");
        bag1.add("h");

        bag2.add("j");
        bag2.add("h");
        bag2.add("d");
        bag2.add("l");
        
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));

    }

    // Tests the method toArray while displaying the bag.
   private static void displayBag(BagInterface<String> aBag)
   {
      System.out.println("The bag contains the following string(s):");
      Object[] bagArray = aBag.toArray();
      for (int index = 0; index < bagArray.length; index++)
      {
         System.out.print(bagArray[index] + " ");
      } // end for
      
      System.out.println();
   } // end displayBag
    
}

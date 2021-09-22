//import java.util.Arrays;

public class ArrayBagTest {
    public static void main(String[] args) {
        
        // Testing union method : Priscilla

        /* 
	BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();
      
              bag1.add("a");
              bag1.add("b");
              bag1.add("c");
      
              bag2.add("b");
              bag2.add("b");
              bag2.add("d");
              bag2.add("f");
	      
	BagInterface<String> everything = bag1.union(bag2) ;
        displayBag(everything);
	*/

        // Testing intersection method : John

        /*

        BagInterface<String> interBag1 = new ResizeableArrayBag<>();
        BagInterface<String> interBag2 = new ResizeableArrayBag<>();

        
        interBag1.add("a");
        interBag1.add("b");
        interBag1.add("c");
        interBag1.add("b");
        interBag1.add("b");

        interBag2.add("b");
        interBag2.add("b");
        interBag2.add("d");
        interBag2.add("e");
        interBag2.add("a");


        displayBag(interBag1);
        displayBag(interBag2);

        BagInterface<String> commonItems = interBag1.intersection(interBag2);

        displayBag(interBag1);
        displayBag(interBag2);
        
        displayBag(commonItems);

        */


        // Testing difference method : Daniel
        
        /*
        BagInterface<String> diffBag1 = new ResizeableArrayBag<>();
        BagInterface<String> diffBag2 = new ResizeableArrayBag<>();

        diffBag1.add("a");
        diffBag1.add("b");
        diffBag1.add("c");

        diffBag2.add("b");
        diffBag2.add("b");
        diffBag2.add("d");
        diffBag2.add("e");


        BagInterface<String> leftOver1 = diffBag1.difference(diffBag2);
        BagInterface<String> leftOver2 = diffBag2.difference(diffBag1);

        displayBag(leftOver1);

        System.out.println();
        displayBag(leftOver2);

        displayBag(diffBag1);
        displayBag(diffBag2);

        */


    }


     // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{   
        if (aBag == null) {
            System.out.println("The bag is empty");
            return;
        }
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
}

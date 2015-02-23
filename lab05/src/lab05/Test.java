package lab05;

import java.util.Random;

/**
 *
 * @author jaden.young
 */
public class Test {

    public static void main(String[] args) {
        ArrayBag<Player> teamArray = new ArrayBag();
        LinkedBag<Player> teamLinkedList = new LinkedBag();
        long start = System.currentTimeMillis();
        Random rand = new Random();
        final int NUMBER_OF_ITEMS = 1000;
        
	// populate the array
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            teamArray.add(new Player("John", "Guard", rand.nextInt(99) + 1));
        }
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("The time that it took to assign " + NUMBER_OF_ITEMS
                + " items to the array: " + elapsed);
        
	//populate the linked list
        start = System.currentTimeMillis();
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            teamLinkedList.add(new Player("John", "guard", rand.nextInt(99) + 1));
        }
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("The time that it took to assign " + NUMBER_OF_ITEMS
                + " items to the linked list: " + elapsed);
        
	//remove the first item from the array
	start = System.currentTimeMillis();
	Player temp = teamArray.getItem(0);
	teamArray.remove(temp);
	end = System.currentTimeMillis();
	elapsed = end - start;
	System.out.println("\nThe time that it took to remove the first "
		+ "item in the array: " + elapsed);
	
	//remove the first item from the linked list
	//2nd temp variable is used to account for miniscule time taken to 
	//allocate memory for new variable, as opposed to reassigning
	//the temp from the last block
	start = System.currentTimeMillis();
	Player temp2 = teamLinkedList.getItem(0);
	teamLinkedList.remove(temp2);
	end = System.currentTimeMillis();
	elapsed = end - start;
	System.out.println("The time that it took to remove the first "
		+ "item in the linked list: " + elapsed);
    }
}

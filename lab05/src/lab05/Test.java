package lab05;

import java.util.Random;

/**
 *
 * @author jaden.young
 */
public class Test {

    public static void main(String[] args) {
        ArrayBag<Player> teamArray = new ArrayBag();
        LinkedBag<Player> linkedBag = new LinkedBag();
        long start = System.currentTimeMillis();
        Random rand = new Random();
        final int NUMBER_OF_ITEMS = 1000;
        
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            teamArray.add(new Player("John", "Guard", rand.nextInt(99) + 1));
        }
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("The time that it took to assign " + NUMBER_OF_ITEMS
                + " items to the array: " + elapsed);
        
        start = System.currentTimeMillis();
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            linkedBag.add(new Player("John", "guard", rand.nextInt(99) + 1));
        }
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("The time that it took to assign " + NUMBER_OF_ITEMS
                + " items to the linked list: " + elapsed);
        
    
}

package lab05;

import java.util.Random;

/**
 * Uses an array as a data structure for a generic bag. 
 * @author Jaden Young
 */
public class ArrayBag<T> implements Bag<T> {

    private T[] bag;
    private int count;
    
    /**
     * Default constructor<BR>
     * Creates an array of generic type with length 10
     */
    public ArrayBag() {
        Object[] temp = new Object[10];
        bag = (T[])temp;
        temp = null;
        count = 0;
    }
    
    /**
     * Overloaded constructor<BR>
     * Creates an array of generic type with specified length
     * @param size Length of the array
     */
    public ArrayBag(int size) {
        Object[] temp = new Object[size];
        bag = (T[])temp;
        temp = null;
        count = 0;
    }

    /** Returns the number of items in the bag */
    @Override
    public int getCurrentSize() {
        return count;
    }

    /** Returns true if the bag is empty, false if not */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /** Returns true if the bag is full, false if not */
    @Override
    public boolean isFull() {
        return count == bag.length;
    }

    /**
     * Adds an item to the end of the bag.<BR>
     * If the bag is full, the length is doubled, and the item is then added.
     * Returns true if the addition was successful, false if not
     * @param item Item to be added
     * @return True if the item was added successfully, false if not
     */
    @Override
    public boolean add(T item) {
        boolean success = false;
        if(count == bag.length) {
            Object[] temp = new Object[2 * bag.length];
            for(int i = 0; i < count; i++) {
                temp[i] = bag[i];
            }
            bag = (T[])temp;
            temp = null;
        }
        bag[count] = item;
        count++;
        return bag[count - 1] == item;
    }

    /**
     * Removes a random item from the bag.<BR>
     * Returns the removed item
     * @return item removed from the bag
     */
    @Override
    public T remove() {
        Random rand = new Random();
        int index = rand.nextInt(count);
        T removed = bag[index];
        for(int i = index; i < count; i++) {
            bag[i] = bag[i + 1];
        }
        count--;
        return removed;
    }

    /**
     * Removes a specified item from the bag.<BR>
     * All following elements are shifted 1 to the left to fill the hole.<BR>
     * Returns true if item was removed successfully, false if not.
     * @param item Item to be removed
     * @return True if removal was successful, false if removal failed/item was
     *          not found
     */
    @Override
    public boolean remove(T item) {
        for(int i = 0; i < count; i++) {
            if(bag[i].equals(item)) {
                for(int j = i; j < count; j++) {
                    bag[j] = bag[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all entries from the bag.<BR>
     * Each filled index in the bag is replaced with the default value for the 
     * data type.
     */
    @Override
    public void clear() {
        for(int i = 0; i < count; i++) {
            Object temp = new Object();
            bag[i] = (T)temp;
        }
    }

    /**
     * Returns the number of times a specified item appears in the bag
     * @param item Item to be searched for
     * @return Number of times the item appears in the bag
     */
    @Override
    public int getFrequencyOf(T item) {
        int freq = 0;
        for(int i = 0; i < count; i++) {
            if(bag[i].equals(item))
                freq++;
        }
        return freq;
    }

    /**
     * Tells whether or not a specified item is in the bag
     * @param item Item to search for
     * @return True if item is found, false if not 
     */
    @Override
    public boolean contains(T item) {
        for(int i = 0; i < count; i++) {
            if(bag[i].equals(item))
                return true;
        }
        return false;
    }
    
    /**
     * Returns the item stored at the specified index position
     * @param index Index of the item that will be returned
     * @return item stored at the specified index
     */
    public T getItem(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index > count)
            throw new ArrayIndexOutOfBoundsException("ERROR: There was a "
                    + "problem retrieving the data. Specified index position "
                    + "is empty.");
        return bag[index];
    }
    
    /**
     * Returns the current capacity of the bag (not the number of items stored)
     * @return bag capacity
     */
    public int getSize() {
        return bag.length;
    }
    
    /**
     * Returns a copy of the bag
     * @return A reference to a copy of the bag
     */
    public T[] getCopy() {
        Object[] tempObj = new Object[bag.length];
        for(int i = 0; i < count; i++) {
            tempObj[i] = bag[i];
        }
        T[] tempT = (T[])tempObj;
        tempObj = null;
        return tempT;
    }
    
    /**
     * toString method that returns a string comprised of a combination of 
     * the toString methods for each element in the bag.
     * @return Concatenated String with the output of the toString method from
     *          every element in the bag
     */
    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < this.getCurrentSize(); i++) {
            output += "\n" + bag[i].toString();
        }
        return output;
    }
}

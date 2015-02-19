package lab05;

/**
 * Defines a Player object with values for name, positionPlayed, and number.
 * One constructor is provided that initializes all fields, along with get/set
 * methods for each field.
 * @author Jaden Young
 */
public class Player {
    
    //instance variables
    private String name;
    private String positionPlayed;
    private int jerseyNumber;
    
    /**
     * Constructs a new Player object with values for all of the fields
     * @param xName Name of the player
     * @param xPosition Position of the player
     * @param xNumber The player's number 
     */
    public Player(String xName, String xPosition, int xNumber){
        
        name = xName;
        positionPlayed = xPosition;
        this.setJerseyNumber(xNumber);
    }
    
    //accessor methods---------------------------------
    /**
     * Returns the name of the player
     * @return Name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the position of the player
     * @return Position of the player
     */
    public String getPositionPlayed() {
        return positionPlayed;
    }
    
    /**
     * Returns the number of the player
     * @return Player's number
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }
    
    
    //mutator methods -------------------------
    /**
     * Sets the name of the player
     * @param xName New name for the player
     */
    public void setName(String xName) {
        name = xName;
    }
    
    /**
     * Sets the position of the player
     * @param xPosition New position for the player
     */
    public void setPositionPlayed(String xPosition) {
        positionPlayed = xPosition;
    }
    
    /**
     * Sets the number of the player. 
     * Number must be an integer 1-99, else throws exception
     * @param xNumber 
     */
    public final void setJerseyNumber(int xNumber) {
        if (xNumber >= 0 && xNumber < 100)
            jerseyNumber = xNumber;
        else
            throw new IllegalArgumentException("Number must be a "
                    + "whole number 1-99");
    }
    
    
    /**
     * Checks the contents of two Player objects for equality.<BR>
     * Returns true if objects contents are equal, false if not
     * @param xObj Object to be compared
     * @return True if objects are equal, false if not
     */
    @Override
    public boolean equals(Object xObj) {
        if(!(xObj instanceof Player))
            return false;
        Player obj = (Player)xObj;
        if(!(name.equals(obj.getName())))
            return false;
        if(!(positionPlayed.equals(obj.getPositionPlayed())))
            return false;
        return jerseyNumber == obj.getJerseyNumber();
    }
    
    /**
     * Returns a string representation of the data contained in the object
     * @return Single printable string of data stored in the object
     */
    @Override
    public String toString() {
        String output = "";
        output += "Name: " + this.name;
        output += "\nPosition: " + this.positionPlayed;
        output += "\nJersey Number: " + this.jerseyNumber;
        return output;
    }
}
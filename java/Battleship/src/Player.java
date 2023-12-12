/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * create a HashMap<Location, Ship> to map the locations to ships
 * create 2D array to store the locations
 * store the player's total HP as an int
 * 
 * method for choosing ship positions:
 *      loop through the list of ship types in Ship:
 *      using the prompt box at the bottom tell the player to click on a location and place a ship
 *      check if the location is valid (i.e. does not collide with another ship or go off the grid)
 *      if the length plus the location is greater than 10, it is not valid
 *      loop through all the points that the ship will occupy
 *          if the location has a ship, it is not valid
 * 
 *      if the location is not valid:
 *          ask the user to try again
 *      
 *      if the location is valid:
 *          create the ship and place it on the grid
 *          the is a label that uses the image of the ship
 * 
 * method for randomly choosing ship positions:
 *      place a ship at a random location and direction for the enemy ships
 *      if it is valid, place it
 *      if not try again
 * 
 * method for a random move
 * method for guessing a location:
 *      if it there is a ship there and the location is unguessed:
 *          reduce the ship's HP and player HP
 *      
 *      else:
 *          mark it as empty
 */

import java.util.HashMap;

public class Player {
    // the size of the Battleship grid
    // just in case someone wants to size it up or down
    protected final static int gridSize = 10;

    // all the locations are mapped to a ship or mapped to null
    private HashMap<Location, Ship> ships;

    // create a 2D array of locations to traverse
    // stores the player's ships and enemy's guesses
    private Location[][] playerGrid;

    // create a 2D array of locations to traverse
    // stores the player's ships and enemy's guesses
    private Location[][] enemyGrid;

    // the sum of the HP of all the ships
    private int totalShipHP;

    public Player() {
        // add up the lengths in Ship.ShipType
        for (Ship.ShipType type: Ship.ShipType.values()) {
            totalShipHP += type.getLength();
        }

        ships = new HashMap<>();

        // create the grids based on gridSize
        playerGrid = new Location[gridSize][gridSize];
        enemyGrid = new Location[gridSize][gridSize];
    }

    /** 
     * empty function to be override
     * sets the position of the ship
     */
    public void setShipPosition(Ship ship) {
        
    }

    public boolean isValid(Location spot){
        return true;
    }
}

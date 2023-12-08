/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * create a HashMap<Location, Ship> to map the locations to ships
 * 
 * method for choosing ship positions:
 *      loop through the list of ship types in Ship:
 *      using the prompt box at the bottom tell the player to click on a location and place a ship
 *      check if the location is valid (i.e. does not collied with another ship or go off the grid)
 *    
 *      if the location is not valid:
 *          ask the user to try again
 *      
 *      if the location is valid:
 *          create the ship and place it on the grid
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

public class Player {
    public Player() {
        
    }
}

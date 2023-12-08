/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * import all the ship images and save them as ImageIcons
 * 
 * declare public constants
 *      - a HashMap mapping ship type(e.g. destroyer, cruiser, patrol boat) to ship length
 *      - a HashMap mapping shipType to ImageIcons
 * 
 * declare private variables:
 *      - type of ship(destroyer, cruiser, patrol boat, etc)
 *      - array of locations
 *      - health left
 *      - direction
 *      - ImageIcon of the ship
 * 
 * create getters for all variables
 * create a method to return length
 * create a method to return if the ship is sunk(i.e. HP == 0)
 * 
 * create setter for health left
 */    

public class Ship {
    // create the HashMap that stores ship types to ship lengths
    public final static HashMap<String, Integer> SHIP_TYPES = new HashMap<>();
    static {
        SHIP_TYPES.put("Carrier", 5);
        SHIP_TYPES.put("Battleship", 4);
        SHIP_TYPES.put("Destroyer", 3);
        SHIP_TYPES.put("Submarine", 3);
        SHIP_TYPES.put("Patrol Boat", 2);
    }


}
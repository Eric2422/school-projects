/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * import all the ship images and save them as ImageIcons
 * 
 * declare public constants
 *      - a enum with ship type(e.g. destroyer, cruiser, patrol boat) and ship lengths
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
    public enum ShipType {
        CARRIER("Carrier", 5),
        CRUISER("Cruiser", 4),
        DESTORYER("Destroyer", 3),
        SUBMARINE("Submarine", 3),
        PATROL_BOAT("Patrol Boat", 2)
    }

    private 

    public Ship() {

    }
}
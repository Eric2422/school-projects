/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * import all the ship images and save them as ImageIcons
 * 
 * declare public constants
 *      - a enum with ship type(e.g. destroyer, cruiser, patrol boat), ship lengths, and sprite pathfiles
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
 * 
 * create setter for health left
 */    

public class Ship {
    public enum ShipType {
        CARRIER(5),
        CRUISER(4),
        DESTORYER(3),
        SUBMARINE(3),
        PATROL_BOAT(2);

        private final int length;

        private ShipType(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL;
    }

    // the type of ship(e.g. destroyer, cruiser, carrier)
    private ShipType shipType;
    // how many tiles the ship takes up
    private int length;
    // how many unhit parts the ship has left
    private int health;
    private Direction direction;

    public Ship(ShipType shipType, Direction direction) {
        this.shipType = shipType;
        this.length = shipType.getLength();

        this.health = length;

        this.direction = direction;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getLength() {
        return length;
    }

    public int getHealth() {
        return health;
    }

    public Direction getDirection() {
        return direction;
    }
}
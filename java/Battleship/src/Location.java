/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * import pictures for fog, splash, water, red X, white circle as ImageIcons
 * 
 * create a property for whether the location is unguessed, miss, or hit
 * create two private variables: one for column and one for row
 * 
 * create getters and setters for row and col
 * create getters and setters for the status of the location (hit, miss, or unguessed)
 * 
 * if set status to hit
 *      display smoke and then a red X over water
 * 
 * if set status to miss
 *      display a splash and then a white circle over water
 * 
 * if it is unguessed
 *      display fog
 */

import javax.swing.ImageIcon;

public class Location {
    // the letters that are valid rows
    public enum RowLetter {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J;
    }

    // constants for the status of the location
    public enum Status {
        HIT,
        MISS,
        UNGUESSED;        
    }

    private RowLetter row;
    private int col;

    // the status of the location:
    // hit, miss, or unguessed
    private Status status;

    // the sprite that is shown over the tile
    private ImageIcon sprite;

    public Location(RowLetter row, int col) {
        this.row = row;
        this.col = col;

        this.status = Status.UNGUESSED;
    }

    public RowLetter getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
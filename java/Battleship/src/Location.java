/*
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * create a property for whether the location is unguessed, miss, or hit
 * create two private variables: one for column and one for row
 * 
 * create getters and setters for row and col
 * create getters and setters for the status of the location (hit, miss, or unguessed)
 * 
 * if set status to hit
 *      display smoke and then a red X
 * 
 * if set status to miss
 *      display a splash and then a white circle
 * 
 * if it is unguessed
 *      display nothing
 */

public class Location {
    char row;
    int col;
}
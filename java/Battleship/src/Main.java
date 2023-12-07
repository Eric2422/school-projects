/* 
 * —————————————————————————————————— PSEUDOCODE ——————————————————————————————————
 * import swing
 * 
 * create a JFrame
 * set the layout of JFrame to FlowLayout (the default)
 * set the size of the JFrame to 
 * 
 * set the title of the JFrame to "Battleship"
 * 
 * create a JLabel at the top and label it "Battleship"
 * create a blank JLabel at the bottom to display text to the user
 * create 10 JLabels to mark the rows from A to J
 * create 10 JLabels to mark the columns from 1 to 10
 * 
 * loop through the x and y values to place the buttons
 *      create 100 buttons, each for a single coordinate
 *      each button is an identical square
 *      add each button
 *      set each button's icon to a picture of water
 *      set each button's border to white
 *      disable the buttons
 * 
 * loop through the list of ship types in Ship:
 *      using the prompt box at the bottom tell the player to click on a location and place a ship
 *      check if the location is valid (i.e. does not collied with another ship or go off the grid)
 *    
 *      if the location is not valid:
 *          ask the user to try again
 *      
 *      if the location is valid:
 *          create the ship and place it on the grid
 *
 * loop the list of ship types in Ship:
 *      place a ship at a random location and direction for the enemy ships
 *      if it is valid, place it
 *      if not try again
 * 
 * while neither player's ships are completely destroyed:
 *      prompt the user to click on a point to fire
 *      display whether the guess was a hit or miss
 * 
 *      make the computer fire at a random location
 *      
 * 
 * make the JFrame visible
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
 
public class Main {
    private static void createAndShowGUI() {
        JFrame jFrame = new JFrame("Hello World Swing Example");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World Swing");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setPreferredSize(new Dimension(150, 100));

        label.setText("Hello World Swing");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        jFrame.add(label);
        jFrame.setVisible(true);
  }
 
  public static void main(String[] args) {
    createAndShowGUI();
}
}
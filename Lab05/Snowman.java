/**
 * Snowman.java       Adapted from: Lewis, DePasquale & Chase page 971 (835 2nd edition)
 * 
 * Demonstrates basic drawing methods and the use of color.
 * 
 */

import javax.swing.*;
import java.awt.*;
import javax.sound.midi.*;

public class Snowman extends JFrame{
  
  final int MID = 100;
  final int TOP = 50;
  
  /** creates  an instance of the Snowman class called frame and sets some essential parameters.
   * You do not need to understand how this method works until later in the course*/
  public static void main(String[]args){
    Snowman frame = new Snowman();  
    frame.setSize(300,220);
    frame.setVisible(true);
  }
  
  /**  Draws a snowman.*/
  public void paint (Graphics page){

    setTitle("Snowman");
    page.setColor (Color.cyan);
    page.fillRect(0,0,300,220);  //background;
    
    page.setColor (Color.blue);
    page.fillRect (0, 175, 300, 50);  // ground
    
    page.setColor (Color.yellow);
    // page.fillOval (-40, -40, 80, 80);  // sun
    drawCircle(page, 300, 0, 40);  // draw and fill a circle at point(300, 0) with radius is 40, sun is now at upper-right;
    
    page.setColor (Color.white);
    page.fillOval (MID -20, TOP, 40, 40);      // head
    page.fillOval (MID - 35, TOP + 35, 70, 50);   // upper torso
    addTwoRedButton(page);
    page.fillOval (MID - 50, TOP + 80, 100, 60);  // lower torso

    page.setColor (Color.black);
    page.fillOval (MID - 10, TOP + 10, 5, 5);   // left eye
    page.fillOval (MID + 5, TOP + 10, 5, 5);    // right eye
    
    // page.drawArc (MID - 10, TOP + 20, 20, 10, 190, 160);   // smile
    
    page.drawLine (MID - 25, TOP + 60, MID - 50, TOP + 40);  // left arm
    page.drawLine (MID + 25, TOP + 60, MID + 55, TOP + 60);  // right arm
    
    page.drawLine (MID - 20, TOP + 5, MID + 20, TOP + 5);  // brim of hat
    page.fillRect (MID - 15, TOP - 20, 30, 25);        // top of hat
    
    makeSnowmanFrown(page); // Oh~, it is frowning..
    page.drawString("Frank Zhao", 5, 33);
  }
  
  /** add two red buttons on upper torso*/
  public void addTwoRedButton(Graphics page) {
    page.setColor(Color.red);
    int size = 10;
    int height = TOP + 42;
    page.fillOval(MID - (size/2), height, size, size);
    page.fillOval(MID - (size/2), height + 20, size, size);
    page.setColor(Color.white);
  }
  
  /** make snowman frown */
  public void makeSnowmanFrown(Graphics page) {
    page.drawArc (MID - 10, TOP + 20, 20, 10, -10, 200);
  }
  
  /** method to draw a circle with center point and radius*/
  public void drawCircle(Graphics page, int x, int y, int radius) {
    page.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }
}

/** FilePanel.java
 * Lab 20, COMP160,  2016
 * 
 * a JPanel which creates 2 instances of Rectangle objects, 
 * stores them in an array, and draws them 
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count;
  
  
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){  
//    drawObjects[count] = new Rectangle(true,Color.red, 0, 0,30,30);
//    count++;
//    drawObjects[count] = new Rectangle(false,Color.blue, 50, 50,30,30);
//    count++;
    String fileName = "Lab20data.txt";
    //int[] pixelArray = new int[6];
    try {
      Scanner fileScan = new Scanner(new File(fileName));
      int[] pixelArray = new int[6];
      while (fileScan.hasNext()) {                   // process each line in the file
        String line = fileScan.nextLine();
        if (line.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+")) {
          code
        }
        Scanner lineScan = new Scanner(line);
        int countPixel = 0;
        while (lineScan.hasNext()) {                  // process each colum for each line
          pixelArray[countPixel] = Integer.parseInt(lineScan.next()) ;  
          countPixel++;
        }
        
        Color setColor = Color.black;      // Try to use enum to finish this!
        switch (pixelArray[1]) {          // create the Color objects
          case 1:
            setColor = Color.red;
            break;
          case 2:
            setColor = Color.blue;
            break;
          case 3:
            setColor = Color.green;
            break;
          default:
            setColor = Color.black;
            break;
        }
        drawObjects[count] = new Rectangle(Boolean.parseBoolean(""+pixelArray[0]), setColor, pixelArray[2], pixelArray[3], pixelArray[4], pixelArray[5]);
        count++;
      }
      
      
    } catch (FileNotFoundException e) {
      System.out.println("File not found. Check file name and location.");
      System.exit(1);
    }

    setPreferredSize(new Dimension(300,300));
    setBackground(Color.yellow);
  }
  
  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    } 
  }
}



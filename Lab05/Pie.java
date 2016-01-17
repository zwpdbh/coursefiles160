/**
 Pie.java
 Provided for Part 2, Lab5, COMP160 2016
 
 */

import javax.swing.*;
import java.awt.*;

public class Pie extends JFrame{
     
    /**creates  an instance of Pie called chart1*/
    public static void main(String[]args){
        Pie chart1 = new Pie(); 
        chart1.setSize(300,220);
        chart1.setVisible(true);
    }
    
    /**all drawing code goes in the paint method, which is called automatically*/
    public void paint (Graphics page){
        page.setColor(Color.white);
        page.fillRect(0,0,300,220);
        //your pie chart code goes here
        
        final int CENTER_X = 70;
        final int CENTER_Y = 40;
        final int RADIUS = 80;
        int size = RADIUS * 2;
        final int ARCANGLE = 45;
        
        // page.drawOval(CENTER_X, CENTER_Y, size, size);  // test the position of circle
        page.setColor(Color.black);
        page.drawArc(CENTER_X, CENTER_Y, size, size, ARCANGLE, 360);
        page.setColor(Color.white);
        page.drawArc(CENTER_X, CENTER_Y, size, size, 0, ARCANGLE);
        
        
        /**start to draw the first*/
        int startAngle = 0;
        page.setColor(Color.black);
        page.fillArc(CENTER_X + 5, CENTER_Y - 2, size, size, 0, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.red);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.gray);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.cyan);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.yellow);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.orange);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.pink);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
        
        page.setColor(Color.blue);
        page.fillArc(CENTER_X, CENTER_Y, size, size, startAngle, ARCANGLE);
        startAngle += ARCANGLE;
    }
    

}

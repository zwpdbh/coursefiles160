//********************************************************************
//  StyleOptionsPanel.java      adapted from Java Foundations
//
//  Demonstrates the use of check boxes.
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel
{
   private JLabel saying;
   private JCheckBox bold, italic;
   private int style = Font.PLAIN;
   private String typeFace = "Helvetica";
   private JRadioButton courier, times, helvetica;

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and some check boxes that
   //  control the style of the label's font.
   //-----------------------------------------------------------------
   public StyleOptionsPanel()
   {  
      courier = new JRadioButton("Courier", true);   // default selected one
      times = new JRadioButton("Times New Roman");
      helvetica = new JRadioButton("Helvetica");
      
      setLayout(new GridLayout(6, 1));
       
      saying = new JLabel ("Say it with style!");
      saying.setFont (new Font (typeFace, style, 20));

      bold = new JCheckBox ("Bold");
      bold.setBackground (Color.cyan);
      italic = new JCheckBox ("Italic");
      italic.setBackground (Color.cyan);

      StyleListener listener = new StyleListener();
      bold.addItemListener (listener);
      italic.addItemListener (listener);

      add (saying);
      add (bold);
      add (italic);
      // add a ButtonGroup with three RadioButton within it.
      ButtonGroup group = new ButtonGroup();
      group.add(this.courier);
      group.add(this.times);
      group.add(this.helvetica);
      // add(group); group is a logic group, not real visual group, so do not add it on panel
      
      // add my listener for RadioButton
      RadioButtonListener mylistener = new RadioButtonListener();
      courier.addActionListener(mylistener);
      helvetica.addActionListener(mylistener);
      times.addActionListener(mylistener);
      
      add(courier);
      add(times);
      add(helvetica);
      
      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 100));
   }

   //*****************************************************************
   //  Represents the listener for both check boxes.
   //*****************************************************************
   private class StyleListener implements ItemListener
   {
      //--------------------------------------------------------------
      //  Updates the style of the label font style.
      //--------------------------------------------------------------
      public void itemStateChanged (ItemEvent event)
      {
         style = Font.PLAIN;

         if (bold.isSelected())
            style = Font.BOLD;

         if (italic.isSelected())
            style += Font.ITALIC;

         saying.setFont (new Font (typeFace, style, 20));
      }
   }
   
   private class RadioButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == courier) {
            saying.setFont(new Font("Courier", style, 20));
         } else if (e.getSource() == times) {
            saying.setFont(new Font("Times New Roman", style, 20));
         } else {
            saying.setFont(new Font("Helvetica", style, 20));
         }
      }
   }
}

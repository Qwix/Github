//********************************************************************
//  BorderPanel.java       Authors: Lewis/Loftus
//
//  Represents the panel in the LayoutDemo program that demonstrates
//  the border layout manager.
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class ProjectPanel extends JPanel
{
 
   public ProjectPanel()
   {
     
     
      setLayout (new BorderLayout());

      setBackground (Color.green);

      GridPanel3 b1 = new GridPanel3();
      WordsPanel b2 = new WordsPanel();

      add (b1, BorderLayout.CENTER); //(LM)
      add (b2, BorderLayout.NORTH);
      
      setPreferredSize(new Dimension(1300, 675));
   }
}

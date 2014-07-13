/*Greg Bjornstad
 * WordsPanel.java
 * Class for Memory Project
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WordsPanel extends JPanel{
  
private static JLabel clicksLabelText, clicksLabelNumber;

public WordsPanel(){
  
  
//create labels for the clicks
clicksLabelText = new JLabel ("Clicks: ");
clicksLabelNumber = new JLabel ("0");

clicksLabelText.setFont(new Font("Whatever", 1, 18));
clicksLabelNumber.setFont(new Font("Whatever", 1, 18));

//add the clicks label to the panel

add(clicksLabelText);
add(clicksLabelNumber);

//set the size of the panel to the WIDTH and HEIGHT constants
setPreferredSize(new Dimension(600, 40));

//set the color of the panel to whatever you choose
setBackground(Color.green);

}

public static void addClicks(){
  String clicksString = clicksLabelNumber.getText();
  int clicksNumber = Integer.parseInt(clicksString);
  clicksNumber++;
  clicksString = Integer.toString(clicksNumber);
  clicksLabelNumber.setText(clicksString);
}

public static String getClicks(){
  return clicksLabelNumber.getText();
}
}

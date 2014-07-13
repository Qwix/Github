/*Greg Bjornstad
 * WinPanel.java
 * Class for Memory Project
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class WinPanel extends JPanel{
  
private static JLabel clicksNumber, clicksLabel, playAgain, name, congratulationsText1, congratulationsText2, emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;
private JButton yes, no, viewScores;

public WinPanel(){
  
  
//create labels for text
congratulationsText1 = new JLabel ("Congratulations ");
congratulationsText2 = new JLabel ("You win! ");
playAgain = new JLabel ("Play Again?");
clicksLabel = new JLabel ("Clicks: ");
name = new JLabel (FrontPanel.getTextName());
clicksNumber = new JLabel (WordsPanel.getClicks());
emptySpace1 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace2 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace3 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace4 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace5 = new JLabel ("                        ");
emptySpace6 = new JLabel ("                        ");
emptySpace7 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace8 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace9 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace10 = new JLabel ("                        ");

//create buttons and add listeners
yes = new JButton("Yes");
no = new JButton("No");
viewScores = new JButton("View Scores");


yes.addActionListener(new StartListener());
no.addActionListener(new ExitListener());
viewScores.addActionListener(new ScoresListener());

//set fonts
congratulationsText1.setFont(new Font("Whatever", 1, 18));
congratulationsText2.setFont(new Font("Whatever", 1, 18));
playAgain.setFont(new Font("Whatever", 1, 16));
name.setFont(new Font("Whatever", 1, 18));
yes.setFont(new Font("Whatever", 1, 18));
no.setFont(new Font("Whatever", 1, 18));
clicksNumber.setFont(new Font("Whatever", 1, 16));
clicksLabel.setFont(new Font("Whatever", 1, 16));

//add the stuff to the panel
add(emptySpace1);
add(emptySpace2);
add(congratulationsText1);
add(name);
add(emptySpace3);
add(congratulationsText2);
add(emptySpace4);
add(playAgain);
add(emptySpace5);
add(clicksLabel);
add(clicksNumber);
add(emptySpace7);
add(yes);
add(no);
add(emptySpace6);
add(viewScores);

//set the size of the panel to the WIDTH and HEIGHT constants
setPreferredSize(new Dimension(500, 300));

//set the color of the panel to whatever you choose
setBackground(Color.green);


}


private class StartListener implements ActionListener{
public void actionPerformed (ActionEvent event){
  JFrame frame = new JFrame ("Memory");
  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  ProjectPanel bp = new ProjectPanel();

  frame.getContentPane().add(bp);
  frame.pack();
  frame.setVisible(true);
  GridPanel3.hideFrame();

}
}

private class ExitListener implements ActionListener{
public void actionPerformed (ActionEvent event){
  System.exit(0);
}
}

private class ScoresListener implements ActionListener {
public void actionPerformed (ActionEvent event){

  JFrame scoresFrame = new JFrame ("High Scores");
  scoresFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  ScoresPanel sp = new ScoresPanel(); 

  scoresFrame.getContentPane().add(sp);
  scoresFrame.pack();
  scoresFrame.setVisible(true);
  

}
}
}

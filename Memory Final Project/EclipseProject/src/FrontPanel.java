/*Greg Bjornstad
 * FrontPanel.java
 * Class for Memory Project
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPanel extends JPanel{
  
private static JLabel welcomeLabelText1, welcomeLabelText2, emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;
public static JTextField name;
private JButton ok, exit;
static JFrame gridFrame;

public FrontPanel(){
  
  
//create labels for text
welcomeLabelText1 = new JLabel ("Welcome to Memory!");
welcomeLabelText2 = new JLabel ("Please enter your name: ");
name = new JTextField(15);
emptySpace1 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace2 = new JLabel ("                        ");
emptySpace3 = new JLabel ("                        ");
emptySpace4 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace5 = new JLabel ("                        ");
emptySpace6 = new JLabel ("                        ");
emptySpace7 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace8 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace9 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace10 = new JLabel ("                        ");

//create buttons and add listeners
ok = new JButton("Start Game");
exit = new JButton("Exit");

ok.addActionListener(new StartListener());
exit.addActionListener(new ExitListener());

//set fonts
welcomeLabelText1.setFont(new Font("Whatever", 1, 18));
welcomeLabelText2.setFont(new Font("Whatever", 1, 18));
name.setFont(new Font("Whatever", 1, 18));
ok.setFont(new Font("Whatever", 1, 18));
exit.setFont(new Font("Whatever", 1, 18));

//add the stuff to the panel
add(emptySpace1);
add(emptySpace2);
add(welcomeLabelText1);
add(emptySpace3);
add(emptySpace4);
add(emptySpace5);
add(welcomeLabelText2);
add(emptySpace6);
add(emptySpace7);
add(name);
add(emptySpace8);
add(emptySpace9);
add(ok);
add(emptySpace10);
add(exit);

//set the size of the panel to the WIDTH and HEIGHT constants
setPreferredSize(new Dimension(500, 300));

//set the color of the panel to whatever you choose
setBackground(Color.green);

}

public static String getTextName(){
  return name.getText();
}

public static void hideFrame(){
     gridFrame.setVisible(false);
}

private class StartListener implements ActionListener{
public void actionPerformed (ActionEvent event){
  gridFrame = new JFrame ("Memory"); //(GUI2)
  gridFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  ProjectPanel bp = new ProjectPanel();

  gridFrame.getContentPane().add(bp);
  gridFrame.pack();
  gridFrame.setVisible(true);
  Memory.hideFrame();

}
}

private class ExitListener implements ActionListener{
public void actionPerformed (ActionEvent event){
  System.exit(0);
}
}
}

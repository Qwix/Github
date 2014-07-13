/*Greg Bjornstad
 * May 2012
 * ECS 102 final project
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

    

public class GridPanel3 extends JPanel
{
  
    ImageIcon[] pics = new ImageIcon[17];
    int[] toShuffle = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    ImageIcon nothing = new ImageIcon("nothing.png");
    
    int[] clicked = new int[16];
    
    JButton[] b = new JButton[16];
      
    static JFrame winFrame;
  
   public GridPanel3()
   {
    
     int size = 24;
     for(int i=0; i<16; i++){
      b[i]= new JButton("???");
      clicked[i]=0;
      b[i].setFont(new Font("Whatever", 1, size));
    }
     
    
    
    pics[0] = new ImageIcon (this.getClass().getClassLoader().getResource("Dog.png"));
    pics[1] = new ImageIcon (this.getClass().getClassLoader().getResource("Cat.png"));
    pics[2] = new ImageIcon (this.getClass().getClassLoader().getResource("Tree.png"));
    pics[3] = new ImageIcon (this.getClass().getClassLoader().getResource("Sun.png"));
    pics[4] = new ImageIcon (this.getClass().getClassLoader().getResource("Moon.png"));
    pics[5] = new ImageIcon (this.getClass().getClassLoader().getResource("Volcano.png"));
    pics[6] = new ImageIcon (this.getClass().getClassLoader().getResource("Star.png"));
    pics[7] = new ImageIcon (this.getClass().getClassLoader().getResource("Monkey.png"));
    pics[8] = new ImageIcon (this.getClass().getClassLoader().getResource("Dog.png"));
    pics[9] = new ImageIcon (this.getClass().getClassLoader().getResource("Cat.png"));
    pics[10] = new ImageIcon (this.getClass().getClassLoader().getResource("Tree.png"));
    pics[11] = new ImageIcon (this.getClass().getClassLoader().getResource("Sun.png"));
    pics[12] = new ImageIcon (this.getClass().getClassLoader().getResource("Moon.png"));
    pics[13] = new ImageIcon (this.getClass().getClassLoader().getResource("Volcano.png"));
    pics[14] = new ImageIcon (this.getClass().getClassLoader().getResource("Star.png"));
    pics[15] = new ImageIcon (this.getClass().getClassLoader().getResource("Monkey.png"));
    
    
    
    
    shuffle(toShuffle,16,pics);
    

     
      
      setLayout (new GridLayout (4, 4));

      setBackground (Color.green);
      
      b[0].addActionListener(new ButtonListener1());
      b[1].addActionListener(new ButtonListener2());
      b[2].addActionListener(new ButtonListener3());
      b[3].addActionListener(new ButtonListener4());
      b[4].addActionListener(new ButtonListener5());
      b[5].addActionListener(new ButtonListener6());
      b[6].addActionListener(new ButtonListener7());
      b[7].addActionListener(new ButtonListener8());
      b[8].addActionListener(new ButtonListener9());
      b[9].addActionListener(new ButtonListener10());
      b[10].addActionListener(new ButtonListener11());
      b[11].addActionListener(new ButtonListener12());
      b[12].addActionListener(new ButtonListener13());
      b[13].addActionListener(new ButtonListener14());
      b[14].addActionListener(new ButtonListener15());
      b[15].addActionListener(new ButtonListener16());
     
      
      for(int i=0; i<16; i++){
        add(b[i]);
      }
   }


public static void shuffle ( 
    int[ ] list,/* list to be shuffled */
    int n,// number of elements
    ImageIcon[] pics){ 
  
  Random generator = new Random();
  int size, random;
  int temp = 0;
  size = list.length-1;

  for(int i=size; i>0; i=(i-1)){
    random = generator.nextInt(i + 1);
    temp=list[random];
    list[random]=list[i];
    list[i]=temp;
    pics[n] = pics[random];
    pics[random] = pics[i];
    pics[i] = pics[n];
  }
}

public boolean hasPartner(int i){
  boolean toReturn = false;
  int temp = toShuffle[i];
  if(toShuffle[i]<8){
    for(int j=0; j<16; j++){
      if((toShuffle[j] == (temp+8)) && (clicked[j] == 1)){
        toReturn = true;
      }
    }
  }else if(toShuffle[i]>8){
    for(int j=0; j<16; j++){
      if((toShuffle[j] == (temp-8)) && (clicked[j] == 1)){
        toReturn = true;
      }
    }
  }
  return toReturn;
}
        

public static void hideFrame(){
     winFrame.setVisible(false);
}
  

private class ButtonListener1 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();


//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if(clicked[i]==1 && clicked[j]==1){
      if((hasPartner(i) == false) && (hasPartner(j) == false)){
        b[i].setIcon(nothing);
        b[i].setText("???");
        clicked[i]=0;
        b[j].setIcon(nothing);
        b[j].setText("???");
        clicked[j]=0;
      }
    }
  }
}


//show a picture
b[0].setIcon(pics[0]);
b[0].setText("");

//press this button
clicked[0] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");//(GUI3)
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}

}
}

private class ButtonListener2 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();


//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}


//show a picture
b[1].setIcon(pics[1]);
b[1].setText("");

       clicked[1] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
       
}
}

private class ButtonListener3 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[2].setIcon(pics[2]);
b[2].setText("");

       clicked[2] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener4 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[3].setIcon(pics[3]);
b[3].setText("");

       clicked[3] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener5 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[4].setIcon(pics[4]);
b[4].setText("");

       clicked[4] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener6 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[5].setIcon(pics[5]);
b[5].setText("");

       clicked[5] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener7 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[6].setIcon(pics[6]);
b[6].setText("");

       clicked[6] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener8 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[7].setIcon(pics[7]);
b[7].setText("");

       clicked[7] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener9 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[8].setIcon(pics[8]);
b[8].setText("");

       clicked[8] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener10 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[9].setIcon(pics[9]);
b[9].setText("");

       clicked[9] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener11 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[10].setIcon(pics[10]);
b[10].setText("");

       clicked[10] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener12 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}


//show a picture
b[11].setIcon(pics[11]);
b[11].setText("");

       clicked[11] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener13 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[12].setIcon(pics[12]);
b[12].setText("");

       clicked[12] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener14 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[13].setIcon(pics[13]);
b[13].setText("");

       clicked[13] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener15 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[14].setIcon(pics[14]);
b[14].setText("");

       clicked[14] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}

private class ButtonListener16 implements ActionListener{
public void actionPerformed (ActionEvent event){

//add a click
WordsPanel.addClicks();

//remove other pictures
for(int i=0; i<16; i++){
  for(int j=(i+1); j<16; j++){
    if((clicked[i]==1 && clicked[j]==1) && (!(hasPartner(i)) && !(hasPartner(j)))){
      b[i].setIcon(nothing);
      b[i].setText("???");
      clicked[i]=0;
      b[j].setIcon(nothing);
      b[j].setText("???");
      clicked[j]=0;
    }
  }
}

//show a picture
b[15].setIcon(pics[15]);
b[15].setText("");

       clicked[15] = 1;
       
//win code
if((clicked[0]==1) && (clicked[1]==1) && (clicked[2]==1) && (clicked[3]==1) && 
   (clicked[4]==1) && (clicked[5]==1) && (clicked[6]==1) && (clicked[7]==1) && 
   (clicked[8]==1) && (clicked[9]==1) && (clicked[10]==1) && (clicked[11]==1) && 
   (clicked[12]==1) && (clicked[13]==1) && (clicked[14]==1) && (clicked[15]==1)){
  winFrame = new JFrame ("WinPanel");
  winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  WinPanel bp = new WinPanel();

  winFrame.getContentPane().add(bp);
  winFrame.pack();
  winFrame.setVisible(true);
  FrontPanel.hideFrame();
}
}
}


}

import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoresPanel extends JPanel{
  
private static JLabel clicksText, namesText, emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;
private static JLabel clicks1, clicks2, clicks3, clicks4, clicks5;
private static JLabel names1, names2, names3, names4, names5, names6;
private String temp, junk;
private static JLabel[] namesArray = new JLabel[6];
private static double[] clicksArray = new double[6];
 

public ScoresPanel(){
  
  
//create labels for text
namesText = new JLabel ("Name");
clicksText = new JLabel ("Clicks");
emptySpace1 = new JLabel ("          ");
emptySpace2 = new JLabel ("          ");
emptySpace3 = new JLabel ("          ");
emptySpace4 = new JLabel ("          ");
emptySpace5 = new JLabel ("          ");
emptySpace6 = new JLabel ("                        ");
emptySpace7 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace8 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace9 = new JLabel ("                                                                                                                                                                                                                      ");
emptySpace10 = new JLabel ("                  ");

try
{
 Scanner reader = new Scanner(new File("HighScores.txt")); //(I/O)
 
      names1 = new JLabel (reader.nextLine()); 
      temp = Integer.toString(reader.nextInt());
      junk = reader.nextLine();
      clicks1 = new JLabel (temp);
      names2 = new JLabel (reader.nextLine());
      temp = Integer.toString(reader.nextInt());
      junk = reader.nextLine();
      clicks2 = new JLabel (temp);
      names3 = new JLabel (reader.nextLine());
      temp = Integer.toString(reader.nextInt());
      junk = reader.nextLine();
      clicks3 = new JLabel (temp);
      names4 = new JLabel (reader.nextLine()); 
      temp = Integer.toString(reader.nextInt());
      junk = reader.nextLine();
      clicks4 = new JLabel (temp);
      names5 = new JLabel (reader.nextLine()); 
      temp = Integer.toString(reader.nextInt());
      clicks5 = new JLabel (temp);
}
catch (IOException exception)
{}

names6 = new JLabel("");

namesArray[0] = names1;
namesArray[1] = names2;
namesArray[2] = names3;
namesArray[3] = names4;
namesArray[4] = names5;
namesArray[5] = names6;

clicksArray[0] = Double.parseDouble(clicks1.getText());
clicksArray[1] = Double.parseDouble(clicks2.getText());
clicksArray[2] = Double.parseDouble(clicks3.getText());
clicksArray[3] = Double.parseDouble(clicks4.getText());
clicksArray[4] = Double.parseDouble(clicks5.getText());
clicksArray[5] = 1000.0;

parallel_sortDouble(clicksArray, clicksArray.length, namesArray, namesArray.length);//(ORD)

namesArray[5].setText(FrontPanel.getTextName());
clicksArray[5] = Integer.parseInt(WordsPanel.getClicks());

parallel_sortDouble(clicksArray, clicksArray.length, namesArray, namesArray.length);

names1 = namesArray[0];
names2 = namesArray[1];
names3 = namesArray[2];
names4 = namesArray[3];
names5 = namesArray[4];

clicks1.setText(Integer.toString((int)clicksArray[0]));
clicks2.setText(Integer.toString((int)clicksArray[1]));
clicks3.setText(Integer.toString((int)clicksArray[2]));
clicks4.setText(Integer.toString((int)clicksArray[3]));
clicks5.setText(Integer.toString((int)clicksArray[4]));



//set fonts
//congratulationsText1.setFont(new Font("Whatever", 1, 18));


//add the stuff to the panel
add(emptySpace9);
add(namesText);
add(emptySpace10);
add(clicksText);



  add(names1);
  add(emptySpace1);
  add(clicks1);
  add(names2);
  add(emptySpace2);
  add(clicks2);
  add(names3);
  add(emptySpace3);
  add(clicks3);
  add(names4);
  add(emptySpace4);
  add(clicks4);
  add(names5);
  add(emptySpace5);
  add(clicks5);

//set the size of the panel to the WIDTH and HEIGHT constants
setPreferredSize(new Dimension(175, 300));

//set the color of the panel to whatever you choose
setBackground(Color.green);




}


public static void parallel_sortDouble (double[] doubleArray, int doubleN, JLabel[] labelArray, int intN)

    {
    int to_fill; // subscript of last 
                 //element of unsorted array
    int index_of_max; //index of greatest 
                      //element in unsorted array 
    
    //for to_fill = n-1 (whole array unsorted) down to to_fill = 1 
     //(remaining 2 elements need to be put in order) 
    for (to_fill=doubleN-1; to_fill>=1; to_fill--)
    {
     //Find position of greatest element in unsorted array.
     index_of_max=get_max_range(doubleArray, 0, to_fill);
     //Swap it with the element at end of unsorted array.
     {
     //swap(&list[index_of_max],&list[to_fill]);
     
     double tempDouble;
     tempDouble=doubleArray[index_of_max];
     doubleArray[index_of_max]=doubleArray[to_fill];
     doubleArray[to_fill]=tempDouble;
     
     JLabel tempLabel;
     tempLabel=labelArray[index_of_max];
     labelArray[index_of_max]=labelArray[to_fill];
     labelArray[to_fill]=tempLabel;
     }
   }
 }


private static int get_max_range( 
                     double[] list,  // the array we are    
                                   //looking in 
                     int first,    // the index of the 
                          //first element we will look at 
                     int last     // the index of the     
                           //last element we will look at 
                     )
    {
    int i;
    int index_of_max;
    index_of_max = first;
    //for each value of i from first+1 to last
    for (i=first+1; i<=last; i++)
    //if list[i] is greater than list[index_of_max]
     if (list[i]>list[index_of_max])
        //update index_of_max to i
      index_of_max=i;
    return index_of_max;
    } // end get_max_range


}
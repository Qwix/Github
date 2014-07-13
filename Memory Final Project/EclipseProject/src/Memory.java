/******************************************
*                                         
* Official Name:  Greg Bjornstad
*                                         
* Nickname:  Greg                 
*                                         
* E-mail:  gebjorns@syr.edu 
*                                         
* Final Project: Memory Game        
*                                         
* Compiler:  drJava on a pc (or mac)               
*                                         
* Date:  May 3, 2011              
*                                         
*******************************************/

import javax.swing.*;

public class Memory
{
	
  static JFrame frontPanel;

   public static void main (String[] args)
   {
	   frontPanel = new JFrame ("Intro"); //(GUI1)
	   frontPanel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      FrontPanel bp = new FrontPanel();

      frontPanel.getContentPane().add(bp);
      frontPanel.pack();
      frontPanel.setVisible(true);
      
      
   }
   
   public static void hideFrame(){
	   frontPanel.setVisible(false);
   }
   
}

/*Pictures Used
 * Cat: http://www.yupedia.com/wp-content/uploads/2012/02/what-are-the-features-of-the-cartoon-cats.jpg
 * Dog: http://www.pictures19.com/wp-content/pictures/2012/03/cute-cartoon-dog.jpg
 * Tree: http://www.gardeningsite.com/wp-content/uploads/2009/07/tree-cartoon.jpg
 * Sun: http://www.bostonbakesforbreastcancer.org/wp-content/uploads/2012/03/sun.jpg
 * Moon: http://us.cdn3.123rf.com/168nwm/shadowstudio/shadowstudio1101/shadowstudio110100038/8750349-friends-forever--cartoon-moon-and-star.jpg
 * Monkey: http://2.bp.blogspot.com/_N_mOB63qPaE/TSijzaE2INI/AAAAAAAARjA/YSsTUY5vNx4/s1600/Cartoon-monkey-Photo.png
 * Star: http://bestclipartblog.com/clipart-pics/stars-clipart-3.png
 * Volcano: http://www.scienceclips.net/geology/volcanoes/volcano3.gif
 */
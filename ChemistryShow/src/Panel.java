import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Panel extends JPanel{
	
	private static JLabel hello, letters, numbers, emptySpace1, emptySpace2;
	private static JTextField sentence;
	private JButton go;
	private Chemistry c;
	private String greeting = "<html><center>Welcome to my chemistry converter!<br>Type something into the box and see what happens.</center></html>";
	
	public Panel(){
		hello = new JLabel(greeting);
		sentence = new JTextField("",25);
		letters = new JLabel();
		numbers = new JLabel();
		emptySpace1 = new JLabel("     ");
		emptySpace2 = new JLabel("     ");
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//create buttons and add listeners
		go = new JButton("Go!");
		
		go.addActionListener(new StartListener());
		sentence.addActionListener(new StartListener());
		
		sentence.setFont(new Font("Comic Sans", 1, 20));
		hello.setFont(new Font("Whatever", 1, 16));
		go.setFont(new Font("Whatever", 1, 30));
		letters.setFont(new Font("Courier New", 1, 14));
		numbers.setFont(new Font("Courier New", 1, 14));
		
		sentence.setMinimumSize(new Dimension(450,35));
		
		
		
		c.gridx = 1;
		c.gridy = 0;
		add(hello, c);
		
	    c.gridx = 1;
	    c.gridy = 1;
	    add(sentence,c);
	    
	    c.gridx = 1;
	    c.gridy = 2;
	    add(emptySpace1,c);
	    
	    c.gridx = 1;
	    c.gridy = 3;
	    add(letters, c);
	    
	    c.gridx = 1;
	    c.gridy = 4;
	    add(numbers, c);
	    
	    c.gridx = 1;
	    c.gridy = 5;
	    add(emptySpace2,c);
	    
	    c.gridx = 1;
	    c.gridy = 6;
	    add(go, c);
	    
	    InputMap im = go.getInputMap();
	    im.put( KeyStroke.getKeyStroke( "ENTER" ), "pressed" );
	    im.put( KeyStroke.getKeyStroke( "released ENTER" ), "released" );
	    
		go.requestFocusInWindow();
		
		setPreferredSize(new Dimension(1000, 500));
		setBackground(Color.cyan);
		
	}
	
	private class StartListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			c = new Chemistry(sentence.getText());
			
			hello.setText("I hope you enjoy it!");
			sentence.setText("");
			
			letters.setText(c.getLetters());
			numbers.setText(c.getNumbers());
		}
	}
}
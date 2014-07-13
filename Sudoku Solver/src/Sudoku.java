/**Created by Greg Bjornstad
 * January 2014
 * for fun and profit
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class Sudoku{
	
	
	static JFrame frontPanel;
	int[][] finalGrid = new int[9][9];
	
	public static void main(String[] args){
		
		frontPanel = new JFrame ("Sudoku"); //(GUI1)
		frontPanel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Sudoku s = new Sudoku();
		Panel bp = s.new Panel();
		
		frontPanel.getContentPane().add(bp);
	    frontPanel.pack();
	    frontPanel.setVisible(true);	
	}
	
	
	
	@SuppressWarnings("serial")
	public class Panel extends JPanel{
		
		private JButton go = new JButton("GO!"), reset = new JButton("Reset");
		public JFormattedTextField[][] grid = new JFormattedTextField[9][9];
		private JLabel greeting = new JLabel("Enter some numbers and press go.");
		JSeparator hLine1 = new JSeparator(JSeparator.HORIZONTAL), vLine1 = new JSeparator(JSeparator.VERTICAL),
				   hLine2 = new JSeparator(JSeparator.HORIZONTAL), vLine2 = new JSeparator(JSeparator.VERTICAL);
		
		
		public Panel(){
			
			
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					grid[i][j] = new JFormattedTextField(NumberFormat.getInstance()); //initialize the grid to contain nothing
					grid[i][j].setPreferredSize(new Dimension(40,40));//set textbox size
					grid[i][j].setFont(new Font("BESTFONTEVER",1,35));//set font size
				}
			}
			
			setLayout(new GridBagLayout());
			GridBagConstraints panelGrid = new GridBagConstraints();
			
			go.addActionListener(new StartListener());
			reset.addActionListener(new ResetListener());
			
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					grid[i][j].addActionListener(new StartListener());
				}
			}
			
			panelGrid.gridwidth= 6;
			panelGrid.gridx = 3;
			panelGrid.gridy = 0;
			add(greeting, panelGrid);
			
			
			panelGrid.insets.set(5, 5, 5, 5);
			panelGrid.gridwidth = 1;
			for(int i=1; i<12; i++){
				for(int j=2; j<13; j++){
					if((i!=4)&&(i!=8)&&(j!=5)&&(j!=9)){ //skips over separators
						if(i<4){
							if(j<5){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-1][j-2], panelGrid);
							}else if(j<9){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-1][j-3], panelGrid);
							}else if(j<13){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-1][j-4], panelGrid);
							}
						}else if(i<8){
							if(j<5){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-2][j-2], panelGrid);
							}else if(j<9){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-2][j-3], panelGrid);
							}else if(j<13){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-2][j-4], panelGrid);
							}
						}else if(i<12){
							if(j<5){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-3][j-2], panelGrid);
							}else if(j<9){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-3][j-3], panelGrid);
							}else if(j<13){
								panelGrid.gridx = i;
								panelGrid.gridy = j;
								add(grid[i-3][j-4], panelGrid);
							}
						}
					}
				}
			}
			
			panelGrid.insets.set(0,0,0,0);
			hLine1.setPreferredSize(new Dimension(450,1));
			panelGrid.gridwidth = 13;
			panelGrid.gridx = 0;
			panelGrid.gridy = 5;
			panelGrid.fill = GridBagConstraints.VERTICAL;
			panelGrid.weighty = 1;
			add(hLine1, panelGrid);
			
			hLine2.setPreferredSize(new Dimension(450,1));
			panelGrid.gridx = 0;
			panelGrid.gridy = 9;
			panelGrid.fill = GridBagConstraints.VERTICAL;
			panelGrid.weighty = 1;
			add(hLine2, panelGrid);
			
			vLine1.setPreferredSize(new Dimension(1,450));
			panelGrid.gridheight = 12;
			panelGrid.gridwidth = 1;
			panelGrid.gridx = 4;
			panelGrid.gridy = 1;
			panelGrid.fill = GridBagConstraints.HORIZONTAL;
			panelGrid.weightx = 1;
			add(vLine1, panelGrid);
			
			vLine2.setPreferredSize(new Dimension(1,450));
			panelGrid.gridx = 8;
			panelGrid.gridy = 1;
			panelGrid.fill = GridBagConstraints.HORIZONTAL;
			panelGrid.weightx = 1;
			add(vLine2, panelGrid);
			
			panelGrid.gridwidth = 2;
			panelGrid.gridx = 2;
			panelGrid.gridy = 13;
			add(go, panelGrid);
			
			panelGrid.gridwidth = 2;
			panelGrid.gridx = 9;
			panelGrid.gridy = 13;
			add(reset, panelGrid);
			
			
			InputMap im = go.getInputMap();
		    im.put( KeyStroke.getKeyStroke( "ENTER" ), "pressed" );
		    im.put( KeyStroke.getKeyStroke( "released ENTER" ), "released" );
		    
			go.requestFocusInWindow();
			
			setPreferredSize(new Dimension(470, 550));
			setBackground(Color.cyan);
			
		}
		
		
		private class StartListener implements ActionListener{
			public void actionPerformed (ActionEvent event){
				int[][] toSolve = new int[9][9];
				
				
				//sets all the text to 0 if you didnt fill in a number
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						if(grid[i][j].getText().equals("")){
							grid[i][j].setText("0");
						}
					}
				}
				
				//sets the values of the array we'll be working with from the panel
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						toSolve[i][j] = Integer.parseInt(grid[i][j].getText());
					}
				}
				
				//calls Solve() and then changes the textboxes to match the solved puzzle
				if(solve(0,0,toSolve)){
					greeting.setText("Press Reset to solve another one");
				}else{
					greeting.setText("No valid solution");	
				}
				
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						grid[i][j].setText(Integer.toString(finalGrid[i][j])); 
					}
				}
			}
		}
	
	
		private class ResetListener implements ActionListener{
			public void actionPerformed (ActionEvent event){
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						finalGrid[i][j] = 0;
						grid[i][j].setText("");
					}
				}
			}
		}
	}
	
	
	public boolean solve(int i, int j, int[][] gridTest) {
        if (i == 9) { //if we're too far right
        	j++;	//move down one
            i = 0;	//move all the way left
            if (j == 9){ //if we're too far down
                return true; //stop solving
            }
        }
        
        if (gridTest[i][j] != 0){  // skip filled cells
            return solve(i+1,j,gridTest); //move right and retry
        }
        
        for (int k = 1; k <= 9; k++) {
            if (valid(gridTest,i,j,k)) { //if the new guess works
            	gridTest[i][j] = k; //put it in
                if (solve(i+1,j,gridTest)) 
                    return true; //if it all solves return true
            }
        }
        
        gridTest[i][j] = 0; // reset if we've tried 1-9 on this spot
        
        finalGrid = gridTest;
        return false; //end this thread
    }
	
	//tests if guess is valid
	public boolean valid(int[][] gridTest,int i, int j, int k){
		return (validRow(gridTest,i,k))&&(validCol(gridTest,j,k))&&(validBox(gridTest,i-i%3,j-j%3,k));
	}
	
	//tests if row is valid
	public boolean validRow(int[][] gridTest, int row, int num){
		for(int col = 0; col < 9; col++){
			if(gridTest[row][col] == num){
				return false;
			}
		}
		return true;
	}
	
	//tests if column is valid
	public boolean validCol(int[][] gridTest, int col, int num){
		for(int row = 0; row < 9; row++){
			if(gridTest[row][col] == num){
				return false;
			}
		}
		return true;
	}
	
	//tests if box is valid
	public boolean validBox(int[][] gridTest, int row, int col, int num){
		int boxRowOffset = (row/3) * 3; //make rows and cols multiples of 3
        int boxColOffset = (col/3) * 3;
        for (int k=0; k<3; k++){
            for (int m=0; m<3; m++){
                if (num == gridTest[boxRowOffset+k][boxColOffset+m]){
                    return false;
                }
            }
        }
		return true;
	}
	
}
import javax.swing.JFrame;


public class ChemistryConverter {
	
	static JFrame frontPanel;
	
	public static void main(String[] args){
		
		frontPanel = new JFrame ("ChemistryConverter"); //(GUI1)
		frontPanel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		Panel bp = new Panel();
		
		
		frontPanel.getContentPane().add(bp);
	    frontPanel.pack();
	    frontPanel.setVisible(true);
	    
		
		}
	   
	public static void hideFrame(){
		frontPanel.setVisible(false);
	}
}

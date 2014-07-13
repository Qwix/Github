/**Greg Bjornstad
 * Homework 9
 * Driver.java
 * For use with Tree.java and Node.java
 * created 3/8/13
 * edited 3/29/13 - 4/3/13
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args){

		//declaring variables
		Scanner reader = new Scanner(System.in);
		int nodes, nodeVal, nodeCounter = 0;
		BST t;
		
		//Option to comment out the user input section and use the driver defined
		//array, or vice versa! Aren't options great?
		
		//*************************User Input******************************
		//user input for the size of the tree (could use an array just as easily)
		System.out.print("How many spaces do you want in your binary search tree?: ");
		nodes = reader.nextInt();
		
		t = new BST(nodes);
		
		//user input to fill up the array
		System.out.println("Enter up to " + nodes + " integers for your tree, or any non-int to break early: ");
		
		for(int i=0; i<nodes; i++){
			try{
				try{
				nodeVal = reader.nextInt();
				i -= t.addBinary(nodeVal, nodeCounter, 0);
				nodeCounter++;
				}catch (ArrayIndexOutOfBoundsException f){
					System.out.println("Not added: Not enough space.");
					i--;
				}
			}catch (InputMismatchException e){
				reader.nextLine();
				break;
			}
		}
		//*************************End User Input******************************
		
		
		/*************************Driver-Defined Array******************************
		int[] driverDefined = {10,15,12,17,5,2,7};
		nodeCounter = driverDefined.length;
		t = new BST(nodeCounter);
		
		for(int i=0; i<nodeCounter; i++){
			i -= t.addBinary(driverDefined[i], i, 0);
		}
		//*************************End Driver-Defined Array******************************/
		
		//output the whole tree in array form as the question asked
		Object[] treeOutput = t.getArrayValues();
		
		System.out.println("\nThe tree in array form is:");
		for(int i=0; i<treeOutput.length; i++){
			System.out.print(treeOutput[i] + " ");
		}
		
		//do an inorder traversal of the tree and put it in a new array
		int[] ra = t.inOrder(t.getNode(0));
		
		//output the inorder traversal array
		System.out.println("\n\nThe inorder traversal is:");
		for(int i=0; i<nodeCounter; i++){
			System.out.print(ra[i] + " ");
		}
		
		
		//option to search for a node in the search tree
		System.out.print("\n\nWould you like to search for a specific payload value? (y/n): ");
		String searchQuestion = "y";
		searchQuestion = reader.next();
		
		while(!searchQuestion.equals("n")){
			System.out.print("\nEnter an int to search for: ");
			int toSearch = reader.nextInt();
			
			t.setVisitedZero();
			int nodesVisited = t.search(toSearch, 0);
			
			System.out.println("The search visited " + nodesVisited + " nodes in its duration.\n");
			System.out.print("Would you like to search again? (y/n): ");
			searchQuestion = reader.next();
		}
		System.out.print("\nExiting.");
	}
}

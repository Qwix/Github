/**Greg Bjornstad
 * Homework 9
 * Node.java
 * For use with Tree.java or BST.java
 * created 3/8/13
 */

//Node class for storing in a tree
public class Node{
	
	//private instance variables
	private int value, index, parentIndex, height;
	private Object leftChild, rightChild;
	
	//constructor
	public Node(int val, int ind, int par, Object left, Object right, int h){
		value = val;
		index = ind;
		parentIndex = par;
		leftChild = left;
		rightChild = right;
		height = h;
	}
	
	//all the getters/setters for node values
	public int getVal(){
		return value;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int getParent(){
		return parentIndex;
	}
	
	public Object getLeft(){
		return leftChild;
	}
	
	public Object getRight(){
		return rightChild;
	}
	
	public void setVal(int v){
		value = v;
	}
	
	public void setLeft(int left){
		leftChild = left;
	}
	
	public void setRight(int right){
		rightChild = right;
	}
	
	//output all the relevant data in a node
	public String toString(){
		
		//setting the parent of the root node to null
		Object parentReturn = null;
		if(parentIndex != -1){
			parentReturn = parentIndex;
		}
		
		//Fixing a bug caused by the try/catch exception loop breaking
		if(leftChild == (Object)index){
			leftChild = null;
		}
		
		String toReturn = "Value is " + value + ", index is " + index + ", parent index is " + parentReturn + ", left child index is " + 
						   leftChild + ", right child index is " + rightChild + ", and height is " + height + ".";
		return toReturn;
	}
}

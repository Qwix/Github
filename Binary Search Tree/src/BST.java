/**Greg Bjornstad
 * Homework 9
 * BST.java
 * For use with Node.java
 * created 3/8/13
 * edited 3/29/13 - 4/3/13
 */

public class BST{
	
	//initialize an array of Nodes
	private Node[] ra;
	private int maxNodes;
	private int toAdd = 0; //used with the addBinary method
	private int addNode = 0; //used with the inOrder method
	private int[] toReturn; //used with the inOrder method
	private int nodesVisited = 0; //used with search method
	
	
	//user-input constructor
	public BST(int nodes){
		maxNodes = nodes;
		ra = new Node[maxNodes];
		toReturn = new int[maxNodes];
	}
	
	
	//adds a node to a binary search tree...can be used with arrays or with user input
	public int addBinary(int val, int nodeCounter, int root){
		
		Node n;
		toAdd = 0;
		
		int height = (int)((Math.log(nodeCounter + 1))/(Math.log(2))) + 1;
		
		//special case with the parent of the root node
		if(nodeCounter == 0){
			n = new Node(val, 0, -1, null, null, height);
			ra[0] = n;
			System.out.println("added root");
			
		//everything else	
		}else{
			int i = root;
			for(int j=0; j<maxNodes;){
				
				//if the node is less than the root
				if((getNode(i) != null) && (val < getNode(i).getVal())){
					if(getNode(i).getLeft() == null){
						n = new Node(val, (i*2+1), i, null, null, height+1);
						getNode(i).setLeft(i*2+1); //set this node's child pointer		
						ra[(i*2+1)] = n; //add in a left child
						System.out.println(val + " < " + getNode(i).getVal() + " so move down left.");
						System.out.println("added left child"); //output to know what's going on
						break;
					}else{
						System.out.println(val + " < " + getNode(i).getVal() + " so move down left.");
						addBinary(val, nodeCounter, i*2+1); //RECURSION to change the root and start over
						break;
					}
					
				//if the node is greater than the root
				}else if((getNode(i) != null) && (val > getNode(i).getVal())){
					if(getNode(i).getRight() == null){
						n = new Node(val, (i*2+2), i, null, null, height+1);
						getNode(i).setRight(i*2+2); //set this node's child pointer
						ra[(i*2+2)] = n; //add in a right child
						System.out.println(val + " > " + getNode(i).getVal() + " so move down right.");
						System.out.println("added right child"); //output to know whats going on
						break;
					}else{
						System.out.println(val + " > " + getNode(i).getVal() + " so move down right.");
						addBinary(val, nodeCounter, i*2+2); //RECURSION to change the root and start over
						break;
					}
				}else{ //if it's neither smaller nor greater than the int in its place
					System.out.println("Not added: int already exists in the tree.\nEnter any non-int to break early.");
					toAdd++;
					break;
				}
			}	
		}
		//return used to subtract one from the counter in the driver if nothing was added
		return toAdd;
	}
	
	//inorder traversal method...now with RECURSION!
	public int[] inOrder(Node root){
		
		//visit left node
		if((root.getIndex()*2+1 < ra.length) && (root.getLeft() != null)){
			inOrder(ra[(Integer)root.getLeft()]);
		}
		
		//add a node
		toReturn[addNode] = (root.getVal());
		addNode++;
		
		//visit right node
		if((root.getIndex()*2+2 < ra.length) && (root.getRight() != null)){
			inOrder(ra[(Integer)root.getRight()]);
		}
		
		return toReturn;
	}
	
	//binary search function...with more RECURSION! WOO!
	public int search(int input, int root){
		
		//if input is less than the value at the node with index root
		if((root*2+1 < ra.length) && (ra[root*2+1] != null) && (input < ra[root].getVal())){
			//search left child
			System.out.println(input + "<" + ra[root].getVal() + " so search left child");
			nodesVisited++;
			search(input, root*2+1); //recursively move and search again
			
		//if input is greater than the value at the node with index root
		}else if((root*2+2 < ra.length) && (ra[root*2+2] != null) && (input > ra[root].getVal())){
			//search right child
			System.out.println(input + ">" + ra[root].getVal() + " so search right child");
			nodesVisited++;
			search(input, root*2+2); //recursively move and search again
			
		////if input is equal to the value at the node with index root
		}else if(input == ra[root].getVal()){
			System.out.println("Found it!");
			nodesVisited++;
		}else{
			System.out.println("Didn't find it.");
			nodesVisited++;
		}
		return nodesVisited;
	}
	
	//sets nodesVisited back to 0
	public void setVisitedZero(){
		nodesVisited = 0;
	}
	
	//returns a specified node
	public Node getNode(int number){
		return ra[number];
	}
	
	//returns a value at an index specified by the driver
	public int getValue(int index){
		return ra[index].getVal();
	}
	
	//returns maximum size of the array
	public int size(){
		return ra.length;
	}
	
	//returns the whole tree in node form
	public Node[] getArray(){
		return ra;
	}
	
	//returns the whole tree in payload value form
	public Object[] getArrayValues(){
		Object[] toReturn = new Object[ra.length];
		for(int i=0; i<ra.length; i++){
			try{
				toReturn[i] = ra[i].getVal();
			}catch (NullPointerException e){
				toReturn[i] = null;
			}
		}
		return toReturn;
	}
	
}

/**Created by Greg Bjornstad
 * 3/28/13
 * for fun and profit
 */


public class Chemistry {
	
	//array of all the elements ever
	private String[] elements={
			   "H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P",
			   "S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu",
			   "Zn","Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc",
			   "Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","La",
			   "Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
			   "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Ti","Pb","Bi","Po",
			   "At","Rn","Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf",
			   "Es","Fm","Md","No","Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg",
			   "Uub","Uut","Uuq","Uup","Uuh","Uus","Uuo"};
	
	private String[] str;
	
	
	
	public Chemistry(String s){
		String input = s;
		
		//split the input into an array of chars for easy manipulation
		char[] split = input.toCharArray();
		
		//take out all the spaces from the input
		for(int i=0; i<split.length; i++){
			if(split[i] == (' ')){
				for(int j=i+1; j<split.length; j++){
					split[j-1] = split[j];
				}
				
				//reducing the size of the array for each space
				char[] rb; //create a new array
				rb = new char[split.length-1]; //allocate space for old array -1
				for(int k=0; k<split.length-1; k++){ 
					rb[k] = split[k]; //copy the old array to the new array
				}
				split = rb; //the old array now has one fewer space
			}
		}
		
		//copy the array of chars into an array of strings for
		//comparing with the array of elements
		str = new String[split.length];
		for(int i=0; i<split.length; i++){
			str[i] = String.valueOf(split[i]);
		}
	}
	
	
	
	
	//returns all the element letters in string form
	public String getLetters(){
		String finalString = ""; //will be the output eventually
		for(int i=0; i<str.length; i++){
			String nextTwo = ""; //next 2 values for double letter element comparison
			try{
				nextTwo = str[i] + str[i+1];
				//try/catch needed for the last letter only
			}catch (IndexOutOfBoundsException e){}
			
			//variables needed for comparisons
			boolean foundOne = false;
			boolean storage = false;
			String inStorage = "";
			
			for(int j=0; j<elements.length; j++){
				
				//if the next two equal an element
				if(nextTwo.equalsIgnoreCase(elements[j])){
					finalString += (elements[j] + "  "); //add them
					i++; //don't care about next cause we found two
					foundOne = true;
					break;
					
					//if the next one equals an element
				}else if(str[i].equalsIgnoreCase(elements[j])){
					//found a match but puts it in storage in case we don't find
					//any doubles, and keeps looking for doubles
					inStorage = (elements[j]);
					storage = true;
					
					//if we don't have doubles and we have one in storage
				}else if ((j==elements.length-1) && (storage == true)){
					finalString += (inStorage + "   ");
					
					//if there are no matches anywhere
				}else if ((j==elements.length-1) && (foundOne == false)){
					finalString += ("~" + str[i] + "  ");
				}

			}
		}
		//output
		return finalString;
	}
	
	
	
	
	
	//returns all the element numbers in string form
	public String getNumbers(){
		
		String elementNumbers = ""; //for element identification
		for(int i=0; i<str.length; i++){
			String nextTwo = ""; //next 2 values for double letter element comparison
			try{
				nextTwo = str[i] + str[i+1];
				//try/catch needed for the last letter only
			}catch (IndexOutOfBoundsException e){}
			
			//variables needed for comparisons
			boolean foundOne = false;
			boolean storage = false;
			String numberStorage = "";
			
			for(int j=0; j<elements.length; j++){
				
				//if the next two equal an element
				if(nextTwo.equalsIgnoreCase(elements[j])){
					elementNumbers += (j+1);
					
					//getting the right amount of spaces for output
					if((j+1) < 10){
						elementNumbers += ("   ");
					}else if((j+1) < 100){
						elementNumbers += ("  ");
					}else{
						elementNumbers += (" ");
					}
					
					i++; //don't care about next cause we found two
					foundOne = true;
					break;
					
					//if the next one equals an element
				}else if(str[i].equalsIgnoreCase(elements[j])){
					//found a match but puts it in storage in case we don't find
					//any doubles, and keeps looking for doubles
					numberStorage = (Integer.toString(j+1));
					storage = true;
					
					//if we don't have doubles and we have one in storage
				}else if ((j==elements.length-1) && (storage == true)){
					elementNumbers += (numberStorage);
					
					//getting the right amount of spaces for output
					if(Integer.parseInt(numberStorage) < 10){
						elementNumbers += ("   ");
					}else if(Integer.parseInt(numberStorage) < 100){
						elementNumbers += ("  ");
					}else{
						elementNumbers += (" ");
					}
					
					//if there are no matches anywhere
				}else if ((j==elements.length-1) && (foundOne == false)){
					elementNumbers += ((0) + "   ");
				}

			}
		}
		//output
		return elementNumbers;
	}
	
}

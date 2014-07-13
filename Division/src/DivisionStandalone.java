/*Created by Greg Bjornstad
 * 1/14/14
 */

import java.util.Scanner;

public class DivisionStandalone{
	private static double multiplyUp = 1.5, multiplyDown = 0.5;
	private static int count = 0;
	
	private static double search(double a, double b, double i){
		if(i*b < a){ //if the answer is greater than 1
			while(((i*multiplyUp)*b) > a){ //if the next guess will be too high
				multiplyUp = ((multiplyUp - 1) * 0.5) + 1; //make the multiplier slightly smaller
			}
			i *= multiplyUp; //make the next guess
			System.out.println(i); //print the next guess
			
		}else if(i*b > a){ //if the answer is less than 1
			while(((i*multiplyDown)*b) < a){ //if the next guess will be too low
				multiplyDown = 1 - ((1 - multiplyDown) * 0.5); //make the multiplier slightly bigger
			}
			i *= multiplyDown; //make the next guess
			System.out.println(i); //print the next guess
		}
		while((i*b != a) && (count < 1000)){ //recursively do it again until you find the number.
			count++; //to break rare infinite loops
			i = search(a,b,i);
		}
		return i; 
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		double i; //first guess at the number
		String answer = "y";
		
		while(answer.equals("y")){
			i = 1;
			
			System.out.print("Enter a number: ");
			double a = reader.nextDouble();
			System.out.print("Enter a number to divide the first one by: ");
			double b = reader.nextDouble();
		
			i = search(a,b,i);
			
			System.out.print(a + "/" + b + " = " + i + "\nAgain? (y/n): "); //output
			answer = reader.next();
		}
	}
}
// removed because of non- usage import java.util.*;
import javax.swing.JOptionPane;

class StringDemo
{
	public static void main(String[] args)
	{
	// no longer nessescary	Scanner keyboard = new Scanner(System.in);
		

		String input= JOptionPane.showInputDialog("Enter a string: ");
	// this was before recoding to GUI	input = keyboard.nextLine();
	
	// program modified for instructor exercise below	
		int count = input.length();
		
	// before coding to GUI	System.out.println("You entered: " + input);
		JOptionPane.showMessageDialog(null, "You Typed : \"" + input 
				+ "\" and it is " + count +   // this is continued from above line and continues below
				" characters long"); // continued from previous line
	
	}
}
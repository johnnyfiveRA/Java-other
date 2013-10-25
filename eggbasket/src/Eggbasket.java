import javax.swing.JOptionPane;

public class Eggbasket
{
	public static void main(String[] args)
	{
		int numberOfBaskets, eggsPerBasket, totalEggs;
		String openMessage = "This program will ask how many baskets of eggs you have\nand how many eggs are in each basket and then\ngive you the total amount of eggs";
		
		// end of variable declaration
		JOptionPane.showMessageDialog(null, openMessage); // show openmessage to user prompt for inout next
		
		// input is done here
		numberOfBaskets = Integer.parseInt(JOptionPane.showInputDialog(null, "How many baskets are there?"));
		eggsPerBasket = Integer.parseInt(JOptionPane.showInputDialog(null, "How many eggs are in each basket?"));
		
		// the input is now totaled for output here
		totalEggs= numberOfBaskets * eggsPerBasket;
		JOptionPane.showMessageDialog(null,"If you have" + eggsPerBasket + " eggs per basket and " + numberOfBaskets + " baskets, then ");
		
		if (totalEggs==60)
		{
			JOptionPane.showMessageDialog(null, "you know how many eggs there are... :/");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "the total number of eggs is " + totalEggs);
		}
	}
}
import java.util.*;

public class DivideTwo
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int numerator;
		int denominator;
		
		System.out.println("This program divides two numbers. Put zero in denominator to end");
		
		
		do {
		System.out.print("\n\nEnter the numerator: ");
		numerator = keyboard.nextInt();
		System.out.print("Enter the denominator: ");
		denominator = keyboard.nextInt();

		System.out.print(numerator + "/" + denominator + " = ");
		System.out.println((double) numerator/denominator);
		} while (!(denominator < 1) );
	}
}
import java.util.Scanner; // Scanner object was not imported into class

public class SwitchErrors
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); //constructor not invoked correctly

		System.out.println("Key: 1=blue, 2=red, 3=green");
		System.out.print("Enter an number and I'll return ");
		System.out.print(" the corresponding color. ");
		int number = keyboard.nextInt(); // corrected integer declaration

		switch(number) // correcting integer declaration fixed variable not found error
		{
			case 1:
				System.out.println("You choose red!");
				break;
			case 2:
				System.out.println("You choose blue!");
				break;
			case 3:
				System.out.println("You choose green!");
			default:
				System.out.println("Color not available!");
				break;
		}

	}
}
import java.util.Scanner;

public class PersonalHello
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Computer Programming!");
		
		String name, last;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter your full name. ");
		name=keyboard.next();
		last=keyboard.next();
		System.out.print("Welcome, " + name + " " + last + "!"); // yaay
	}
}
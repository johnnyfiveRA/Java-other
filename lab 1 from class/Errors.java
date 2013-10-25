import java.util.Scanner; // added to fix scanner not defined

public class Errors
{
    public static void main(String[] args)
    {
        System.out.println("Can you spot and fix the errors?"); // string not closed

        System.out.println("Enter two numbers and I "); // not sure why you split these but i don't see 
        System.out.println("add them for you");         // anything wrong with it.

        int n1, n2;

        Scanner keyboard = new Scanner(System.in);   // no ; to end statement scanner not defined (import statement missing)
        n1 = keyboard.nextInt();  // method not defined in this context did you mean keyboard.nextInt();
        n2 = keyboard.nextInt();  // method not defined in this context did you mean keyboard.nextInt();

        System.out.println("The sum of the numbers is"); // the full access to the function is System.out.println
        System.out.println(n1 + n2); // this did add anything it has been corrected           
    }
}

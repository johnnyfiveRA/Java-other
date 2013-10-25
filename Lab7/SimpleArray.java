import java.util.Scanner;

public class SimpleArray
{
   public static void main(String args[])
   {
       int[] myArray;
       int count;
       Scanner kb = new Scanner(System.in);
       
       System.out.println ("How many numbers do you have?");
       count = kb.nextInt();
       myArray = new int[count];
       
       // Read and store values in array
       for (int i = 0; i < myArray.length; i++)
       {
            System.out.print ("Enter number " + (i + 1) + ": ");
            myArray[i] = kb.nextInt();
       }
       
       for (int i = 0; i < myArray.length; i++)
       {
            System.out.println (myArray[i]);
            
       }
       // myArray[7]= 5; this is bad
   }
}

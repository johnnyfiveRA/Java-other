import java.util.Scanner;

public class Student
{
    private String name;
    private int[] grade;
    
    // this variable is redundant given the class methods  private double average; 
    
    private Scanner kb = new Scanner(System.in);
    
    public Student()
    {  
        // Implement this constructor to set default student's name to "No name yet", set default average to 0
    	
    	name= " No name yet";
    	// average = 0.0; no longer necessary 
    }
    
    public void nameInput()
    {                
        // Implement this method to prompt for student's name and store it in name
    	
    	System.out.println("Please enter the student's full name");
    	name = kb.nextLine();
    }

    public void gradeInput()
    {
        int count = 0;
        
        System.out.print ("How many grades for this student? ");
        count = kb.nextInt();
        grade = new int[count];
        int gradeValidate=0;
        
        // Add a for loop here to prompt and read in student's grades and store them in grade array
       
        for (int y=0; y < count; y++)
       {
    	   System.out.println("Please enter grade number " + (y+1) ); 
    	   gradeValidate=kb.nextInt();
    	   
    	   while (gradeValidate < 0 || gradeValidate > 100 ) // this loop makes sure the right grade is entered 
    	   { 
    		   System.out.println("Invalid grade entered. Grade must be above or equal to 0 and less than or equal to 100");
    		   gradeValidate=kb.nextInt();
    	   }
    	   // validate loop over still in for loop
    	   
    	   grade[y]=gradeValidate; // store validated grades into grade array
    	   
       } // for loop ends here
    // there is nothing else for the class to do
    }
    
    public double getAverage()
    {
        // Implement this method to add up values from grade array and return the average
        // It should not be returning 0
    	
    	int gradesAdded=0;
    	
    	int x=0; // loop counter delcared outside of loop for use in dividing the total of the grades
    	
    	for (x=0; x< grade.length; x++)
    	{
    		gradesAdded += grade[x]; // this adds all of the grades from the array for the first step of averaging
    		
    	}
    	
    	return (float)gradesAdded/(float)x; // this is why x is delcared outside of the loop the total/number of grades
    	
    }
    
    public void printReport()
    {
        System.out.println ();
        System.out.println ("Student's name: " + name);
        System.out.print ("Student's grades: " );
        for (int i = 0; i < grade.length; i++)
        {
        	   
        	System.out.print (grade[i] + "\n" + "\t\t  ");
        
        }
        System.out.println ("\n" + "Average: " + getAverage());
    }
}

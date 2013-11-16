import java.io.Serializable;

import javax.swing.JOptionPane;

// if we are going to get the GUI thing to work we need to import Joptionpane and possibly use the StudentFile in this class

@SuppressWarnings({ "serial" }) // this gets rid of the "no long serial ID warning
public class Student implements Serializable
{
    private String name; // name of student
    private int[] grade; // array that holds student grades
    private int currentTest = 0; // the current test score grabbed from the gui
    private double average; // the computed average
    
    public static transient Gui UseMe= new Gui(); //instance of Gui that will be displayed to user. This doesn't need to be here. 
    
    
    // end of fields
    
    public Student()
    {  
        name = "None";
        average = 0;
    }
    
    public Student(Object obj)
    {
    	name = ((Student) obj).getName();
    	grade= ((Student) obj).getGrade();
    	average= ((Student) obj).getAverage();
    	
    	// UseMe = UseMe;
    }
    
    public Student(Student param)
    {
    	name = param.getName();
    	grade = param.getGrade();
    	average = param.getAverage();
    }
    
    public static void runUI() //this is called to make the GUI visible
    {
    	UseMe.Make();
    }
    
    public void nameInput()
    {                
    	name = ""; // surprisingly this is important it prevents null pointer exception from canceling the dialog below
    	while(name.equals(""))
    	{
    		name = JOptionPane.showInputDialog(null, "Enter student's name: ");
    		
    		if (name == "null" || name == null)
    			break;
    	 // this looks retarded but is necessary to prevent a null pointer exception in other methods that
    	}	// are called after this one.
         // uses JOptionPane to get user input also checks to make sure an
    }
    
    public String getName() // method was added to pass name to filestream constructors
    {
    	return name;
    }
    
    
    public void setcurrentTest(int input) // this is to set the testscore so that it can be checked and then put into the array
    {
    	currentTest = input;
    }
    
    
    public int gradeInput() // this method needed to be heavily modified to be used with my GUI
    {
        int count = 0;
        
        try
        {
        count = Integer.parseInt(JOptionPane.showInputDialog("How many grades for this student? "));
        }
        catch (NumberFormatException e)
        {
        	return -1; 
        }
        if (count > 0)
        	grade = new int[count];
        else
        	return -2;
        Gui.studentDisplay.setText("\nValid scores are from 0 to 100");
        
        for (int x=0; x<grade.length;x++)
        {
        	try
        	{
        	currentTest = Integer.parseInt(JOptionPane.showInputDialog("Enter grade number " + (x+1)));
        	}
        	catch(NumberFormatException e)
        	{
        		return -3;
        	}
        	while((currentTest < 0 || currentTest > 100))
        	{
        		try
        		{
        		currentTest=Integer.parseInt(JOptionPane.showInputDialog("Input out of bounds: please enter a valid test score"));
        		}
        		catch (NumberFormatException e)
        		{
        			return -4; // this will stop the process. 
        		}
        	}
        	Gui.studentDisplay.append("\nInput accepted\n");
        	grade[x]=currentTest;
        }
        
        return 0; // this is returned when every action completes successfully
    }
    
    public double getAverage()
    {
        int total = 0;
        for (int i = 0; i < grade.length; i++)
        {
            total = total + grade[i];
        }
        average = (double)total/grade.length;
        return average;
    }
    
    public String printReport()
    {        
        	String output = "Student name: " + name;
        	output += "\nStudent's grades: ";
        	for (int i = 0; i < grade.length; i++)
        	{
        		output += "\nTest Score " + (i+1) + ": " + (grade[i]);
        	}
        	output += ("\nAverage: " + average);
        return output;
        
    }
    
    public int[] getGrade()
    {
    	return grade;
    }
 
}

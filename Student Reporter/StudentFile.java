import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class StudentFile extends Student  {

	private static final String EXT = ".srp"; // file extension for binary files
	private static final String T_EXT = ".txt"; // file extension for text files
	
	private ObjectOutputStream studentOutput = null;
	private ObjectInputStream studentInput = null;
	private Student currentS;
	
	public StudentFile(Student param)
	{
			currentS = param; 
		// WARNNG!! THIS IS PASSED BY REFERENCE. 
		// OPERATIONS TO THIS OBJECT WITHIN CLASS WILL MODIFY PASSED OBJECT
	}
	
	public Student getStudentObject() // this returns pointer to current student being operated on
	{
		return currentS;
	}
	
	public boolean loadStu(String nameOfStudent)
	{
		/* This method loads a student object from a file into memory 
			it will redirect the pointer from the current Student (currentS) to one 
			loaded from a file. it returns true if everything works fine and 
			false if there is an exception that prevents this from happening 
		*/
		try
		{
			studentInput = new ObjectInputStream(new FileInputStream(nameOfStudent + EXT));
			Object obj =(Student)studentInput.readObject();
			currentS= new Student(obj);
			studentInput.close();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean writeStu()
	{
		/* This method will write the student object from memory to a file
		 * It returns true if it works correctly and false if any exceptions
		 * prevent this from happening
		 */
		try
		{
			studentOutput = new ObjectOutputStream(new FileOutputStream(currentS.getName() + EXT));
			studentOutput.writeObject(currentS);
			studentOutput.close();
		
		}
		catch(IOException e)
		{
			return false;
		}
		
		return true; // file written successfully	
	}
	
	public boolean deleteStu(String name)
	{
		File target = new File(name + EXT);
		File targetText = new File(name + T_EXT);
		
		if (target.delete() || targetText.delete())
		{
			currentS=null;
			return true;
		}
		else
			return false;
	}
	
	public boolean outputTextFile(Student currentS)
	{
		PrintWriter output;
		if (currentS==null)
			return false;
		try
		{
			output=new PrintWriter(new FileOutputStream(currentS.getName() + T_EXT));
			output.println("Student name: " + currentS.getName());
			output.println("Student's Grades: ");
			for (int i = 0; i < currentS.getGrade().length; i++)
        	{
        		output.println("\nTest Score " + (i+1) + ": " + (currentS.getGrade()[i])); // little sloppy but the array that is retrieved by getgrade() is directly referenced
        	}
			output.println("\nAverage: " + currentS.getAverage());
			output.close();
		}
		catch (IOException e) 
		{
			return false;
		}
			return true;
	}
	
}

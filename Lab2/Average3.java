import javax.swing.JOptionPane;
import java.io.IOException;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class Average3
{
	public static void main(String[] args) throws IOException
	{
		int num1 = 3;
		int num2 = 4;
		int num3 = 6;
		
		double average = (double)(num1 + num2 + num3)/3;
		String Saverage = Double.toString(average);
		byte data[]= Saverage.getBytes(); 
		String userPath= null;
		Path pathToFile;
		
		JOptionPane.showMessageDialog(null, "The average of " + num1 +
				" and " + num2 + " and " + num3 + " = " + average);
		
		
		int option=JOptionPane.showConfirmDialog(null, "Would you like to save this result to a file", "Save to a File ?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
				userPath = JOptionPane.showInputDialog("Specify the file and path you would like to make for your file");
			if (userPath != null){
				try {
					pathToFile = Paths.get(userPath);
				Files.write(pathToFile, data, CREATE, WRITE, APPEND); 
			} // end try
				catch (IOException x) 
				{
					JOptionPane.showMessageDialog(null, "File could not be created or opened");
				} // end catch
				finally {
					System.exit(-1);
				} // end finally
			}
		} // end if 
	}
}
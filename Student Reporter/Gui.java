import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Gui implements ActionListener
{
	private static final int MAX_AREA_H=20;
	private static final int MAX_AREA_L=20;
	private static final int MINIMUM_W=515;
	private static final int MINIMUM_H=300;
	private static final Dimension minSize = new Dimension (MINIMUM_W,MINIMUM_H);
	
	public static JTextArea studentDisplay = new JTextArea(MAX_AREA_H,MAX_AREA_L); // this is public so that any of the classes made can output to it. 
	
	private JButton newStudent = new JButton("Create new Student report");
	private JButton loadStudent = new JButton("Load Student report");
	private JButton deleteStudent = new JButton("Delete Student report");
	private JButton writeAsText = new JButton("Write current Student as a text file");
	
	
	// private static StudentAction actions;
	private Student currentS; // WARNING. MODIFICATIONS IN THIS CLASS WILL CHANGE VALUES OF PASSED OBJECT
	private StudentFile file; // WARNING MODIFICATIONS IN THIS CLASS WILL CHANGE VALUES OF PASSED OBJECT. 
	String name;
	
	
	public Gui() // constructor that creates a student instance which the user will interact with in the application
	{
		currentS=new Student();
		file = new StudentFile(currentS);
	}
	
	public void Make()
	{
		
		JFrame frame = new JFrame("Student Reporter"); // Main frame with label for application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(minSize);
		
		// container setup so that layout looks ok
		Container windowTopC = frame.getContentPane(); 
		Container windowEastC = frame.getContentPane();
		Container windowWestC = frame.getContentPane();
		
		// panel setup to put into appropriate containers 
		JPanel windowTop= new JPanel();
		JPanel windowEast= new JPanel();
		JPanel windowWest= new JPanel();
		
		windowTop.add(newStudent);
		windowTop.add(loadStudent);
		windowTop.add(deleteStudent);
		
		windowEast.add(studentDisplay);
		
		windowWest.add(writeAsText);
		
		// layouts for Containers are here
		windowTopC.add(windowTop, BorderLayout.NORTH);
		windowEastC.add(windowEast, BorderLayout.EAST);
		windowWestC.add(windowWest, BorderLayout.WEST);
		
		// below is where the actionListeners and actionCommands are setup for the buttons
		// , the commands are to direct the actionPerformed method to the right action
		
		newStudent.addActionListener(this);
		newStudent.setActionCommand("N"); // N for new
		loadStudent.addActionListener(this);
		loadStudent.setActionCommand("L"); // L for load
		deleteStudent.addActionListener(this);
		deleteStudent.setActionCommand("D"); // D for delete		
		writeAsText.addActionListener(this);
		writeAsText.setActionCommand("T");
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "N") // this is for new student
		{	
			currentS.nameInput();
			if(currentS.getName() != null)
			{
				studentDisplay.setText(currentS.getName() + " is being setup");
				if (currentS.gradeInput()==0)
				{
					currentS.getAverage();
					file.writeStu();
					studentDisplay.append("\n" + currentS.printReport());
				}	
			}
		}
		// end new student action
	
		if (e.getActionCommand() == "L") // this loads the student
		{
			name=JOptionPane.showInputDialog("Enter the name of the Student");
			if (name != null)
				{
						if(file.loadStu(name))
						{
							currentS=file.getStudentObject();
							studentDisplay.setText(name + " was loaded successfully\n");
							studentDisplay.append(currentS.printReport());
						}
						else
							studentDisplay.setText("Error opening student file.\nThe file may not exist or cannot be read.\n Click Load to try again."); // this method loads the student into memory
							
				}
		} 
		
		// end load student action
		if(e.getActionCommand()== "D") // this deletes the student
		{

			String name = JOptionPane.showInputDialog("Enter the name of the Student");
			if(name!=null)
			{
				int choice = JOptionPane.showConfirmDialog(null, "This action cannot be undone. Are you sure you wish do delete this student", "Delete Student", JOptionPane.YES_NO_OPTION);
			
				if(choice == 0)
				{
					if (file.deleteStu(name))
					{
						Gui.studentDisplay.setText("Student deleted");
						file = new StudentFile(currentS);
					}
					else
						Gui.studentDisplay.setText("Error deleting File");
				}
			}
			else
				Gui.studentDisplay.setText("Operation canceled ");
		}
		// end delete student action
	
		if(e.getActionCommand()=="T") // this is for the writing the loaded student to a text file.
		{
			if(currentS.getName().equals("None"))
				Gui.studentDisplay.setText("There is no student loaded.\nEither create a new student or load a file\nto perform this action");
			else if(!file.outputTextFile(currentS))
					Gui.studentDisplay.setText("\nError writing text file");
			else
			{
				Gui.studentDisplay.append("\nFile was made successfully\nand contains the following\n");
				Gui.studentDisplay.append(currentS.printReport());
			}
		}
		// end Write to text action		
	} // end of ActionListener

}

import java.awt.EventQueue;


public class StudentDemo
{
    public static void main (String[]args)
    {
    	EventQueue.invokeLater(new Runnable()
    	{	
    		public void run()
    		{
    			Student.runUI();
    		}
    	});
    }
}

public class ClockTest
{
	/** Test driver to exercise the AlarmClock class */
	public static void main(String args[])
	{
		Clock[] myClock = new Clock[3];
		myClock[0] = new Clock(9, 10, 15);
		myClock[1] = new Clock(10, 20, 30);
		myClock[2] = new Clock(11, 30, 41);
		
		for (int i = 0; i < myClock.length; i++)
		{
		    System.out.println("\nPrinting clock number " + (i + 1));
		    System.out.println(myClock[i].toString());
		}
	}
}
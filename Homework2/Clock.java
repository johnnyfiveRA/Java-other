public class Clock
{
	//Instance variables
	public int hours;
	public int minutes;
	public int seconds;
	public boolean displaySeconds;

	//Class Methods
	public void setHour(int hour)
	{
		hours = hour;
	}

	public void setMinutes(int min)
	{
		minutes = min;
	}

	public void setSeconds(int sec)
	{
		seconds = sec;
	}

	public void setDisplaySeconds(boolean set)
	{
		displaySeconds = set;
	}

	public int getHour()
	{
		return hours;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public int getSeconds()
	{
		return seconds;
	}

	public boolean showSeconds()
	{
		return displaySeconds;
	}

	public void displayTime()
	{
		if(showSeconds())
		{
			System.out.print("The current time is ");
			System.out.print(hours + ":" + minutes);
			System.out.println(":" + seconds);
		}
		else
		{
			System.out.print("The current time is ");
			System.out.println(hours + ":" + minutes);
		}
	}

}
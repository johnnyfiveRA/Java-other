
public class ClockTest
{
    @SuppressWarnings("unused")
	public static void main(String[] args)
    {
        Clock myClock = new Clock();
        Clock yourClock = new Clock();
        
        myClock.setHour(10);
        myClock.setMinutes(15);
        myClock.setSeconds(47);

        myClock.setDisplaySeconds(false);
        myClock.displayTime();
        
        yourclockcloning:
        {
        yourClock.setHour(myClock.getHour());
        yourClock.setMinutes(myClock.getMinutes());
        yourClock.setSeconds(myClock.getSeconds());
        yourClock.setDisplaySeconds(myClock.showSeconds());
        }
        
        
        myClock.setHour(0);
        myClock.displayTime();
        
       // yourClock.setHour(12);
        System.out.println("yourClock cloned from myClock before change");
        yourClock.displayTime();
        System.out.println("myClock after change and after yourClock was made from it.");
        myClock.displayTime();
        
    }
}
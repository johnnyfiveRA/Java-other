package john.StopWatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class StopWatchActivity extends Activity {
    /** Called when the activity is first created. */
    
    public long begin;
    public long end; 
    
    public Button start;
    public Button stop;
    public Button reset;
    public Chronometer timer;
    final public String result = "Elapsed time was ";
    TextView Time;
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
                
        start = (Button)findViewById(R.id.Start);
        stop  = (Button)findViewById(R.id.Stop);
        reset = (Button)findViewById(R.id.Reset);
        timer = (Chronometer)findViewById(R.id.chronometer1);
        Time =  (TextView)findViewById(R.id.textView1);
        
        // this entire portion below could potentially be made into another class so it is more modular. look into that

        start.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                	// this code starts the stop watch. we will use the chronometer to output this and the 
                	begin = SystemClock.elapsedRealtime();
                	timer.setBase(SystemClock.elapsedRealtime());
                	timer.start(); 
                	stop.setOnClickListener(new View.OnClickListener() {
						// this code stops the stopwatch
						public void onClick(View v) {
							end = SystemClock.elapsedRealtime();
							timer.stop();
							Time.setText(result + ((end-begin)/1000) ); // outputs text to view and then displays elapsed time as converted from the standard milliseconds to regular seconds
							// check if textview will work on it's on without using this setContentView(R.layout.main);
							end= 000;
							begin=000;
						}
					}); // I'm going to see a lot of this aren't I
                	reset.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							timer.stop();
							Time.setText(null);
						}
					});
                	}
        }); // I don't know why this method needs to look like this
        
        }
}
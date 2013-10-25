package john.Hello;

import android.app.Activity; // allows for android development
import android.os.Bundle;    // API? 
import android.widget.TextView; // to display text for hello world function



public class FirstAndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // code above this seems standard fare for android creation. onCreate appears to be the "main" function
        
        TextView words = new TextView(this);
        words.setText("This is an android application");
        setContentView(words);
        
    }
}
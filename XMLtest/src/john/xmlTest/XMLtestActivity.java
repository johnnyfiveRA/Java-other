package john.xmlTest; 
/* just a comment either my computer is slow as balls or the emulator is fucking horrible
 * I can literally export the apk file and then install it on the device and then run it before
 * this piece of shit virtual device even boots. :( 
 * Seriously what a piece a shit. Actual advice from stack overflow: test it the way I did 
 * I wondered why there were debug features everywhere in the OS. edit:indeed, logcat sees all wow
 * oh Christ 10 minutes into booting the fucking virtual device I get a system message saying "System not responding"
 * it's asking me if I want to close the system process. Really? 
 * 
 * Emulator uses one thread n a multi-core system..... wow what a piece of garbage. 
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class XMLtestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) { // main
        super.onCreate(savedInstanceState); // don't know what this does yet
        setContentView(R.layout.main);
        
        Button exit;
        exit = (Button)findViewById(R.id.exit); // explained below
        
        /* most of the items below were copied from googles android tutorial 
         * "http://developer.android.com/resources/tutorials/localization/index.html"
         * I have adapted the code to my own purposes but it still does a similar thing 
         * 
         * R.<object>.<id> is generated automatically from an XML file which points to resources 
         * The R object allows the Activity (main method) to reference resources without
         * defining them through paths and whatnot in the class itself. 
         * For example  the variable exit is a button to be displayed and/or touch/clicked on but in order for it to be used
         * The compiler needs to know where it is on the display. That is what the XML and subsequently the R object is for.
         *  
         * For R.<stuff to use>, So far I've seen R.attr which for this activity is empty, R.drawable (which points to pictures to
         * be drawn or used),R.id (which references id tags of resources), R.layout (layout of the display where text, buttons,
         * and images are displayed and stuff), and R.string which can hold string values to be referenced 
        	
        	Basically what line 18 is doing is telling the system to look within the R.id object and find exit then 
        	associate thispart of the display to the button. So that exit is the button on the screen which was defined 
        	by the XML file. 
        	Fucking complicated this android stuff is. 
        */
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this /* what is 'this' exactly */); // is there a reason why this constructor can't take the following fields?
        builder.setMessage(R.string.dialog_text) // all of these things must be private class fields but why are they filled this way? 
        	.setCancelable(false)
        	.setTitle(R.string.dialog_title)
        	.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { // what is up with defining methods like this another one at 64
            dialog.dismiss(); 
            finish(); // closes application this method is being called within the setPositivebutton field and is done
            // after the dialog is dismissed this should work perfectly
            }
        }); // again a PITA to read but I follow what line 21 starts. Filling in class fields I think.
        
        final AlertDialog alert = builder.create();
        
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // why is a method definition in a method call? does this method get passed a method?
                alert.show();
            }  // had the original finish method here but it caused a windowLeaked exception it is fixed now.
        });
        // jesus christ this is hard to read. spent 5 minutes trying to figure out I didn't copy everything right
        // and missed a parenthesis to end the method call. Ask teacher about this may have tips. 
    }
}  

// app works as intended

// I think the reason oracle sued google is not because they used java API's without permission but because they created their 
//own API based on the structure of java. still don't know what oracle was thinking though. 
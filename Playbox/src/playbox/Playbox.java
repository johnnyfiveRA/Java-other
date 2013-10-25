package playbox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/* this program is made to test out how to make dialog boxes
*/

public class Playbox {

	public static void main(String[] args) {
		
		// making a title for the messageboxes
		JFrame frameO = new JFrame ("Opening");
		JFrame frameI = new JFrame ("Input Please");
		JFrame frameE = new JFrame ("Program done");
		
		JOptionPane.showMessageDialog(frameO, "This is a dialog box");
		String thing = JOptionPane.showInputDialog(frameI, "Please type something into this ");
		JOptionPane.showMessageDialog(frameE, "You just Typed \"" + thing + "\"");
	}

}
